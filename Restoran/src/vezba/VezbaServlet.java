package vezba;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VezbaServlet
 */
@WebServlet(description = "ovaj servlet mi je prvi servlet i on mi sluzi za vezbu", urlPatterns = { "/VezbaServlet" })
public class VezbaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VezbaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(" Dobrodosli u doGet metodu");
		
		//Ovde se spajam sa service-om
		ServiceVezba service = new ServiceVezba();
		
		// prihvatamo parametre iz url-a(request-a)
		String ime = request.getParameter("ovdeJeIme");
		String prezime = request.getParameter("ovdeJePrezime");
		String pol = request.getParameter("pol");
		String punoletan = request.getParameter("check");
		boolean daLiJePunoletan;
		if(punoletan != null) {
			daLiJePunoletan = true;
		}else {
			daLiJePunoletan = false;
		}
	
		// Kreiram objekat koji zelim da snimimu bazu - MODEL
		KorisnikVezba korisnik = new KorisnikVezba();
			korisnik.setImeKorisnika(ime);
			korisnik.setPrezimeKorisnika(prezime);
			korisnik.setPol(pol);
			korisnik.setDaLiJePunoletan(daLiJePunoletan);
		
		// sacuvaj korisnika u bazi
		boolean daLiJeSacuvaoKorisnika = service.sacuvajKorisnika(korisnik);
		
		// saljemo view
		if(daLiJeSacuvaoKorisnika) {
			// posalji uspesno.html
			response.sendRedirect("html_fajlovi/uspesno.html");
		}else {
			// posalji neuspesno.html
			response.sendRedirect("html_fajlovi/neuspesno.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(" Dobrodosli u doPost metodu");
		
	}

}
