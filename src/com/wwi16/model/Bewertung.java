package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BEWERTUNG")
public class Bewertung implements Serializable {
	
    @Id @GeneratedValue
    private Long id;
	private String kommentar;
	private User nutzer;
	//TODO BUCHUNG Verknüpfen
	
    public Bewertung(Long id, String kommentar,User nutzer) {
        this.id = id;
        this.kommentar = kommentar;
        this.nutzer = nutzer;

    }
    
    public Bewertung(){
    	
    }

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public User getNutzer() {
		return nutzer;
	}

	public void setNutzer(User nutzer) {
		this.nutzer = nutzer;
	}
}
