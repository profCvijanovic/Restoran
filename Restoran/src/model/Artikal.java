package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artikal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idArtikal;
	private String ime;
	private double cena;
	private double popust;
	private int kolicinaNaStanju;
	
	public int getIdArtikal() {
		return idArtikal;
	}
	public void setIdArtikal(int idArtikal) {
		this.idArtikal = idArtikal;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public double getPopust() {
		return popust;
	}
	public void setPopust(double popust) {
		this.popust = popust;
	}
	public int getKolicinaNaStanju() {
		return kolicinaNaStanju;
	}
	public void setKolicinaNaStanju(int kolicinaNaStanju) {
		this.kolicinaNaStanju = kolicinaNaStanju;
	}
	
	

}
