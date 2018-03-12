/*
 * 
 */
package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Bewertung.
 */
@Entity
@Table(name="BEWERTUNG")
public class Bewertung implements Serializable {
	
    /** The id. */
    @Id @GeneratedValue
    private Long id;
	
	/** The kommentar. */
	private String kommentar;
	
	@OneToOne
	@JoinColumn(name = "buchung")
	private Buchung buchung;
	
	private String freundlichkeit;
	private String zahlen;
	private String zustand;
	

    
    /**
     * Instantiates a new bewertung.
     */
    public Bewertung(){
    	
    }

	/**
	 * Gets the kommentar.
	 *
	 * @return the kommentar
	 */
	public String getKommentar() {
		return kommentar;
	}

	/**
	 * Sets the kommentar.
	 *
	 * @param kommentar the new kommentar
	 */
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Buchung getBuchung() {
		return buchung;
	}

	public void setBuchung(Buchung buchung) {
		this.buchung = buchung;
	}

	public String getFreundlichkeit() {
		return freundlichkeit;
	}

	public void setFreundlichkeit(String freundlichkeit) {
		this.freundlichkeit = freundlichkeit;
	}

	public String getZahlen() {
		return zahlen;
	}

	public void setZahlen(String zahlen) {
		this.zahlen = zahlen;
	}

	public String getZustand() {
		return zustand;
	}

	public void setZustand(String zustand) {
		this.zustand = zustand;
	}


}
