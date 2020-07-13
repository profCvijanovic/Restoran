package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artikal;
import service.OdaberiArtikalService;

/**
 * Servlet implementation class OdaberiArtikalController
 */
@WebServlet(description = "biramo artikle", urlPatterns = { "/OdaberiArtikalController" })
public class OdaberiArtikalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OdaberiArtikalService service = new OdaberiArtikalService();
		
		String[] odabraniStolovi = request.getParameterValues("idStola");
		List<String> stolovi = new ArrayList<String>();
		//provera parametara
		System.out.println("Odabrani su Stolovi sa brojevima: ");
		for(int i = 0; i< odabraniStolovi.length; i++) {
			System.out.println(odabraniStolovi[i]);
			stolovi.add(odabraniStolovi[i]);
		}
		
		
		List<Artikal> sviArtikliIzBaze = new ArrayList<Artikal>();
		
		sviArtikliIzBaze = service.vratiSveArtikleIzBaze();
		
		if(sviArtikliIzBaze == null) {
			response.sendRedirect("jsp/userPage.jsp");
		}else {
			
			request.setAttribute("sviArtikliIzBaze", sviArtikliIzBaze);
			request.setAttribute("stolovi", stolovi);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/prikaziArtikleView.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
	}

}
