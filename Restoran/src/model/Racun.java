package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Racun {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRacun;
	@OneToOne
	private User user;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Sto> izabraniStolovi = new ArrayList<Sto>();
	@ElementCollection
	private List<StavkaRacuna> stavke = new ArrayList<StavkaRacuna>();
	private double racunZaStavke;
	private double baksis;
	private double total;
	
	public int getIdRacun() {
		return idRacun;
	}
	public void setIdRacun(int idRacun) {
		this.idRacun = idRacun;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<StavkaRacuna> getStavke() {
		return stavke;
	}
	public void setStavke(List<StavkaRacuna> stavke) {
		this.stavke = stavke;
	}
	public double getRacunZaStavke() {
		return racunZaStavke;
	}
	public void setRacunZaStavke(double racunZaStavke) {
		this.racunZaStavke = racunZaStavke;
	}
	public double getBaksis() {
		return baksis;
	}
	public void setBaksis(double baksis) {
		this.baksis = baksis;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<Sto> getIzabraniStolovi() {
		return izabraniStolovi;
	}
	public void setIzabraniStolovi(List<Sto> izabraniStolovi) {
		this.izabraniStolovi = izabraniStolovi;
	}
	
	

}
