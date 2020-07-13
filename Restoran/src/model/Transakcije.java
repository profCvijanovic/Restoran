package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transakcije {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransakcije;
	@OneToOne
	private User user;
	@OneToOne
	private Racun racun;
	
	public int getIdTransakcije() {
		return idTransakcije;
	}
	public void setIdTransakcije(int idTransakcije) {
		this.idTransakcije = idTransakcije;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Racun getRacun() {
		return racun;
	}
	public void setRacun(Racun racun) {
		this.racun = racun;
	}
	
}
