package service;

import dao.DodajArtikalDAO;
import model.Artikal;
import razno.Common;

public class DodajArtikalService {
	
	DodajArtikalDAO dao = new DodajArtikalDAO();
	Common common = new Common();
	
	public Artikal napuniArtikal(String cena, String ime, String stanje, String popust) {
		return common.napuniArtikal(cena,ime,stanje,popust);
	}
	public boolean sacuvajArtikal(Artikal artikal) {
		return dao.sacuvajArtikal(artikal);
	}

}
