package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FAHRZEUG")
public class Fahrzeug implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 7517669414971165900L;
	
	@Id @GeneratedValue
	    private Long id;
		private String kennzeichen;
		private String modell;
		private int baujahr;
		private int laufleistung;

		private String kraftstoff;
		
		private int sitzplaetze;
		private int basispreis;
		private int kilometerpreis;
		
		private int leistung;
		
		@OneToOne
		private FahrzeugFarbe farbe;
		@OneToOne
		private FahrzeugHersteller hersteller;
		@OneToOne
		private FahrzeugKategorie kategorie;
		
		private String plz;
		
		
		public String getKennzeichen() {
			return kennzeichen;
		}
		public void setKennzeichen(String kennzeichen) {
			this.kennzeichen = kennzeichen;
		}
		public int getBaujahr() {
			return baujahr;
		}
		public void setBaujahr(int baujahr) {
			this.baujahr = baujahr;
		}
		public int getLaufleistung() {
			return laufleistung;
		}
		public void setLaufleistung(int laufleistung) {
			this.laufleistung = laufleistung;
		}
		public String getKraftstoff() {
			return kraftstoff;
		}
		public void setKraftstoff(String kraftstoff) {
			this.kraftstoff = kraftstoff;
		}
		public int getBasispreis() {
			return basispreis;
		}
		public void setBasispreis(int basispreis) {
			this.basispreis = basispreis;
		}
		public int getKilometerpreis() {
			return kilometerpreis;
		}
		public void setKilometerpreis(int kilometerpreis) {
			this.kilometerpreis = kilometerpreis;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getLeistung() {
			return leistung;
		}
		public void setLeistung(int leistung) {
			this.leistung = leistung;
		}
		public int getSitzplaetze() {
			return sitzplaetze;
		}
		public void setSitzplaetze(int sitzplaetze) {
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
