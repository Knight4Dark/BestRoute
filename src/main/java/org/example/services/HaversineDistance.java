package org.example.services;


import org.example.models.GeoPoint;

public class HaversineDistance {
    public static final double RADIUS_OF_EARTH = 6371; // Earth's radius in kilometers

    public static double calculateDistance(GeoPoint point1, GeoPoint point2) {
        double lat1 = Math.toRadians(point1.getLatitude());
        double lon1 = Math.toRadians(point1.getLongitude());
        double lat2 = Math.toRadians(point2.getLatitude());
        double lon2 = Math.toRadians(point2.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIUS_OF_EARTH * c; // Distance in kilometers
    }
    public static double calculateTime(GeoPoint point1, GeoPoint point2)
    {
        double speed = 20;
        double distance = calculateDistance(point1,point2);
        double time = (distance*60)/speed; // in minutes;
        return time;
    }
}
