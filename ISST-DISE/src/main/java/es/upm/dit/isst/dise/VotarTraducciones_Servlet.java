package es.upm.dit.isst.dise;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.dise.dao.DISEDAO;
import es.upm.dit.isst.dise.dao.DISEDAOImpl;
import es.upm.dit.isst.dise.model.Emoji;
import es.upm.dit.isst.dise.model.Traduccion;

public class VotarTraducciones_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		emoji.setTraducciones(array);
		dao.actualizarEmoji(emoji);
		
		request.getSession().setAttribute("emoji", emoji);
		
		RequestDispatcher view = request.getRequestDispatcher("Votacion.jsp");
		view.forward(request, response);
	}
	
}
