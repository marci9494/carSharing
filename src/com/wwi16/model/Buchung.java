package com.wwi16.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BUCHUNG")
public class Buchung {

	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	@JoinColumn(name = "mieter")
	private User mieter;
	@OneToOne
	@JoinColumn(name = "fahrzeug")
	private Fahrzeug fahrzeug;
	
	@Column(name = "START_DATUM")
	private Date startDatum;
	
	@Column(name = "END_DATUM")
	private Date endDatum;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getMieter() {
		return mieter;
	}
	public void setMieter(User mieter) {
		this.mieter = mieter;
	}
	public Fahrzeug getFahrzeug() {
		return fahrzeug;
	}
	public void setFahrzeug(Fahrzeug fahreug) {
		this.fahrzeug = fahreug;
	}
	public Date getStartDatum() {
		return startDatum;
	}
	public void setStartDatum(Date startDatum) {
		this.startDatum = startDatum;
	}
	public Date getEndDatum() {
		return endDatum;
	}
	public void setEndDatum(Date endDatum) {
		this.endDatum = endDatum;
	}
}
