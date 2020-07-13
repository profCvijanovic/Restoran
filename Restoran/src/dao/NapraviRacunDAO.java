package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Artikal;
import model.Sto;


public class NapraviRacunDAO {
	
	SessionFactory factory = HibernateUtil.createSessionFactory();

	public List<Sto> napraviListuStolova(List<String> listaStolovaId) {
		
		List<Sto> stolovi = new ArrayList<Sto>(); 
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			
			for(String id: listaStolovaId) {
				
			Sto sto = new Sto();
			String upit = "from Sto\r\n" + 
						  "where idStola = :id ";
			Query query = sesija.createQuery(upit);
			query.setParameter("id", Integer.parseInt(id));
			sto = (Sto)query.getSingleResult();
			stolovi.add(sto);

			}
			sesija.getTransaction().commit();
			return stolovi;

		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		}finally {
			sesija.close();
		}	
	}

	public List<Artikal> napraviListuArtikala(List<String> listaArtikalId) {
		
		List<Artikal> artikli = new ArrayList<Artikal>(); 
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			
			for(String id: listaArtikalId) {
				
			Artikal artikal = new Artikal();
			String upit = "from Artikal\r\n" + 
						  "where idArtikal = :id ";
			Query query = sesija.createQuery(upit);
			query.setParameter("id", Integer.parseInt(id));
			artikal = (Artikal)query.getSingleResult();
			artikli.add(artikal);

			}
			sesija.getTransaction().commit();
			return artikli;

		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		}finally {
			sesija.close();
		}	
		
		
		
		
	}
	
	
	

}
