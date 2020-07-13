package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Artikal;
import model.User;

public class DodajBalanceDAO {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public boolean dodajBalance(String idUser, String balance) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			User user = sesija.get(User.class, Integer.parseInt(idUser));
			user.setBalance(user.getBalance() + Double.parseDouble(balance));
			sesija.update(user);
			
			System.out.println("Dodao sam " + balance + " dinara Useru " + idUser);
			sesija.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Nisam dodao nista...");
			sesija.getTransaction().rollback();
			return false;
		}finally {
			sesija.close();
		}
	}
}
