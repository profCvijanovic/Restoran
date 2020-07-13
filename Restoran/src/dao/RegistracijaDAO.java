package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class RegistracijaDAO {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public boolean sacuvajUsera(User user) {
		
		Session sesija = factory.openSession();
			sesija.beginTransaction();
			try {
				sesija.save(user);
				System.out.println("Sacuvao sam usera " + user.getUserName());
				sesija.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Nisam sacuvao usera...");
				sesija.getTransaction().rollback();
				return false;
			}finally {
				sesija.close();
			}
	}
	
	
	
	

}
