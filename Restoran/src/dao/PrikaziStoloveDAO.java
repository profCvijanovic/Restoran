package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Sto;

public class PrikaziStoloveDAO {
	
	SessionFactory factory = new HibernateUtil().getSessionFactory();

	public List<Sto> vratiSveSlobodneStolove() {
		
		List<Sto> listaStolova = new ArrayList<Sto>();
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			String pismo = "from Sto where daLiJeZauzet = false";
			Query query = sesija.createQuery(pismo);
			
			listaStolova = query.getResultList();
			
			System.out.println("Stize lista stolova...");
			sesija.getTransaction().commit();
			return listaStolova;
		} catch (Exception e) {
			System.out.println("Nisam nasao listu stolova...");
			sesija.getTransaction().rollback();
			return null;
		}finally {
			sesija.close();
		}
	}
	
	
}
