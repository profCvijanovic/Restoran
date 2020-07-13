package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Artikal;
import model.Racun;
import model.StavkaRacuna;
import model.Transakcije;
import model.User;

public class PlatiRacunDAO {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public boolean snimiRacunUBazu(Racun racun) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			sesija.save(racun);
			System.out.println("Sacuvao sam racun ");
			sesija.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Nisam sacuvao racun...");
			sesija.getTransaction().rollback();
			return false;
		}finally {
			sesija.close();
		}
	}

	public void smanjiBalance(int idUser, double total) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			User user = sesija.get(User.class, idUser);
			user.setBalance(user.getBalance() - total);
			System.out.println("smanjio sam balance ");
			sesija.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Nisam smanjio balance...");
			sesija.getTransaction().rollback();
		}finally {
			sesija.close();
		}
		
	}

	public void regulisiKolicine(List<StavkaRacuna> stavke) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
		
			for(StavkaRacuna sr: stavke) {
				Artikal artikal = sesija.get(Artikal.class, sr.getArtikal().getIdArtikal());
				artikal.setKolicinaNaStanju(artikal.getKolicinaNaStanju() - sr.getKolicina());
			}
			System.out.println("smanjio sam kolicine ");
			sesija.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Nisam smanjio kolicine...");
			sesija.getTransaction().rollback();
		}finally {
			sesija.close();
		}
		
	}

	public void snimiTransakciju(Racun racun) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
		
			Transakcije t = new Transakcije();
			t.setRacun(racun);
			t.setUser(racun.getUser());
			
			sesija.save(t);
			
			System.out.println("Snimio sam transakciju");
			sesija.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Nisam snimio transakciju ...");
			sesija.getTransaction().rollback();
		}finally {
			sesija.close();
		}
	}
	
	
	
	
	
	
	

}
