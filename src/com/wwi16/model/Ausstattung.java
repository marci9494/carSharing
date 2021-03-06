package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Ausstattung.
 */
@Entity
@Table(name="AUSSTATTUNG")
public class Ausstattung implements Serializable {
	
    /** The id. */
    @Id @GeneratedValue
    private Long id;
	
	/** The name. */
	private String name;
	
	
    /**
     * Instantiates a new ausstattung.
     *
     * @param id the id
     * @param name the name
     */
    public Ausstattung(Long id, String name) {
        this.id = id;
        this.name = name;

    }
    
    /**
     * Instantiates a new ausstattung.
     */
    public Ausstattung(){
    	
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

    

}
