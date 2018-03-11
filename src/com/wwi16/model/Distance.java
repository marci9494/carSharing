/*
 * 
 */
package com.wwi16.model;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Distance.
 */
public class Distance {
	
	/** The plz. */
	private String plz;
	
	/** The distance. */
	private double distance;
	
	/** The ort. */
	private String ort;
	
	/** The fahrzeug. */
	private List<Fahrzeug> fahrzeug;
	
	/**
	 * Instantiates a new distance.
	 *
	 * @param plz the plz
	 * @param distance the distance
	 * @param ort the ort
	 */
	public Distance(String plz, double distance,String ort){
		this.plz = plz;
		this.distance = distance;
		this.ort = ort;
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
	 * Gets the distance.
	 *
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	
	/**
	 * Sets the distance.
	 *
	 * @param distance the new distance
	 */
	public void setDistance(double distance) {
		this.distance = distance;
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

	/**
	 * Gets the fahrzeug.
	 *
	 * @return the fahrzeug
	 */
	public List<Fahrzeug> getFahrzeug() {
		return fahrzeug;
	}

	/**
	 * Sets the fahrzeug.
	 *
	 * @param fahrzeug the new fahrzeug
	 */
	public void setFahrzeug(List<Fahrzeug> fahrzeug) {
		this.fahrzeug = fahrzeug;
	}
	
	
}
