package Logica;

public class centroDistribucion implements Comparable<centroDistribucion>{
	
	//VARIABLES
	private String identificacion;
	private double latitud;
	private double longitud;
	private double distanciaTotalConClientes; //DISTANCIA TOTAL CON TODOS LOS CLIENTES DEL MAPA.
	private double promedioDistanciaConClientes; //PROMEDIO TOTAL DE LA DISTANCIA CON TODOS LOS CLIENTES DEL MAPA.
	
	//CONSTRUCTOR
	public centroDistribucion(String id, double lat, double log) {
		identificacion = id;
		latitud = lat;
		longitud = log;
	}

	//GETTERS
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
	
	public double getPromedioDistanciaConClientes() {
		return promedioDistanciaConClientes;
	}
	
	//SETTERS
	public void setDistanciaTotalConClientes(double distanciaTotalConClientes) {
		this.distanciaTotalConClientes = distanciaTotalConClientes;
	}
	
	public void setPromedioDistanciaConClientes(double promedioDistanciaConClientes) {
		this.promedioDistanciaConClientes = promedioDistanciaConClientes;
	}
	
	//SOBRESCRIBE EL MÉTODO EQUALS
		@Override
		public boolean equals(Object obj){
			
			if(this.getClass() != obj.getClass()) {return false;}
		   
	    	centroDistribucion otro = (centroDistribucion) obj;
	    	
	    	if(this.getIdentificacion().equals(otro.getIdentificacion()) &&
				this.getLatitud() == otro.getLatitud() &&
				this.getLongitud() == otro.getLongitud()) 
	    		
	    	{return true;}
	    	
	    	else {return false;}
	   }

	//MÉTODO TOSTRING
	@Override
	public String toString() {
		return "centroDistribucion [identificacion=" + identificacion + ", latitud=" + latitud + ", longitud="
				+ longitud + ", distanciaConClientes=" + distanciaTotalConClientes + "]";
	}

	//MÉTODO COMPARABLE PARA HACER EL ORDENAMIENTO
	@Override
	public int compareTo(centroDistribucion c) {
		return  (int) this.getDistanciaConClientes() - (int) c.getDistanciaConClientes();
	}
}
