/*
 * 
 */
package com.wwi16.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class LatLong.
 */
@Entity
@Table(name = "PLZ_LANG_LONG")
public class LatLong implements Serializable {
	
	/** The id. */
	@Id
	private int id;
	
	/** The plz. */
	private String plz;
	
	/** The lon. */
	private String lon;
	
	/** The lat. */
	private String lat;
	
	/** The ort. */
	private String ort;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the plz.
	 *
	 * @return the plz
	 */
	public String getPlz() {
		return plz;
	}
	
	/**
	 * Sets the plz.
	 *
	 * @param plz the new plz
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}
	
	/**
	 * Gets the lon.
	 *
	 * @return the lon
	 */
	public String getLon() {
		return lon;
	}
	
	/**
	 * Sets the lon.
	 *
	 * @param lon the new lon
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}
	
	/**
	 * Gets the lat.
	 *
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}
	
	/**
	 * Sets the lat.
	 *
	 * @param lat the new lat
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	/**
	 * Gets the ort.
	 *
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}
	
	/**
	 * Sets the ort.
	 *
	 * @param ort the new ort
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	
	

}
