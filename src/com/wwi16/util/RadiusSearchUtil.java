package com.wwi16.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wwi16.model.Distance;
import com.wwi16.model.LatLong;
import com.wwi16.service.LocationService;

// TODO: Auto-generated Javadoc
/**
 * The Class RadiusSearchUtil.
 */
public class RadiusSearchUtil {

	/**
	 * Radius calculation.
	 *
	 * @param request
	 *            the request
	 * @param plz
	 *            the plz
	 * @param distance
	 *            the distance
	 * @return the list
	 */
	public List<Distance> radiusCalculation(HttpServletRequest request, String plz, double distance) {

		List<Distance> distanceList = new ArrayList<>();
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
					if (!location.getPlz().equals(currentLocation.getPlz())) {
						distanceList.add(new Distance(currentLocation.getPlz(), roundTo2Decimals(distanceOrgDest),
								currentLocation.getOrt()));
					}
				}
			}
		}
		return distanceList;

	}

	/**
	 * Deg 2 rad.
	 *
	 * @param degString
	 *            the deg string
	 * @return the double
	 */
	private static double deg2rad(String degString) {
		double deg = Double.parseDouble(degString);
		return (deg * Math.PI / 180.0);
	}

	/**
	 * Round to 2 decimals.
	 *
	 * @param val
	 *            the val
	 * @return the double
	 */
	double roundTo2Decimals(double val) {
		return Math.round(val * 100.0) / 100.0;
	}

}
