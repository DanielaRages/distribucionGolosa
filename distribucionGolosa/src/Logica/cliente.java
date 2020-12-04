package Logica;

public class cliente {
	
	//VARIABLES
	private String nombre;
	private double latitud;
	private double longitud;
	
	//CONSTRUCTOR
	public cliente(String n, double lat, double lon) {
		nombre = n;
		latitud = lat;
		longitud = lon;
	}
	
	//GETTERS
	public String getNombre() {
		return nombre;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	//MÉTODO TOSTRING
	@Override
	public String toString() {
		return "cliente [nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}

}