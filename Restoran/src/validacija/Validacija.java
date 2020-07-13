package validacija;

import model.Admin;

public class Validacija {

	public boolean daLiSuPasswordIrepeatedPasswordIsti(String password, String repeatedPassword) {
		
		if(password.equals(repeatedPassword)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean daLiPassImaMinOsamKaraktera(String password) {		
		
		if(password.length() >= 8) {
			return true;
		}else {
			return false;
		}
	}

	public boolean daLiSeRegistrovaoAdmin(String userName, String password) {
		
		if(userName.equals(Admin.getAdminusername()) && password.equals(Admin.getAdminpassword())) {
			return true;
		}else {
			return false;
		}	
	}
	
	
	
	
	
	
	
	
}
