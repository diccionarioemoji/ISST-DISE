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
		
		DISEDAO dao = DISEDAOImpl.getInstancia();
		String[] traduccionesIniciales = {"Preocupado",
		                                  "Despreocupado",
		                                  "Llor�n",
		                                  "Triste",
		                                  "Feliz ",
		                                  "Compungido",
		                                  "Decepcionado",
		                                  "Alegre",
		                                  "Contento",
		                                  "Divertido",
		                                  "Desternillado de risa",
		                                  "Un beso",
		                                  "Un beso cari�oso",
		                                  "Besito",
		                                  "Chincha",
		                                  "�Me encanta!",
		                                  "�En serio?",
		                                  "Avergonzado",
		                                  "Adormilado",
		                                  "Nervioso",
		                                  "Abrumado",
		                                  "Despistado",
		                                  "Cansado",
		                                  "Hasta los huevos ",
		                                  "Hasta la punta del pi�",
		                                  "Cagada m�xima",
		                                  "Alucinante",
		                                  "Cabreado",
		                                  "A punto de explotar",
		                                  "Enfadado",
		                                  "Asqueado",
		                                  "Risa",
		                                  "Simp�tico",
		                                  "Enfermo",
		                                  "Pro",
		                                  "Dormido",
		                                  "Muerto",
		                                  "Muerto con dentadura",
		                                  "�Qu�?",
		                                  "Horrorizado",
		                                  "Impactado",
		                                  "Perverso",
		                                  "Enfadado",
		                                  "�Oh!",
		                                  "Sonrisa forzada",
		                                  "Defraudado",
		                                  "Expectante",
		                                  "Mudo",
		                                  "Angel",
		                                  "Puto amo",
		                                  "Pokerface",
		                                  "B�lgaro",
		                                  "�rabe",
		                                  "Poli",
		                                  "Obrero",
		                                  "Guardia",
		                                  "Ni�o",
		                                  "Ni�a",
		                                  "Se�or",
		                                  "Se�ora",
		                                  "Abuelo",
		                                  "Abuela",
		                                  "Rubio",
		                                  "�ngel",
		                                  "Princesa",
		                                  "Gato Sonriente",
		                                  "Gato Gracioso",
		                                  "Gato Enamorado",
		                                  "Beso de Gato",
		                                  "Gato Picar�n",
		                                  "Gato Sorprendido",
		                                  "Gato Llorando",
		                                  "Gato Sonriendo",
		                                  "Gato Cabreado",
		                                  "Demonio Oni",
		                                  "Demonio Tengu",
		                                  "Prefiero no mirar",
		                                  "Prefiero no escuchar",
		                                  "Prefiero no hablar",
		                                  "Calavera",
		                                  "Alien",
		                                  "Helado de chocolate",
		                                  "Fuego",
		                                  "Chispas",
		                                  "Estrella",
		                                  "Estrella Fugaz",
		                                  "Choque",
		                                  "Enfado c�mic",
		                                  "Sudando",
		                                  "Gota de agua",
		                                  "Durmiendo",
		                                  "Viento",
		                                  "Oreja",
		                                  "Ojos",
		                                  "Nariz",
		                                  "Lengua",
		                                  "Boca",
		                                  "OK",
		                                  "Mal",
		                                  "Perfecto",
		                                  "Pu�etazo",
		                                  "Pu�o",
		                                  "Victoria",
		                                  "Hola",
		                                  "Alto",
		                                  "Palpar",
		                                  "Dedo arriba",
		                                  "Dedo abajo",
		                                  "Apuntar derecha",
		                                  "Apuntar izquierda",
		                                  "TOP",
		                                  "Rezar",
		                                  "Yo",
		                                  "Aplauso",
		                                  "Fuerza",
		                                  "Ni�o andando",
		                                  "Ni�o corriendo",
		                                  "�OLE!",
		                                  "Pareja",
		                                  "Familia",
		                                  "Pareja chicos",
		                                  "Pareja chicas",
		                                  "Pareja besandose",
		                                  "Pareja enamorada",
		                                  "Baile",
		                                  "Sorprendida",
		                                  "Para",
		                                  "Pija",
		                                  "Responder",
		                                  "Masaje cabeza",
		                                  "Cortarse el pelo",
		                                  "Pintarse las u�as",
		                                  "Casarse",
		                                  "Sorprendida",
		                                  "Triste",
		                                  "Hombre arrepentido",
		                                  "Sombrero de copa",
		                                  "Corona",
		                                  "Pamela",
		                                  "Deportiva",
		                                  "N�uticos",
		                                  "Sandalia",
		                                  "Tacones",
		                                  "Bota",
		                                  "Polo",
		                                  "Camisa con corbata",
		                                  "Camisa mujer",
		                                  "Vestido",
		                                  "Camiseta",
		                                  "Kimono",
		                                  "Bikini",
		                                  "Malet�n",
		                                  "Bolso",
		                                  "Bolso de mano",
		                                  "Monedero rosa",
		                                  "Gafas",
		                                  "Lacito",
		                                  "Paraguas",
		                                  "Pintalabios",
		                                  "Coraz�n amarillo",
		                                  "Coraz�n azul",
		                                  "Coraz�n violeta",
		                                  "Coraz�n verde",
		                                  "Coraz�n",
		                                  "Coraz�n partido",
		                                  "Amor",
		                                  "Radioamor",
		                                  "Corazones unidos",
		                                  "Coraz�n brillante",
		                                  "Corazones locos",
		                                  "Flechazo de amor",
		                                  "Carta de amor",
		                                  "Beso ",
		                                  "Anillo",
		                                  "Diamante",
		                                  "Persona",
		                                  "Gente",
		                                  "Charla",
		                                  "Huellas",
		                                  "Pensamiento",
		                                  "Beb�",
		                                  "Besito",
		                                  "Chincha ",
		                                  "Sonrojado",
		                                  "Sonrisa forzada",
		                                  "Gui�o",
		                                  "Co�a"};
		
		int maximo = traduccionesIniciales.length-1;
		fuera:for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if (i*100+j*10+k>maximo) break fuera;
					String imagen = "emojisIniciales/"+Integer.toString(i)+Integer.toString(j)+Integer.toString(k)+".png";
					dao.crearEmoji(imagen, "Developers", traduccionesIniciales[i*100+j*10+k]);
				}
			}
		}
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
		
		//if (request.getUserPrincipal() != null) {
			//user = request.getUserPrincipal().getName();
			//url = userService.createLogoutURL(request.getRequestURI());
			//urlLinktext = "Logout";
			emojis.addAll(dao.leerTodosEmojis());
		//}
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
