
package com.wwi16.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
public class Car implements Serializable {
    
    @Id @GeneratedValue
    private Long id;
    private String model;
    private String marke;


    public Car() {
    }

    
    public Car(String model, String marke) {
        this.model = model;
        this.marke = marke;

    }


    public Long getId() {
        return id;
    }

     public void setId(Long id) {
        this.id = id;
    }


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getMarke() {
		return marke;
	}


	public void setMarke(String marke) {
		this.marke = marke;
	}

       
}
