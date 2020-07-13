package razno;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Artikal;
import model.Rola;
import model.StavkaRacuna;
import model.Sto;
import model.User;
import validacija.Validacija;

public class Common {
	
	Validacija validacija = new Validacija();

	public User napraviMiUsera(String userName, String password) {
		
		User user = new User();
		
		user.setUserName(userName);
		user.setPassword(password);
		user.setBalance(0);
		//proveravam da li je admin
		boolean daLiSeRegistrovaoAdmin = validacija.daLiSeRegistrovaoAdmin(userName,password);
		if(daLiSeRegistrovaoAdmin) {
			user.setRola(Rola.ADMIN);
		}else {
			user.setRola(Rola.KORISNIK);
		}
		
		return user;
	}

	public Artikal napuniArtikal(String cena, String ime, String stanje, String popust) {
		
		Artikal artikal = new Artikal();
			artikal.setCena(Double.parseDouble(cena));
			artikal.setIme(ime);
			artikal.setKolicinaNaStanju(Integer.parseInt(stanje));
			artikal.setPopust(Double.parseDouble(popust));
		return artikal;
	}

	public Sto napuniSto(String broj) {
		
		Sto sto = new Sto();
		sto.setBrojStola(Integer.parseInt(broj));
		sto.setDaLiJeZauzet(false);
		
		return sto;
	}

	public List<StavkaRacuna> napraviStavkeRacuna(List<Artikal> listaArtikala, List<String> listaKolicina) {
	
		 List<StavkaRacuna> stavke = new ArrayList<StavkaRacuna>();
		
		 for(int i = 0; i < listaArtikala.size(); i++ ) {
			
			 StavkaRacuna sr = new StavkaRacuna();
			 sr.setArtikal(listaArtikala.get(i));
			 sr.setKolicina(Integer.parseInt(listaKolicina.get(i)));
			 stavke.add(sr);
		 }
		
		return stavke;
	}

	public double napraviRacunZaStavke(List<StavkaRacuna> stavke) {
		double racun = 0;
		
		for(StavkaRacuna sr: stavke) {
			
			double cena = sr.getArtikal().getCena();
			double popust = sr.getArtikal().getPopust();
			int kolicina= sr.getKolicina();
			
			racun += cena*kolicina*(100 - popust)/100;
		}
		
		return racun;
	}
	
	

}
