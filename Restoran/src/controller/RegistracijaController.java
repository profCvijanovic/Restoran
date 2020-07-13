package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Rola;
import model.User;
import service.RegistracijaService;

/**
 * Servlet implementation class RegistracijaController
 */
@WebServlet(description = "ovo je servlet za registraciju", urlPatterns = { "/RegistracijaController" })
public class RegistracijaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RegistracijaService service = new RegistracijaService();
		
		//prihvatamo parametre iz requesta
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		
		//prolazimo validaciju
		boolean daLiSuPasswordIrepeatedPasswordIsti = service.daLiSuPasswordIrepeatedPasswordIsti(password,repeatedPassword);
		boolean daLiPassImaMinOsamKaraktera = service.daLiPassImaMinOsamKaraktera(password);
		
		if(daLiSuPasswordIrepeatedPasswordIsti && daLiPassImaMinOsamKaraktera) {
			//pravimo model
			User user = service.napraviMiUsera(userName,password);
			//snimamo usera u bazu
			boolean daLiJeSacuvanUser = service.sacuvajUsera(user);
			//vracamo view
			if(daLiJeSacuvanUser) {
				System.out.println("Sve ok!");
				response.sendRedirect("html_fajlovi/uspesno.html");
			}else {
				System.out.println("Nesto nije uspelo...");
				response.sendRedirect("html_fajlovi/registracija.html");
			}
		}else {
			response.sendRedirect("html_fajlovi/registracija.html");
		}	
	}

}
