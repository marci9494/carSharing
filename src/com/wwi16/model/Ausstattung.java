package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUSSTATTUNG")
public class Ausstattung implements Serializable {
	
    @Id @GeneratedValue
    private Long id;
	private String name;
	
    public Ausstattung(Long id, String name) {
        this.id = id;
        this.name = name;

    }
    
    public Ausstattung(){
    	
    }
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    

}
