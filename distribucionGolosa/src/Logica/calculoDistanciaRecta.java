package Logica;

public class calculoDistanciaRecta {

	public static double calcularSemiverseno(double latitud1, double longitud1, double latitud2, double longitud2) {

	        double radioTierra = 6371; //dato en km

	        latitud1 = Math.toRadians(latitud1);
	        longitud1 = Math.toRadians(longitud1);
	        latitud2 = Math.toRadians(latitud2);
	        longitud2 = Math.toRadians(longitud2);

	        double dlon = (longitud2 - longitud1);
	        double dlat = (latitud2 - latitud1);

	        double sinlat = Math.sin(dlat / 2);
	        double sinlon = Math.sin(dlon / 2);

	        double a = (sinlat * sinlat) + Math.cos(latitud1)* Math.cos(latitud2)*(sinlon*sinlon);
	        double c = 2 * Math.asin (Math.min(1.0, Math.sqrt(a)));

	        double distanciaKm = radioTierra * c;

	        return distanciaKm;

	    }
	
}
