package com.wwi16.model;

import java.util.List;

public class Distance {
	private String plz;
	private double distance;
	private String ort;
	private List<Fahrzeug> fahrzeug;
	
	public Distance(String plz, double distance,String ort){
		this.plz = plz;
		this.distance = distance;
		this.ort = ort;
	}
	
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public List<Fahrzeug> getFahrzeug() {
		return fahrzeug;
	}

	public void setFahrzeug(List<Fahrzeug> fahrzeug) {
		this.fahrzeug = fahrzeug;
	}
	
	
}
