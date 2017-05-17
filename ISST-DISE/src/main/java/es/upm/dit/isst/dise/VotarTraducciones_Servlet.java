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

import es.upm.dit.isst.dise.dao.DISEDAO;
import es.upm.dit.isst.dise.dao.DISEDAOImpl;
import es.upm.dit.isst.dise.model.Emoji;
import es.upm.dit.isst.dise.model.Traduccion;

public class VotarTraducciones_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String imagen = request.getParameter("imagen");
		int traduccion = Integer.parseInt(request.getParameter("n"));

		Emoji emoji = null;
		DISEDAO dao = DISEDAOImpl.getInstancia();
		emoji = dao.leerEmoji(imagen);
		ArrayList<Traduccion> array = new ArrayList<Traduccion>();
		array.addAll(emoji.getTraducciones());
		long n = array.get(traduccion).getVotos();
		n++;
		array.get(traduccion).setVotos(n);
		
		for(int x=1; x< array.size(); x++){
			Traduccion m = array.get(0);
			if(array.get(x).getVotos() > m.getVotos()){
				m = array.remove(x);
				array.add(0, m);
			}
		}
		
		
		emoji.setTraducciones(array);
		dao.actualizarEmoji(emoji);
		
		ArrayList<Traduccion> traducciones = new ArrayList<>();
		ArrayList<Traduccion> validadas = new ArrayList<>();
		traducciones = emoji.getTraducciones();
		
		for(int x = 0; x < traducciones.size(); x++){		
			if(traducciones.get(x).isValidado()){
				validadas.add(traducciones.get(x));
			}		
		}
		
		UserService userService = UserServiceFactory.getUserService();
		
		request.getSession().setAttribute("validadas", validadas);

		request.getSession().setAttribute("emoji", emoji);

		RequestDispatcher view = request.getRequestDispatcher("Votacion.jsp");
		view.forward(request, response);
	}

}
