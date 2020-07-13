package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Racun;
import service.PlatiRacunService;

/**
 * Servlet implementation class PlatiRacunController
 */
@WebServlet("/PlatiRacunController")
public class PlatiRacunController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PlatiRacunService service = new PlatiRacunService();
		
		
		Racun racun = (Racun)request.getSession().getAttribute("racun");
		
		if(racun.getUser().getBalance() >= racun.getTotal()) {
		
			//1. snimi racun u bazu
			boolean daLiJeSnimioRacun = service.snimiRacunUBazu(racun);
			if(daLiJeSnimioRacun) {
				//2. regulisi balance usera
				service.smanjiBalance(racun.getUser().getIdUser(),racun.getTotal());
				//3. regulisi kolicine
				service.regulisiKolicine(racun.getStavke());
				//4. zavedi transakciju
				service.snimiTransakciju(racun);

				response.sendRedirect("html_fajlovi/uspesnoPlacenRacun.html");
			}else {
				response.sendRedirect("html_fajlovi/nemaDovoljnoNaRacunu.html");
			}
		}else {
			response.sendRedirect("html_fajlovi/nemaDovoljnoNaRacunu.html");
		}
		
		
		
		
		
		
		
	}

}
