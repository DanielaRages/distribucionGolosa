package Logica;

//considerar si vamos a llamarlos por "A" "B" o por numeros
public class centroDistribucion {
	private String identificacion;
	private double latitud;
	private double longitud;
	
	public centroDistribucion(String id, double lat, double log) {
		identificacion = id;
		latitud = lat;
		longitud = log;
	}

	
	
	
	
	
	
	
	
	public String getIdentificacion() {
		return identificacion;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}
	
	
	
}
