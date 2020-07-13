package vezba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class VezbaDao {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public boolean sacuvajKorisnika(KorisnikVezba korisnik) {	
		
		Session sesija = factory.openSession();
			sesija.beginTransaction();	
			try {
				sesija.save(korisnik);
				sesija.getTransaction().commit();
				System.out.println("Korisnik je sacuvan.");
				return true;
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				System.out.println("Korisnik nije sacuvan.");
				return false;
			}finally {
				sesija.close();
			}	
	}
	
	

}
