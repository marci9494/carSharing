package com.wwi16.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private String km_stand;

	private String kraftstoff;

	private String sitzplaetze;
	private String basispreis;
	private String kilometerpreis;

	private String leistung;
	@OneToOne
	@JoinColumn(name = "farbe")
	private FahrzeugFarbe farbe;
	
	@OneToOne
	@JoinColumn(name = "hersteller")
	private FahrzeugHersteller hersteller;
	
	@OneToOne
	@JoinColumn(name = "kategorie")
	private FahrzeugKategorie kategorie;

	private String plz;

	@OneToOne
	@JoinColumn(name = "eigentuemer")
	private User eigentuemer;
	
	//TODO WORK
	private List<Ausstattung> ausstattung;

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

	public String getKm_stand() {
		return km_stand;
	}

	public void setKm_stand(String km_stand) {
		this.km_stand = km_stand;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public User getEigentuemer() {
		return eigentuemer;
	}

	public void setEigentuemer(User eigentuemer) {
		this.eigentuemer = eigentuemer;
	}

	public List<Ausstattung> getAusstattung() {
		return ausstattung;
	}

	public void setAusstattung(List<Ausstattung> ausstattung) {
		this.ausstattung = ausstattung;
	}

}
