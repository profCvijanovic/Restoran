package vezba;

public class ServiceVezba {
	
	VezbaDao dao = new VezbaDao();

	public boolean sacuvajKorisnika(KorisnikVezba korisnik) {
		return dao.sacuvajKorisnika(korisnik);
	}
	
	
}
