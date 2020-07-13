package service;

import java.util.List;

import dao.NapraviRacunDAO;
import model.Artikal;
import model.StavkaRacuna;
import model.Sto;
import razno.Common;

public class NapraviRacunService {
	
	NapraviRacunDAO dao = new NapraviRacunDAO();
	Common common = new Common();  
	
	public List<Sto> napraviListuStolova(List<String> listaStolovaId) {
		return dao.napraviListuStolova(listaStolovaId);
	}

	public List<Artikal> napraviListuArtikala(List<String> listaArtikalId) {
		return dao.napraviListuArtikala(listaArtikalId);
	}

	public List<StavkaRacuna> napraviStavkeRacuna(List<Artikal> listaArtikala, List<String> listaKolicina) {
		return common.napraviStavkeRacuna(listaArtikala,listaKolicina);
	}

	public double napraviRacunZaStavke(List<StavkaRacuna> stavke) {
		return common.napraviRacunZaStavke(stavke);
	}
	
	
	
	
	

}
