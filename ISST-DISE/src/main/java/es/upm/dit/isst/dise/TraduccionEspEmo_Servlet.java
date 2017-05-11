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

public class TraduccionEspEmo_Servlet extends HttpServlet{
	
	// pasar el html a capon como string, con <p> y cerrando p al meter imagen float
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DISEDAO dao = DISEDAOImpl.getInstancia();
		ArrayList<Emoji> emojis = new ArrayList<>();
		emojis.addAll(dao.leerTodosEmojis());
		
		String[] traducciones = new String[emojis.size()];
		for (int i = 0; i < traducciones.length; i++) {
			traducciones[i] = emojis.get(i).getTraducciones().get(0).getTraduccion();
		}
		String textoATraducir=request.getParameter("escrito");
		
		request.getSession().getAttribute("textoATraducir");
		String[] parts = textoATraducir.split("\\s++");
		
		String textoFinal="";
		//String textoFinal="<p>";
		String palabraI = null;
		int saltaNPalabras = 0;
		boolean flag=false;
		for (int i = 0; i < parts.length; i++) {
			palabraI = parts[i];
			if (saltaNPalabras > 0){
				saltaNPalabras--;
				continue;
			}
			String[] partsTraduccion = null;
			for (int j = 0; j < traducciones.length; j++) {
				partsTraduccion = traducciones[j].split(" ");
				if (partsTraduccion.length > 1){
					if (palabraI.equals(partsTraduccion[0]) ){
						int size = partsTraduccion.length;
						if (i+size <= parts.length){
							for (int k = 1; k < size; k++) {
								if (parts[i+k].equals(partsTraduccion[k])){
									if(k==(size-1)){
										saltaNPalabras=size-1;
										flag=true;
										textoFinal += "<img src='"+emojis.get(j).getImagen() +"' width='30px' height='30px'/>";
										//textoFinal += "</p><img src='"+emojis.get(j).getImagen() +"' width='30px' height='30px'/><p>";
									}
									continue;
								}
								break;
							}
							
						}
					}
				}
				else if(palabraI.equals(traducciones[j])){
					flag=true;
					textoFinal += "<img src='"+emojis.get(j).getImagen() +"' width='30px' height='30px'/>";
					//textoFinal += "</p><img src='"+emojis.get(j).getImagen() +"' width='30px' height='30px'/><p>";
					break;
				}
				
			}
			if (flag){
				flag=false;
				continue;
			}
			textoFinal += palabraI;
		}
		//textoFinal += "</p>";
		
		request.getSession().setAttribute("textoFinal", textoFinal);
		response.sendRedirect("TraducirVista.jsp");
	}
	
	
}
