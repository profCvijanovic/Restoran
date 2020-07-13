package service;

import dao.DodajStoDAO;
import model.Sto;
import razno.Common;

public class DodajStoService {
	
	DodajStoDAO dao = new DodajStoDAO();
	Common common = new Common();

	public Sto napuniSto(String broj) {
		return common.napuniSto(broj);
	}

	public boolean sacuvajSto(Sto sto) {
		return dao.sacuvajSto(sto);
	}
	
	
	
	
	

}
