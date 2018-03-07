package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String vorname;
	private String nachname;
	private String strasse;
	private String plz;
	private String ort;
	private String email;
	private String password;
	
	@Lob
    @Column(name="PERSONALAUSWEIS", nullable=false, columnDefinition="mediumblob")
    private byte[] personalausweis;

	public User(Long id, String vorname, String nachname, String strasse, String plz, String ort, String email,
			String password) {
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.email = email;
		this.password = password;

	}

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getPersonalausweis() {
		return personalausweis;
	}

	public void setPersonalausweis(byte[] personalausweis) {
		this.personalausweis = personalausweis;
	}
}
