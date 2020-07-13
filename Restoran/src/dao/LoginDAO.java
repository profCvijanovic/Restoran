package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class LoginDAO {
	
	SessionFactory factory = HibernateUtil.createSessionFactory();

	public User vratiUseraSaOvimUserNameom(String userName) {
		
		List<User> useri = new ArrayList<User>(); 
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			String upit = "from User\r\n" + 
						  "where userName = :userName ";
			Query query = sesija.createQuery(upit);
			query.setParameter("userName", userName);
			useri = query.getResultList();
			if( useri.size() == 0 ) {
				System.out.println("Ne postoji userName");
				sesija.getTransaction().commit();
				return null;
			}else {
				System.out.println("Postoji zadati user!");
				sesija.getTransaction().commit();
				return useri.get(0);
			}
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		}finally {
			sesija.close();
		}	
	}
	
	
	
	
	
	
	
	

}
