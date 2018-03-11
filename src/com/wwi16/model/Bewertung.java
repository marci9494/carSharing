/*
 * 
 */
package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	/** The nutzer. */
	private User nutzer;
	//TODO BUCHUNG Verknüpfen
	
    /**
	 * Instantiates a new bewertung.
	 *
	 * @param id the id
	 * @param kommentar the kommentar
	 * @param nutzer the nutzer
	 */
	public Bewertung(Long id, String kommentar,User nutzer) {
        this.id = id;
        this.kommentar = kommentar;
        this.nutzer = nutzer;

    }
    
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

	/**
	 * Gets the nutzer.
	 *
	 * @return the nutzer
	 */
	public User getNutzer() {
		return nutzer;
	}

	/**
	 * Sets the nutzer.
	 *
	 * @param nutzer the new nutzer
	 */
	public void setNutzer(User nutzer) {
		this.nutzer = nutzer;
	}
}
