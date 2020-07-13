package service;

import dao.RegistracijaDAO;
import model.User;
import razno.Common;
import validacija.Validacija;

public class RegistracijaService {
	
	Validacija validacija = new Validacija();
	RegistracijaDAO dao = new RegistracijaDAO();
	Common common = new Common();
	
	
	public boolean daLiSuPasswordIrepeatedPasswordIsti(String password, String repeatedPassword) {
		return validacija.daLiSuPasswordIrepeatedPasswordIsti(password, repeatedPassword);
	}


	public boolean daLiPassImaMinOsamKaraktera(String password) {
		return validacija.daLiPassImaMinOsamKaraktera(password);
	}


	public boolean daLiSeRegistrovaoAdmin(String userName, String password) {
		return validacija.daLiSeRegistrovaoAdmin(userName, password);
	}


	public User napraviMiUsera(String userName, String password) {
		return common.napraviMiUsera(userName,password);
	}


	public boolean sacuvajUsera(User user) {
		return dao.sacuvajUsera(user);
	}

}
