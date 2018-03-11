/*
 * 
 */
package com.wwi16.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

// TODO: Auto-generated Javadoc
/**
 * The Class FahrzeugVermietZeitraum.
 */
@Entity
@Table(name="FAHRZEUG_MIETZEITRAUM")
public class FahrzeugVermietZeitraum {
	
	/** The id. */
	@Id @GeneratedValue
    private Long id;
	
	/** The start date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATUM")
	private Date startDate;
	
	/** The end date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATUM")
	private Date endDate;
	
	/** The fahrzeug. */
	@ManyToOne
	@JoinColumn(name = "fahrzeug")
	@JsonBackReference
	private Fahrzeug fahrzeug;
	
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
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * @param fahrzeug the new fahrzeug
	 */
	public void setFahrzeug(Fahrzeug fahrzeug) {
		this.fahrzeug = fahrzeug;
	}
	
	
}
