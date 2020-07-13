package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Artikal;

public class DodajArtikalDAO {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public boolean sacuvajArtikal(Artikal artikal) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			sesija.save(artikal);
			System.out.println("Sacuvao sam artikal " + artikal.getIme());
			sesija.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Nisam sacuvao artikal...");
			sesija.getTransaction().rollback();
			return false;
		}finally {
			sesija.close();
		}
	}
	
	

}
