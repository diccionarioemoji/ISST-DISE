package es.upm.dit.isst.dise;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.dise.dao.DISEDAO;
import es.upm.dit.isst.dise.dao.DISEDAOImpl;
import es.upm.dit.isst.dise.model.Emoji;

public class ISST_DISE_Servlet extends HttpServlet {
	@Override
	public void init() throws ServletException { // Se ejecuta cuando se inicia
													// por primera vez el
													// servlet
		ObjectifyService.register(Emoji.class);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(request.getRequestURI());
		String urlLinktext = "Login";
		String user = "";
		
		DISEDAO dao = DISEDAOImpl.getInstancia();
		Emoji emoji1 = null;
		ArrayList<Emoji> emojis = new ArrayList<>();
		
		dao.crearEmoji("favicon.ico", "sergio", "Esto es un favicon");
		emoji1 = dao.leerEmoji("favicon.ico");
		
		if (request.getUserPrincipal() != null) {
			user = request.getUserPrincipal().getName();
			url = userService.createLogoutURL(request.getRequestURI());
			urlLinktext = "Logout";
			emojis.addAll(dao.leerTodosEmojis());
		}
		/*
		ArrayList<Traduccion> array = new ArrayList<Traduccion>();
		array.add(new Traduccion("Unfavicon", "Javi"));
		emoji1 = new Emoji("favicon.ico", "sergio", array);
		*/
		
		
		//response.getWriter().println(emoji1);
		
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("url", url);
		request.getSession().setAttribute("urlLinktext", urlLinktext);
		request.getSession().setAttribute("emojis", emojis);
		request.getSession().setAttribute("emoji1", emoji1);
		
		
		RequestDispatcher view = request.getRequestDispatcher("TraducirVista.jsp");
		view.forward(request, response);
		
	}
	
	
	
	

}
