/*
 * 
 */
package com.wwi16.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// TODO: Auto-generated Javadoc
/**
 * The Class Fahrzeug.
 */
@Entity
@Table(name = "FAHRZEUG")
public class Fahrzeug implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7517669414971165900L;

	/** The id. */
	@Id
	@GeneratedValue
	private Long id;
	
	/** The kennzeichen. */
	private String kennzeichen;
	
	/** The modell. */
	private String modell;
	
	/** The baujahr. */
	private String baujahr;
	
	/** The km stand. */
	private String km_stand;

	/** The sitzplaetze. */
	private String sitzplaetze;
	
	/** The tagespreis. */
	private String tagespreis;
	
	/** The leistung. */
	private String leistung;
	
	/** The farbe. */
	@OneToOne
	@JoinColumn(name = "farbe")
	private FahrzeugFarbe farbe;

	/** The hersteller. */
	@OneToOne
	@JoinColumn(name = "hersteller")
	private FahrzeugHersteller hersteller;

	/** The kategorie. */
	@OneToOne
	@JoinColumn(name = "kategorie")
	private FahrzeugKategorie kategorie;
	
	/** The kraftstoff. */
	@OneToOne
	@JoinColumn(name = "kraftstoff")
	private Kraftstoff kraftstoff;

	/** The plz. */
	private String plz;

	/** The eigentuemer. */
	@OneToOne
	@JoinColumn(name = "eigentuemer")
	private User eigentuemer;

	/** The ausstattung. */
	@Fetch(FetchMode.SELECT)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "FAHRZEUG_AUSSTATTUNG", joinColumns = { @JoinColumn(name = "fahrzeug") }, inverseJoinColumns = {
			@JoinColumn(name = "ausstattung") })
	private List<Ausstattung> ausstattung;

	/** The fahrzeugbild. */
	@Lob
	@Column(name = "fahrzeugbild", columnDefinition = "mediumblob")
	private byte[] fahrzeugbild;

	/** The vermiet zeitraeume. */
	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name = "FAHRZEUG_MIETZEITRAUM", joinColumns = @JoinColumn(name = "fahrzeug"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<FahrzeugVermietZeitraum> vermietZeitraeume;

	/** The fahrzeug bild string. */
	@Transient
	private String fahrzeugBildString;

	/**
	 * Gets the kennzeichen.
	 *
	 * @return the kennzeichen
	 */
	public String getKennzeichen() {
		return kennzeichen;
	}

	/**
	 * Sets the kennzeichen.
	 *
	 * @param kennzeichen the new kennzeichen
	 */
	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	/**
	 * Gets the baujahr.
	 *
	 * @return the baujahr
	 */
	public String getBaujahr() {
		return baujahr;
	}

	/**
	 * Sets the baujahr.
	 *
	 * @param baujahr the new baujahr
	 */
	public void setBaujahr(String baujahr) {
		this.baujahr = baujahr;
	}

	/**
	 * Gets the kraftstoff.
	 *
	 * @return the kraftstoff
	 */
	public Kraftstoff getKraftstoff() {
		return kraftstoff;
	}

	/**
	 * Sets the kraftstoff.
	 *
	 * @param kraftstoff the new kraftstoff
	 */
	public void setKraftstoff(Kraftstoff kraftstoff) {
		this.kraftstoff = kraftstoff;
	}

	/**
	 * Gets the tagespreis.
	 *
	 * @return the tagespreis
	 */
	public String getTagespreis() {
		return tagespreis;
	}

	/**
	 * Sets the tagespreis.
	 *
	 * @param tagespreis the new tagespreis
	 */
	public void setTagespreis(String tagespreis) {
		this.tagespreis = tagespreis;
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
	 * Gets the leistung.
	 *
	 * @return the leistung
	 */
	public String getLeistung() {
		return leistung;
	}

	/**
	 * Sets the leistung.
	 *
	 * @param leistung the new leistung
	 */
	public void setLeistung(String leistung) {
		this.leistung = leistung;
	}

	/**
	 * Gets the sitzplaetze.
	 *
	 * @return the sitzplaetze
	 */
	public String getSitzplaetze() {
		return sitzplaetze;
	}

	/**
	 * Sets the sitzplaetze.
	 *
	 * @param sitzplaetze the new sitzplaetze
	 */
	public void setSitzplaetze(String sitzplaetze) {
		this.sitzplaetze = sitzplaetze;
	}

	/**
	 * Gets the modell.
	 *
	 * @return the modell
	 */
	public String getModell() {
		return modell;
	}

	/**
	 * Sets the modell.
	 *
	 * @param modell the new modell
	 */
	public void setModell(String modell) {
		this.modell = modell;
	}

	/**
	 * Gets the farbe.
	 *
	 * @return the farbe
	 */
	public FahrzeugFarbe getFarbe() {
		return farbe;
	}

	/**
	 * Sets the farbe.
	 *
	 * @param farbe the new farbe
	 */
	public void setFarbe(FahrzeugFarbe farbe) {
		this.farbe = farbe;
	}

	/**
	 * Gets the hersteller.
	 *
	 * @return the hersteller
	 */
	public FahrzeugHersteller getHersteller() {
		return hersteller;
	}

	/**
	 * Sets the hersteller.
	 *
	 * @param hersteller the new hersteller
	 */
	public void setHersteller(FahrzeugHersteller hersteller) {
		this.hersteller = hersteller;
	}

	/**
	 * Gets the kategorie.
	 *
	 * @return the kategorie
	 */
	public FahrzeugKategorie getKategorie() {
		return kategorie;
	}

	/**
	 * Sets the kategorie.
	 *
	 * @param kategorie the new kategorie
	 */
	public void setKategorie(FahrzeugKategorie kategorie) {
		this.kategorie = kategorie;
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
	 * Sets the latitude.
	 *
	 * @param plz the new latitude
	 */
	public void setLatitude(String plz) {
		this.plz = plz;
	}

	/**
	 * Gets the km stand.
	 *
	 * @return the km stand
	 */
	public String getKm_stand() {
		return km_stand;
	}

	/**
	 * Sets the km stand.
	 *
	 * @param km_stand the new km stand
	 */
	public void setKm_stand(String km_stand) {
		this.km_stand = km_stand;
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
	 * Gets the eigentuemer.
	 *
	 * @return the eigentuemer
	 */
	public User getEigentuemer() {
		return eigentuemer;
	}

	/**
	 * Sets the eigentuemer.
	 *
	 * @param eigentuemer the new eigentuemer
	 */
	public void setEigentuemer(User eigentuemer) {
		this.eigentuemer = eigentuemer;
	}

	/**
	 * Gets the ausstattung.
	 *
	 * @return the ausstattung
	 */
	public List<Ausstattung> getAusstattung() {
		return ausstattung;
	}

	/**
	 * Sets the ausstattung.
	 *
	 * @param ausstattung the new ausstattung
	 */
	public void setAusstattung(List<Ausstattung> ausstattung) {
		this.ausstattung = ausstattung;
	}

	/**
	 * Gets the fahrzeugbild.
	 *
	 * @return the fahrzeugbild
	 */
	public byte[] getFahrzeugbild() {
		return fahrzeugbild;
	}

	/**
	 * Sets the fahrzeugbild.
	 *
	 * @param fahrzeugbild the new fahrzeugbild
	 */
	public void setFahrzeugbild(byte[] fahrzeugbild) {
		this.fahrzeugbild = fahrzeugbild;
	}

	/**
	 * Gets the fahrzeug bild string.
	 *
	 * @return the fahrzeug bild string
	 */
	public String getFahrzeugBildString() {
		return fahrzeugBildString;
	}

	/**
	 * Sets the fahrzeug bild string.
	 *
	 * @param fahrzeugBildString the new fahrzeug bild string
	 */
	public void setFahrzeugBildString(String fahrzeugBildString) {
		this.fahrzeugBildString = fahrzeugBildString;
	}

	/**
	 * Gets the vermiet zeitraeume.
	 *
	 * @return the vermiet zeitraeume
	 */
	public List<FahrzeugVermietZeitraum> getVermietZeitraeume() {
		return vermietZeitraeume;
	}

	/**
	 * Sets the vermiet zeitraeume.
	 *
	 * @param vermietZeitraeume the new vermiet zeitraeume
	 */
	public void setVermietZeitraeume(List<FahrzeugVermietZeitraum> vermietZeitraeume) {
		this.vermietZeitraeume = vermietZeitraeume;
	}

}
