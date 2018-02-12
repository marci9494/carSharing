package com.wwi16.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class RadiusSearchUtil {
	public List<String> radiusCalculation(HttpServletRequest request,String plz,double distance) {
		
		//TODO Improvements: File nicht 2 mal auslesen und nicht aus file sondern aus db auslesen
		List<String> orte = new ArrayList<>();


		double origin_lon = 0.0;
		double origin_lat = 0.0;
		try {
			ServletContext context = request.getServletContext();
			String fullPath = context.getRealPath("/WEB-INF/PLZ.txt");
			Scanner sc2 = new Scanner(new File(fullPath));
			while (sc2.hasNextLine()) {
				String[] fileRow = sc2.nextLine().split("\t");
				if (fileRow[1].equals(plz)) {
					origin_lon = deg2rad(fileRow[2]);
					origin_lat = deg2rad(fileRow[3]);

				
				}
			}


			Scanner sc = new Scanner(new File(fullPath));
			while (sc.hasNextLine()) {
				String[] fileRow2 = sc.nextLine().split("\t");
				double destination_lon = deg2rad(fileRow2[2]);
				double destination_lat = deg2rad(fileRow2[3]);
				double distanceOrgDest =  Math.acos(Math.sin(destination_lat)*Math.sin(origin_lat)+Math.cos(destination_lat)*Math.cos(origin_lat)*Math.cos(destination_lon - origin_lon))*6375;
				if(distanceOrgDest <= distance){
					System.out.println(fileRow2[4] + " - " + distanceOrgDest);
				}
			
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orte;

	}

	private static double deg2rad(String degString) {
		double deg = Double.parseDouble(degString);
		return (deg * Math.PI / 180.0);
	}
//	public List<String> radiusCalculation(HttpServletRequest request,String plz) {
//	List<String> orte = new ArrayList<>();
//	double distance = 10;
//	// Erdradius
//	distance = distance / 6378;
//	double maxCoord_lon = 0.0;
//	double maxCoord_lat = 0.0;
//	double minCoord_lon = 0.0;
//	double minCoord_lat = 0.0;
//
//	double origin_lon = 0.0;
//	double origin_lat = 0.0;
//	try {
//		ServletContext context = request.getServletContext();
//		String fullPath = context.getRealPath("/WEB-INF/PLZ.txt");
//		Scanner sc2 = new Scanner(new File(fullPath));
//		while (sc2.hasNextLine()) {
//			String[] fileRow = sc2.nextLine().split("\t");
//			if (fileRow[1].equals(plz)) {
//				origin_lon = deg2rad(fileRow[2]);
//				origin_lat = deg2rad(fileRow[3]);
//
//				maxCoord_lon = origin_lon + distance;
//				maxCoord_lat = origin_lat + distance;
//				minCoord_lon = origin_lon - distance;
//				minCoord_lat = origin_lat - distance;
//			}
//		}
//
//
//		Scanner sc = new Scanner(new File(fullPath));
//		while (sc.hasNextLine()) {
//			String[] fileRow2 = sc.nextLine().split("\t");
//			if (maxCoord_lon >= deg2rad(fileRow2[2]) && minCoord_lon <= deg2rad(fileRow2[2])
//					&& maxCoord_lat >= deg2rad(fileRow2[3]) && minCoord_lat <= deg2rad(fileRow2[3])) {
//				orte.add(fileRow2[4]);
//			}
//		}
//
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	return orte;
//
//}

}
