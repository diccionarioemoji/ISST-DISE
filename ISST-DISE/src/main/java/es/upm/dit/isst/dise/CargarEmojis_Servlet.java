package es.upm.dit.isst.dise;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.dise.dao.DISEDAO;
import es.upm.dit.isst.dise.dao.DISEDAOImpl;
import es.upm.dit.isst.dise.model.Emoji;

public class CargarEmojis_Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DISEDAO dao = DISEDAOImpl.getInstancia();
		
		ArrayList<Emoji> emojis = new ArrayList<>();
		
		emojis.addAll(dao.leerTodosEmojis());
		
		req.getSession().setAttribute("emojis", emojis);
		
		resp.sendRedirect("VotarTraduccionVista.jsp");
	}

}
