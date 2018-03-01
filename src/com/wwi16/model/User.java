package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private boolean vermieter;
	private String password;

	public User(Long id, String vorname, String nachname, String strasse, String plz, String ort, String email,
			boolean vermieter,String password) {
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.email = email;
		this.vermieter = vermieter;
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

	public boolean isVermieter() {
		return vermieter;
	}

	public void setVermieter(boolean vermieter) {
		this.vermieter = vermieter;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
