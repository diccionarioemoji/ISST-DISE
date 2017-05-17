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

public class adminTrad_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String imagen = request.getParameter("imagen");
		String traduccion = request.getParameter("traduccion");
		String submit = request.getParameter("submit");
		Emoji emoji = null;
		DISEDAO dao = DISEDAOImpl.getInstancia();
		emoji = dao.leerEmoji(imagen);
		ArrayList<Traduccion> array = new ArrayList<Traduccion>();
		ArrayList<Traduccion> traducciones = new ArrayList<Traduccion>();
		array.addAll(emoji.getTraducciones());
		for(int x=0; x < array.size(); x++){
			System.out.println(array.get(x).getTraduccion());
			System.out.println(traduccion);
			if(array.get(x).getTraduccion().equals(traduccion)){
				if(submit.equals("Aceptar")){
					Traduccion n = array.get(x);
					n.setValidado(true);
					traducciones.add(n);
				}else{
				}
			}else{
				Traduccion n = array.get(x);
				traducciones.add(n);
			}
		}
		
		emoji.setTraducciones(traducciones);
		dao.actualizarEmoji(emoji);
		
		ArrayList<Traduccion> validadas = new ArrayList<>();
		ArrayList<Traduccion> noValidadas = new ArrayList<>();
		traducciones = emoji.getTraducciones();
		
		for(int x = 0; x < traducciones.size(); x++){
			
			if(traducciones.get(x).isValidado()){
				validadas.add(traducciones.get(x));
			}
			else{
				noValidadas.add(traducciones.get(x));
			}
			
		}
		
		UserService userService = UserServiceFactory.getUserService();
		
		request.getSession().setAttribute("validadas", validadas);
		request.getSession().setAttribute("noValidadas", noValidadas);
		request.getSession().setAttribute("emoji", emoji);
		
		RequestDispatcher view = request.getRequestDispatcher("VotacionAdmin.jsp");
		view.forward(request, response);
	}
	
}