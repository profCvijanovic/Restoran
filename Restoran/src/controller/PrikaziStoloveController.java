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

import model.Sto;
import service.PrikaziStoloveService;

/**
 * Servlet implementation class PrikaziStoloveController
 */
@WebServlet(description = "prikaz slobodnih stolova", urlPatterns = { "/PrikaziStoloveController" })
public class PrikaziStoloveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrikaziStoloveService service = new PrikaziStoloveService();
		
		List<Sto> slobodniStolovi = new ArrayList<Sto>();
		
		slobodniStolovi = service.vratiSveSlobodneStolove();
		
		if(slobodniStolovi == null) {
			response.sendRedirect("jsp/userPage.jsp");
		}else if(slobodniStolovi.isEmpty()) {
			response.sendRedirect("../html_fajlovi/popunjeniSviStolovi.html");
		}else {
			request.setAttribute("slobodniStolovi", slobodniStolovi);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/prikaziStoloveView.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
