package service;

import dao.LoginDAO;
import model.User;
import validacija.Validacija;

public class LoginService {
	
	LoginDAO dao = new LoginDAO();
	Validacija validacija = new Validacija();
	
	public User vratiUseraSaOvimUserNameom(String userName) {
		return dao.vratiUseraSaOvimUserNameom(userName) ;
	}

	public boolean uporediPassworde(String password, String password2) {
		return validacija.daLiSuPasswordIrepeatedPasswordIsti(password, password2);
	}
	

}
