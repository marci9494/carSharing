/*
 * 
 */
package com.wwi16.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Buchung.
 */
@Entity
@Table(name = "BUCHUNG")
public class Buchung {

	/** The id. */
	@Id
	@GeneratedValue
	private Long id;
	
	/** The mieter. */
	@OneToOne
	@JoinColumn(name = "mieter")
	private User mieter;
	
	/** The fahrzeug. */
	@OneToOne
	@JoinColumn(name = "fahrzeug")
	private Fahrzeug fahrzeug;
	
	/** The start datum. */
	@Column(name = "START_DATUM")
	private Date startDatum;
	
	/** The end datum. */
	@Column(name = "END_DATUM")
	private Date endDatum;
	
	/** The maengel. */
	private String maengel;
	
	/** The status. */
	@Enumerated(EnumType.ORDINAL)
	private BuchungStatus status;
	
	/** The tatsaechliche rueckgabe datum. */
	@Column(name = "TATSAECHLICHES_RUECKGABEDATUM")
	private Date tatsaechlicheRueckgabeDatum;
	
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
	 * Gets the mieter.
	 *
	 * @return the mieter
	 */
	public User getMieter() {
		return mieter;
	}
	
	/**
	 * Sets the mieter.
	 *
	 * @param mieter the new mieter
	 */
	public void setMieter(User mieter) {
		this.mieter = mieter;
	}
	
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
	 * @param fahreug the new fahrzeug
	 */
	public void setFahrzeug(Fahrzeug fahreug) {
		this.fahrzeug = fahreug;
	}
	
	/**
	 * Gets the start datum.
	 *
	 * @return the start datum
	 */
	public Date getStartDatum() {
		return startDatum;
	}
	
	/**
	 * Sets the start datum.
	 *
	 * @param startDatum the new start datum
	 */
	public void setStartDatum(Date startDatum) {
		this.startDatum = startDatum;
	}
	
	/**
	 * Gets the end datum.
	 *
	 * @return the end datum
	 */
	public Date getEndDatum() {
		return endDatum;
	}
	
	/**
	 * Sets the end datum.
	 *
	 * @param endDatum the new end datum
	 */
	public void setEndDatum(Date endDatum) {
		this.endDatum = endDatum;
	}
	
	/**
	 * Gets the maengel.
	 *
	 * @return the maengel
	 */
	public String getMaengel() {
		return maengel;
	}
	
	/**
	 * Sets the maengel.
	 *
	 * @param maengel the new maengel
	 */
	public void setMaengel(String maengel) {
		this.maengel = maengel;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public BuchungStatus getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(BuchungStatus status) {
		this.status = status;
	}
	
	/**
	 * Gets the tatsaechliche rueckgabe datum.
	 *
	 * @return the tatsaechliche rueckgabe datum
	 */
	public Date getTatsaechlicheRueckgabeDatum() {
		return tatsaechlicheRueckgabeDatum;
	}
	
	/**
	 * Sets the tatsaechliche rueckgabe datum.
	 *
	 * @param tatsaechlicheRueckgabeDatum the new tatsaechliche rueckgabe datum
	 */
	public void setTatsaechlicheRueckgabeDatum(Date tatsaechlicheRueckgabeDatum) {
		this.tatsaechlicheRueckgabeDatum = tatsaechlicheRueckgabeDatum;
	}
}
