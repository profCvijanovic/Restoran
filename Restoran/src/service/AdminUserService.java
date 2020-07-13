package service;

import java.util.List;

import dao.AdminUserDAO;
import model.User;

public class AdminUserService {
	
	AdminUserDAO dao = new AdminUserDAO();

	public List<User> vratiSveUsereIzBaze() {
		return dao.vratiSveUsereIzBaze();
	}
	
	
	

}
