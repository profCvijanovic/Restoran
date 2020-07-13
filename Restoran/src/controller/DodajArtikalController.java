package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artikal;
import service.DodajArtikalService;

/**
 * Servlet implementation class DodajArtikalController
 */
@WebServlet(description = "dodavanje artikala u bazu", urlPatterns = { "/DodajArtikalController" })
public class DodajArtikalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DodajArtikalService service = new DodajArtikalService();
		
		String cena = request.getParameter("cena");
		String ime = request.getParameter("ime");
		String stanje = request.getParameter("stanje");
		String popust = request.getParameter("popust");
		
		Artikal artikal = service.napuniArtikal(cena,ime,stanje,popust);
		
		boolean daLiJeSacuvanArtikal = service.sacuvajArtikal(artikal);
		
		if(daLiJeSacuvanArtikal) {
			response.sendRedirect("jsp/adminPage.jsp");
		}else {
			response.sendRedirect("html_fajlovi/dodajArtikal.html");
		}
		
		
		
		
		
	}

}
