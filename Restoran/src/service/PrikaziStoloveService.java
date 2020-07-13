package service;

import java.util.List;

import dao.PrikaziStoloveDAO;
import model.Sto;

public class PrikaziStoloveService {
	
	PrikaziStoloveDAO dao = new PrikaziStoloveDAO();

	public List<Sto> vratiSveSlobodneStolove() {
		
		return dao.vratiSveSlobodneStolove();
	}
	
	
	
}
