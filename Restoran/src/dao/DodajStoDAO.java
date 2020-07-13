package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Sto;

public class DodajStoDAO {
	
	
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public boolean sacuvajSto(Sto sto) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			sesija.save(sto);
			System.out.println("Sacuvao sam sto " + sto.getBrojStola());
			sesija.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Nisam sacuvao sto...");
			sesija.getTransaction().rollback();
			return false;
		}finally {
			sesija.close();
		}
	}

}
