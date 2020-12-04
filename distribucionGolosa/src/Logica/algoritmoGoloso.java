package Logica;

import java.util.ArrayList;
import java.util.Collections;

public class algoritmoGoloso {
	
	//VARIABLES
	private instancia instancia;
	
	//CONSTRUCTOR
	public algoritmoGoloso(instancia inst){instancia = inst;}
	
	//CALCULA LA DISTANCIA DE UN CENTRO CON CADA CLIENTE
	public void calcularDistanciaCentro() { //Añade a cada uno de los centros la distancia total de los clientes hacia el.
		
		calculoDistanciaRecta calculo = new calculoDistanciaRecta(); 
		for (centroDistribucion centro: instancia.getCentros()) {
			double aux = 0;
			for (cliente cliente: instancia.getClientes()) {
				aux += calculo.calcularSemiverseno(centro.getLatitud(), centro.getLongitud(), cliente.getLatitud(), cliente.getLongitud());
			}
			centro.setDistanciaTotalConClientes(aux);
		}
	}
	
	//ORDENAMIENTO DE LOS CENTROS EN MENOR A MAYOR COSTO 
	public ArrayList<centroDistribucion> ordenarCentros(){
		ArrayList<centroDistribucion> centros = instancia.getCentros();
		Collections.sort(centros);
		return centros;
	}
	
	//DEVUELVE EL PROMEDIO DE DISTANCIAS DE LOS CLIENTES CON UN CENTRO
	public double promedioDistanciaClientesCentro() {
		double promedioDistancia = 0;
		for(centroDistribucion centro : instancia.getCentros()) {
			promedioDistancia = centro.getDistanciaConClientes() / instancia.getClientes().size();
			centro.setPromedioDistanciaConClientes(promedioDistancia);
		}
		return promedioDistancia;
	}
	
	//DEVUELVE EL PROMEDIO DE TODOS LOS CENTROS
	public double promedioDistanciaTodosLosCentros() {
		double centros = 0;
		double promedioTotal = 0;
		for(centroDistribucion centro : instancia.getCentros()) {
			centros += centro.getPromedioDistanciaConClientes();
		}
		promedioTotal = centros / instancia.getCentros().size();
		return promedioTotal;
	}
	
	//DEVUELVE LOS CENTROS QUE CUMPLEN CON LA CONDICIÓN PARA SER SELECCIONADOS	
	public ArrayList<centroDistribucion> abrirCentros(){
		ArrayList<centroDistribucion> centrosAbrir = new ArrayList<centroDistribucion>();
		int cant = 0;
		for(centroDistribucion centro: ordenarCentros()) {
			if(cant < instancia.getCantidadCentrosAbrir()) {
				centrosAbrir.add(centro);
				cant ++;
			}
		}
		return centrosAbrir;
	}

}
