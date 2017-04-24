package es.upm.dit.isst.dise;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.dise.dao.DISEDAO;
import es.upm.dit.isst.dise.dao.DISEDAOImpl;
import es.upm.dit.isst.dise.model.Emoji;

public class Votacion_Servlet extends HttpServlet {
	//public String seleccionado;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DISEDAO dao = DISEDAOImpl.getInstancia();
		String nemoji = req.getParameter("escrito");
		Emoji emoji = null;
		emoji = dao.leerEmoji(nemoji);
		
		req.getSession().setAttribute("emoji", emoji);
		
		RequestDispatcher view = req.getRequestDispatcher("Votacion.jsp");
		view.forward(req, resp);
	}

}
