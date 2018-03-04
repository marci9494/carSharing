package com.wwi16.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KREDITKARTE")
public class Kreditkarte {

	@Id
	@GeneratedValue
	private Long id;
	private String kartennummer;
	private String valid;
	private String karteninhaber;

	public Kreditkarte(Long id, String kartennummer, String valid, String karteninhaber) {
		this.id = id;
		this.kartennummer = kartennummer;
		this.valid = valid;
		this.karteninhaber = karteninhaber;

	}

	public Kreditkarte() {

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKartennummer() {
		return kartennummer;
	}

	public void setKartennummer(String kartennummer) {
		this.kartennummer = kartennummer;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getKarteninhaber() {
		return karteninhaber;
	}

	public void setKarteninhaber(String karteninhaber) {
		this.karteninhaber = karteninhaber;
	}

}
