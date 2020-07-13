package model;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class StavkaRacuna {
	@OneToOne
	private Artikal artikal;
	private int kolicina;
	
	public Artikal getArtikal() {
		return artikal;
	}
	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	
	

}
