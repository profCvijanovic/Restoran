package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.PlatiRacunDAO;
import model.Racun;
import model.StavkaRacuna;
import razno.Common;

public class PlatiRacunService {
	
	PlatiRacunDAO dao = new PlatiRacunDAO();
	Common common = new Common();
	
	public boolean snimiRacunUBazu(Racun racun) {
		return dao.snimiRacunUBazu(racun);
	}
	public void smanjiBalance(int idUser, double total) {
		dao.smanjiBalance(idUser,total);
		
	}
	public void regulisiKolicine(List<StavkaRacuna> stavke) {
		dao.regulisiKolicine(stavke);
		
	}
	public void snimiTransakciju(Racun racun) {
		dao.snimiTransakciju(racun);
		
	}



}
