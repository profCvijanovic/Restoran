package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Artikal;
import model.User;

public class OdaberiArtikalDAO {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public List<Artikal> vratiSveArtikleIzBaze() {
		
		List<Artikal> artikli = new ArrayList<Artikal>(); 
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			String upit = "from Artikal";
			
			Query query = sesija.createQuery(upit);
			artikli = query.getResultList();
		
			System.out.println("Stizu artikli!!!");
			sesija.getTransaction().commit();
			return artikli;
		
		} catch (Exception e) {
			System.out.println("Nisam uspeo da vratim artikle...");
			sesija.getTransaction().rollback();
			return null;
		}finally {
			sesija.close();
		}	
	}

}
