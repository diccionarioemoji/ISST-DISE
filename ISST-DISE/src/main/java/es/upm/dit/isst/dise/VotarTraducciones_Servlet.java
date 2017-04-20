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
		int traduccion = Integer.parseInt(request.getParameter("t"));
		
		Emoji emoji = null;
		DISEDAO dao = DISEDAOImpl.getInstancia();

		emoji = dao.leerEmoji(imagen);
		ArrayList<Traduccion> traducciones = (emoji.getTraducciones());
		long n = traducciones.get(traduccion).getVotos() + 1;
		traducciones.get(traduccion).setVotos(n);
		
		emoji.setTraducciones(traducciones);
		dao.actualizarEmoji(emoji);
		
		RequestDispatcher view = request.getRequestDispatcher("VotarTraduccionVista.jsp");
		view.forward(request, response);
	}
	
}
