package Logica;

import java.util.ArrayList;
import java.util.Collections;

public class algoritmoGoloso {
	
	//VARIABLES
	private instancia instancia;
	
	//CONSTRUCTOR
	public algoritmoGoloso(instancia inst){instancia = inst;}
	
	//AÑADE A CADA UNO DE LOS CENTROS LA DISTANCIA TOTAL DE LOS CLIENTES HACIA EL.
	public void calcularDistanciaCentro() { 
		for (centroDistribucion centro: instancia.getCentros()) {
			centro.setDistanciaTotalConClientes(calcularDistancia(centro));
		}
	}
	
	//CALCULA LA DISTANCIA DE UN CENTRO CON CADA CLIENTE
	private double calcularDistancia(centroDistribucion centro) {
		calculoDistanciaRecta calculo = new calculoDistanciaRecta(); 
		double aux = 0;
		for (cliente cliente: instancia.getClientes()) {
			aux += calculo.calcularSemiverseno(centro.getLatitud(), centro.getLongitud(), cliente.getLatitud(), cliente.getLongitud());
		}
		centro.setDistanciaTotalConClientes(aux);
		return aux;
	}
	
	//ORDENAMIENTO DE LOS CENTROS EN MENOR A MAYOR COSTO 
	public ArrayList<centroDistribucion> ordenarCentros(){
		ArrayList<centroDistribucion> centros = instancia.getCentros();
		Collections.sort(centros);
		return centros;
	}
	
	//CALCULA EL PROMEDIO DE DISTANCIAS DE LOS CLIENTES CON UN CENTRO
	public void promedioDistanciaClientesCentro() {
		double promedioDistancia = 0;
		ArrayList<centroDistribucion> centros = new ArrayList<>();
		for(centroDistribucion centro : instancia.getCentros()) {
			promedioDistancia = centro.getDistanciaConClientes() / instancia.getClientes().size();
			centro.setPromedioDistanciaConClientes(promedioDistancia);
			centros.add(centro);
		}
	}
	
	//DEVUELVE EL PROMEDIO DE TODOS LOS CENTROS
	public double promedioDistanciaTodosLosCentros() {
		double centros = 0;
		double promTotal = 0;
		for(centroDistribucion centro : instancia.getCentros()) {
			centros += centro.getDistanciaConClientes();
		}
		promTotal = centros / instancia.getCentros().size();
		instancia.setPromedioTotal(promTotal);
		return promTotal;
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