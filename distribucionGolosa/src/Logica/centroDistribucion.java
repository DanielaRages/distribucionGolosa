package Logica;


public class centroDistribucion {
	private String identificacion;
	private double latitud;
	private double longitud;
	private double distanciaTotalConClientes; //distancia total entre el centro con todos los clientes del mapa
	
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


	public double getDistanciaConClientes() {
		return distanciaTotalConClientes;
	}
	

	public void setDistanciaTotalConClientes(double distanciaTotalConClientes) {
		this.distanciaTotalConClientes = distanciaTotalConClientes;
	}


	@Override
	public String toString() {
		return "centroDistribucion [identificacion=" + identificacion + ", latitud=" + latitud + ", longitud="
				+ longitud + ", distanciaConClientes=" + distanciaTotalConClientes + "]";
	}



	
	
	
}
