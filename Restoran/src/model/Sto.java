package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStola;
	private int brojStola;
	private boolean daLiJeZauzet;
	
	public int getIdStola() {
		return idStola;
	}
	public void setIdStola(int idStola) {
		this.idStola = idStola;
	}
	public int getBrojStola() {
		return brojStola;
	}
	public void setBrojStola(int brojStola) {
		this.brojStola = brojStola;
	}
	public boolean isDaLiJeZauzet() {
		return daLiJeZauzet;
	}
	public void setDaLiJeZauzet(boolean daLiJeZauzet) {
		this.daLiJeZauzet = daLiJeZauzet;
	}
	
	
}
