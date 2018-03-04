package com.wwi16.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FAHRZEUG_MIETZEITRAUM")
public class FahrzeugVermietZeitraum {
	@Id @GeneratedValue
    private Long id;
	
	@Column(name = "START_DATUM")
	private Date startDate;
	
	@Column(name = "END_DATUM")
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "fahrzeug")
	private Fahrzeug fahrzeug;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Fahrzeug getFahrzeug() {
		return fahrzeug;
	}
	public void setFahrzeug(Fahrzeug fahrzeug) {
		this.fahrzeug = fahrzeug;
	}
	
	
}
