/*
 * 
 */
package com.wwi16.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Kreditkarte.
 */
@Entity
@Table(name = "KREDITKARTEN")
public class Kreditkarte {

	/** The id. */
	@Id
	@GeneratedValue
	private Long id;
	
	/** The kartennummer. */
	private String kartennummer;
	
	/** The valid. */
	private String valid;
	
	/** The inhaber. */
	private String inhaber;

	/** The user. */
	@OneToOne
	@JoinColumn(name = "user")
	private User user;

	/**
	 * Instantiates a new kreditkarte.
	 */
	public Kreditkarte() {

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

	/**
	 * Gets the kartennummer.
	 *
	 * @return the kartennummer
	 */
	public String getKartennummer() {
		return kartennummer;
	}

	/**
	 * Sets the kartennummer.
	 *
	 * @param kartennummer the new kartennummer
	 */
	public void setKartennummer(String kartennummer) {
		this.kartennummer = kartennummer;
	}

	/**
	 * Gets the valid.
	 *
	 * @return the valid
	 */
	public String getValid() {
		return valid;
	}

	/**
	 * Sets the valid.
	 *
	 * @param valid the new valid
	 */
	public void setValid(String valid) {
		this.valid = valid;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Sets the inhaber.
	 *
	 * @param inhaber the new inhaber
	 */
	public void setInhaber(String inhaber) {
		this.inhaber = inhaber;
	}

	/**
	 * Gets the inhaber.
	 *
	 * @return the inhaber
	 */
	public String getInhaber() {
		return inhaber;
	}

}
