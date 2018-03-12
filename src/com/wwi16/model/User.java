/*
 * 
 */
package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {

	/** The id. */
	@Id
	@GeneratedValue
	private Long id;
	
	/** The vorname. */
	private String anrede;
	
	/** The vorname. */
	private String vorname;
	
	/** The nachname. */
	private String nachname;
	
	/** The strasse. */
	private String strasse;
	
	/** The Hausnummer. */
	private String hausnummer;
	
	/** The plz. */
	private String plz;
	
	/** The ort. */
	private String ort;
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	/** The personalausweis. */
	@Lob
    @Column(name="PERSONALAUSWEIS", nullable=false, columnDefinition="mediumblob")
    private byte[] personalausweis;

	/**
	 * Instantiates a new user.
	 *
	 * @param id the id
	 * @param vorname the vorname
	 * @param nachname the nachname
	 * @param strasse the strasse
	 * @param plz the plz
	 * @param ort the ort
	 * @param email the email
	 * @param password the password
	 */
	public User(Long id, String anrede, String vorname, String nachname, String strasse, String plz, String ort, String email,
			String password) {
		this.id = id;
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
		this.email = email;
		this.password = password;

	}

	/**
	 * Instantiates a new user.
	 */
	public User() {

	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	/**
	 * Gets the vorname.
	 *
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Sets the vorname.
	 *
	 * @param vorname the new vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Gets the nachname.
	 *
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Sets the nachname.
	 *
	 * @param nachname the new nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * Gets the strasse.
	 *
	 * @return the strasse
	 */
	public String getStrasse() {
		return strasse;
	}

	/**
	 * Sets the strasse.
	 *
	 * @param strasse the new strasse
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

		
	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	/**
	 * Gets the plz.
	 *
	 * @return the plz
	 */
	public String getPlz() {
		return plz;
	}

	/**
	 * Sets the plz.
	 *
	 * @param plz the new plz
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}

	/**
	 * Gets the ort.
	 *
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * Sets the ort.
	 *
	 * @param ort the new ort
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the personalausweis.
	 *
	 * @return the personalausweis
	 */
	public byte[] getPersonalausweis() {
		return personalausweis;
	}

	/**
	 * Sets the personalausweis.
	 *
	 * @param personalausweis the new personalausweis
	 */
	public void setPersonalausweis(byte[] personalausweis) {
		this.personalausweis = personalausweis;
	}
}
