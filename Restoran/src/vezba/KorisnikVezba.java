package vezba;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KorisnikVezba {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idKorisnikVezba;
	private String imeKorisnika;
	private String prezimeKorisnika;
	private boolean daLiJePunoletan;
	private String pol;
	
	public int getIdKorisnikVezba() {
		return idKorisnikVezba;
	}
	public void setIdKorisnikVezba(int idKorisnikVezba) {
		this.idKorisnikVezba = idKorisnikVezba;
	}
	public String getImeKorisnika() {
		return imeKorisnika;
	}
	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}
	public String getPrezimeKorisnika() {
		return prezimeKorisnika;
	}
	public void setPrezimeKorisnika(String prezimeKorisnika) {
		this.prezimeKorisnika = prezimeKorisnika;
	}
	public boolean isDaLiJePunoletan() {
		return daLiJePunoletan;
	}
	public void setDaLiJePunoletan(boolean daLiJePunoletan) {
		this.daLiJePunoletan = daLiJePunoletan;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	
	

}
