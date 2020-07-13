package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sto;
import service.DodajStoService;

/**
 * Servlet implementation class DodajStoController
 */
@WebServlet(description = "servlet za dodavanje stolova", urlPatterns = { "/DodajStoController" })
public class DodajStoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DodajStoService service = new DodajStoService();
		
		String broj = request.getParameter("broj");
		
		Sto sto = service.napuniSto(broj);
		
		boolean daLiJeDodaoSto = service.sacuvajSto(sto);
		
		if(daLiJeDodaoSto) {
			response.sendRedirect("jsp/adminPage.jsp");
		}else {
			response.sendRedirect("html_fajlovi/dodajSto.html");
		}
		
		
	}

}
