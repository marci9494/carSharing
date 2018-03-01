package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FAHRZEUG")
public class Fahrzeug implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 7517669414971165900L;

	@Id
	@GeneratedValue
	private Long id;
	private String kennzeichen;
	private String modell;
	private String baujahr;
	private String laufleistung;

	private String kraftstoff;

	private String sitzplaetze;
	private String basispreis;
	private String kilometerpreis;

	private String leistung;

	@OneToOne
	private FahrzeugFarbe farbe;
	@OneToOne
	private FahrzeugHersteller hersteller;
	@OneToOne
	private FahrzeugKategorie kategorie;

	private String plz;

	private User eigentuemer;

	public String getKennzeichen() {
		return kennzeichen;
	}

	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public String getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(String baujahr) {
		this.baujahr = baujahr;
	}

	public String getLaufleistung() {
		return laufleistung;
	}

	public void setLaufleistung(String laufleistung) {
		this.laufleistung = laufleistung;
	}

	public String getKraftstoff() {
		return kraftstoff;
	}

	public void setKraftstoff(String kraftstoff) {
		this.kraftstoff = kraftstoff;
	}

	public String getBasispreis() {
		return basispreis;
	}

	public void setBasispreis(String basispreis) {
		this.basispreis = basispreis;
	}

	public String getKilometerpreis() {
		return kilometerpreis;
	}

	public void setKilometerpreis(String kilometerpreis) {
		this.kilometerpreis = kilometerpreis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLeistung() {
		return leistung;
	}

	public void setLeistung(String leistung) {
		this.leistung = leistung;
	}

	public String getSitzplaetze() {
		return sitzplaetze;
	}

	public void setSitzplaetze(String sitzplaetze) {
		this.sitzplaetze = sitzplaetze;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public FahrzeugFarbe getFarbe() {
		return farbe;
	}

	public void setFarbe(FahrzeugFarbe farbe) {
		this.farbe = farbe;
	}

	public FahrzeugHersteller getHersteller() {
		return hersteller;
	}

	public void setHersteller(FahrzeugHersteller hersteller) {
		this.hersteller = hersteller;
	}

	public FahrzeugKategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(FahrzeugKategorie kategorie) {
		this.kategorie = kategorie;
	}

	public String getPlz() {
		return plz;
	}

	public void setLatitude(String plz) {
		this.plz = plz;
	}

}
