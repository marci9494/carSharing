package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
@Table(name = "FAHRZEUG_AUSSTATTUNG")
public class FahrzeugAusstattung implements Serializable{

	@OneToOne
	@JoinColumn(name = "fahrzeug")
	private Fahrzeug fahrzeug;
	
	@OneToOne
	@JoinColumn(name = "ausstattung")
	private Ausstattung ausstattung;

	public Fahrzeug getFahrzeug() {
		return fahrzeug;
	}

	public void setFahrzeug(Fahrzeug fahrzeug) {
		this.fahrzeug = fahrzeug;
	}

	public Ausstattung getAusstattung() {
		return ausstattung;
	}

	public void setAusstattung(Ausstattung ausstattung) {
		this.ausstattung = ausstattung;
	}

	
}
