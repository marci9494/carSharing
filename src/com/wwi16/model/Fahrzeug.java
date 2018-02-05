package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FAHRZEUG")
public class Fahrzeug implements Serializable{
	 @Id @GeneratedValue
	    private Long id;
		private String leistung;
		private String sitzplaetze;
		private String modell;
		private String km_stand;
		private String farbe;
		private String hersteller;
		private String kategorie;
}
