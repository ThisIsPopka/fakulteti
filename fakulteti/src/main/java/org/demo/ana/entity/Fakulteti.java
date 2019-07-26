package org.demo.ana.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Student")
public class Fakulteti {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="naziv")
	private String naziv;
	
	@Column(name="adresa")
	private String adresa;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefon")
	private String telefon;
	
	public Fakulteti() {
		
	}

	public Fakulteti(String naziv, String adresa, String email, String telefon) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.email = email;
		this.telefon = telefon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "Fakulteti [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", email=" + email + ", telefon="
				+ telefon + "]";
	}

	

}
