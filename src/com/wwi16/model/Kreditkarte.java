package com.wwi16.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "KREDITKARTEN")
public class Kreditkarte {

	@Id
	@GeneratedValue
	private Long id;
	private String kartennummer;
	private String valid;
	private String inhaber;

	@OneToOne
	@JoinColumn(name = "user")
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setInhaber(String inhaber) {
		this.inhaber = inhaber;
	}

	public String getInhaber() {
		return inhaber;
	}

}
