package com.wwi16.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.wwi16.model.Distance;
import com.wwi16.model.LatLong;
import com.wwi16.service.LocationService;

public class RadiusSearchUtil {
	public List<Distance> radiusCalculation(HttpServletRequest request, String plz, double distance) {

		// TODO Improvements: File nicht 2 mal auslesen und nicht aus file
		// sondern aus db auslesen
		List<Distance> distanceList = new ArrayList<>();
//		double origin_lon = 0.0;
//		double origin_lat = 0.0;
//		try {
//			ServletContext context = request.getServletContext();
//			String fullPath = context.getRealPath("/WEB-INF/PLZ.txt");
//			Scanner sc2 = new Scanner(new File(fullPath));
//			while (sc2.hasNextLine()) {
//				String[] fileRow = sc2.nextLine().split("\t");
//				if (fileRow[1].equals(plz)) {
//					origin_lon = deg2rad(fileRow[2]);
//					origin_lat = deg2rad(fileRow[3]);
//					distanceList.add(new Distance(plz, 0.0, fileRow[4]));
//					//
//				}
//			}
//
//			Scanner sc = new Scanner(new File(fullPath));
//			while (sc.hasNextLine()) {
//				String[] fileRow2 = sc.nextLine().split("\t");
//				double destination_lon = deg2rad(fileRow2[2]);
//				double destination_lat = deg2rad(fileRow2[3]);
//				double distanceOrgDest = Math.acos(Math.sin(destination_lat) * Math.sin(origin_lat)
//						+ Math.cos(destination_lat) * Math.cos(origin_lat) * Math.cos(destination_lon - origin_lon))
//						* 6375;
//				if (distanceOrgDest <= distance) {
//					distanceList.add(new Distance(fileRow2[1], roundTo2Decimals(distanceOrgDest), fileRow2[4]));
//				}
//
//			}
//
//		} catch (FileNotFoundException e) {
//			// // TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		LocationService locationService = new LocationService();
		LatLong location = locationService.getLocationByPlz(plz);

		if (location != null) {
			double origin_lon = deg2rad(location.getLon());
			double origin_lat = deg2rad(location.getLat());
			distanceList.add(new Distance(plz, 0.0, location.getOrt()));
			List<LatLong> allLocations = locationService.getAllLocations();
			for (LatLong currentLocation : allLocations) {
				double destination_lon = deg2rad(currentLocation.getLon());
				double destination_lat = deg2rad(currentLocation.getLat());
				double distanceOrgDest = Math.acos(Math.sin(destination_lat) * Math.sin(origin_lat)
						+ Math.cos(destination_lat) * Math.cos(origin_lat) * Math.cos(destination_lon - origin_lon))
						* 6375;
				if (distanceOrgDest <= distance) {
					distanceList.add(new Distance(currentLocation.getPlz(), roundTo2Decimals(distanceOrgDest),
							currentLocation.getOrt()));
				}
			}
		}
		return distanceList;

	}

	private static double deg2rad(String degString) {
		double deg = Double.parseDouble(degString);
		return (deg * Math.PI / 180.0);
	}

	double roundTo2Decimals(double val) {
		return Math.round(val * 100.0) / 100.0;
	}

}
