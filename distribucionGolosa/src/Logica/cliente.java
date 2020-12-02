package Logica;

public class cliente {
	private String nombre;
	private double latitud;
	private double longitud;
	
	public cliente(String n, double lat, double lon) {
		nombre = n;
		latitud = lat;
		longitud = lon;
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	@Override
	public String toString() {
		return "cliente [nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}

	
}