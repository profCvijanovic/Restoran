package service;

import dao.DodajBalanceDAO;

public class DodajBalanceService {
	
	DodajBalanceDAO dao = new DodajBalanceDAO();

	public boolean dodajBalance(String idUser, String balance) {
		return dao.dodajBalance(idUser,balance);
	}

}
