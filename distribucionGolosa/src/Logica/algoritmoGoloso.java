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
		
		for (centroDistribucion centro: instancia.getCentros()) {
			calcularDistancia(centro);
		}
	}
	
	private void calcularDistancia(centroDistribucion centro) 
	{
		calculoDistanciaRecta calculo = new calculoDistanciaRecta(); 
		
			double aux = 0;
			for (cliente cliente: instancia.getClientes()) {
				aux += calculo.calcularSemiverseno(centro.getLatitud(), centro.getLongitud(), cliente.getLatitud(), cliente.getLongitud());
			}
			centro.setDistanciaTotalConClientes(aux);
		
	}
	
	
	//ORDENAMIENTO DE LOS CENTROS EN MENOR A MAYOR COSTO 
	public ArrayList<centroDistribucion> ordenarCentros(){
		ArrayList<centroDistribucion> centros = instancia.getCentros();
		Collections.sort(centros); //de menor a mayor
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
		for(centroDistribucion centro : instancia.getCentros()) {
			centros += centro.getDistanciaConClientes();
		}
		double promedioTotal = centros / instancia.getCentros().size();
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
	
	public static void main(String args[]) {
        instancia i = new instancia(3);
        algoritmoGoloso n = new algoritmoGoloso(i);
        n.calcularDistanciaCentro();
        n.ordenarCentros();
    //    ArrayList<centroDistribucion> definitiva = n.abrirCentros();
        for (centroDistribucion d : i.getCentros()) {
            System.out.println(d.toString());
        }
    }
}