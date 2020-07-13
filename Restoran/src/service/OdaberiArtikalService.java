package service;

import java.util.List;

import dao.OdaberiArtikalDAO;
import model.Artikal;

public class OdaberiArtikalService {
	
	OdaberiArtikalDAO dao = new OdaberiArtikalDAO();

	public List<Artikal> vratiSveArtikleIzBaze() {
		return dao.vratiSveArtikleIzBaze();
	}
	
	
}
