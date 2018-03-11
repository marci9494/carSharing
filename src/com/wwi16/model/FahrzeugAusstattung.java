/*
 * 
 */
package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class FahrzeugAusstattung.
 */
@Embeddable
@Table(name = "FAHRZEUG_AUSSTATTUNG")
public class FahrzeugAusstattung implements Serializable{

	/** The fahrzeug. */
	@OneToOne
	@JoinColumn(name = "fahrzeug")
	private Fahrzeug fahrzeug;
	
	/** The ausstattung. */
	@OneToOne
	@JoinColumn(name = "ausstattung")
	private Ausstattung ausstattung;

	/**
	 * Gets the fahrzeug.
	 *
	 * @return the fahrzeug
	 */
	public Fahrzeug getFahrzeug() {
		return fahrzeug;
	}

	/**
	 * Sets the fahrzeug.
	 *
	 * @param fahrzeug the new fahrzeug
	 */
	public void setFahrzeug(Fahrzeug fahrzeug) {
		this.fahrzeug = fahrzeug;
	}

	/**
	 * Gets the ausstattung.
	 *
	 * @return the ausstattung
	 */
	public Ausstattung getAusstattung() {
		return ausstattung;
	}

	/**
	 * Sets the ausstattung.
	 *
	 * @param ausstattung the new ausstattung
	 */
	public void setAusstattung(Ausstattung ausstattung) {
		this.ausstattung = ausstattung;
	}

	
}
