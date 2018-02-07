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
		private int leistung;
		private int sitzplaetze;
		private String modell;
		private int km_stand;
		
		@OneToOne
		private FahrzeugFarbe farbe;
		@OneToOne
		private FahrzeugHersteller hersteller;
		@OneToOne
		private FahrzeugKategorie kategorie;
		
		
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
		public int getKm_stand() {
			return km_stand;
		}
		public void setKm_stand(int km_stand) {
			this.km_stand = km_stand;
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
}
