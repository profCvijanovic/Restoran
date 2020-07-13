package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artikal;
import model.Racun;
import model.StavkaRacuna;
import model.Sto;
import model.User;
import service.NapraviRacunService;

/**
 * Servlet implementation class NapraviRacunController
 */
@WebServlet(description = "prikaz racuna", urlPatterns = { "/NapraviRacunController" })
public class NapraviRacunController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NapraviRacunService service = new NapraviRacunService();
		
		String[] idArtikala = request.getParameterValues("check");
		String[] kolicine = request.getParameterValues("kolicina");
		String[] idStolova = request.getParameterValues("idStolova");
		
		List<String> listaArtikalId = new ArrayList<String>();
		List<String> listaKolicina = new ArrayList<String>();
		List<String> listaStolovaId = new ArrayList<String>();
		
		
		for(int i = 0 ;i< idArtikala.length;i++) {
			listaArtikalId.add(idArtikala[i]);
		}
		
		for(int i = 0 ;i< kolicine.length;i++) {
			if(!kolicine[i].equals("0")) {
				listaKolicina.add(kolicine[i]);
			}	
		}
		
		for(int i = 0 ;i< idStolova.length;i++) {
			listaStolovaId.add(idStolova[i]);
		}
		
		User user = (User)request.getSession().getAttribute("user");
		
		List<Sto> listaStolova = service.napraviListuStolova(listaStolovaId);
		
		List<Artikal> listaArtikala = service.napraviListuArtikala(listaArtikalId);
		
		List<StavkaRacuna> stavke = service.napraviStavkeRacuna(listaArtikala,listaKolicina );
		
		double racunZaStavke = service.napraviRacunZaStavke(stavke);
		double baksis= 0.1*racunZaStavke;
		double total = racunZaStavke + baksis;
		
		Racun racun = new Racun();
		
			racun.setUser(user);
			racun.setIzabraniStolovi(listaStolova);
			racun.setStavke(stavke);
			racun.setRacunZaStavke(racunZaStavke);
			racun.setBaksis(baksis);
			racun.setTotal(total);
		
		request.getSession().setAttribute("racun", racun);
		
		response.sendRedirect("jsp/prikaziRacunView.jsp");
		
		
		
		
		
		
		
		
		
		
	}

}
