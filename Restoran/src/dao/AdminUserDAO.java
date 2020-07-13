package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class AdminUserDAO {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public List<User> vratiSveUsereIzBaze() {
		
		List<User> useri = new ArrayList<User>(); 
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			String upit = "from User";
			Query query = sesija.createQuery(upit);
			useri = query.getResultList();
			
			if( useri.size() == 0 ) {
				System.out.println("Ne postoje useri");
				sesija.getTransaction().commit();
				return null;
			}else {
				System.out.println("Evo svih usera iz tabele!");
				sesija.getTransaction().commit();
				return useri;
			}
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		}finally {
			sesija.close();
		}	
	}
	
	
	
	
	
	
	
	

}
