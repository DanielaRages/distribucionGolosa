package Logica;

import java.util.ArrayList;

import readerData.readerData;

public class instancia {
	
	//VARIABLES
	private int cantidadCentrosAbrir;
	private ArrayList <centroDistribucion> centros;
	private ArrayList <cliente> clientes;
	private readerData data = new readerData();
	private double promedioTotal; //PROMEDIO TOTAL DE LA DISTANCIA DE TODOS LOS CLIENTES A TODOS LOS CENTROS

	//CONSTRUCTOR
	public instancia(){ //PIDE LA CANTIDAD DE CENTROS QUE DESEA ABRIR
		centros = data.listaCentroDistribucion();
		clientes = data.listaClientes();
	}
	
	//SETTERS
	public void setCantidadCentrosAbrir(int cant) {
		if(cant > centros.size())
			throw new IllegalArgumentException ("La cantidad no debe superar a la cantidad de centros disponibles.");
		cantidadCentrosAbrir = cant;
	}
	
	public void setPromedioTotal(double prom) {
		this.promedioTotal = prom;
	}
	
	//GETTERS
	public int getCantidadCentrosAbrir() {return cantidadCentrosAbrir;}
	
	public ArrayList<centroDistribucion> getCentros() {return centros;}
	
	public ArrayList<cliente> getClientes() {return clientes;}
	
	public double getPromedioTotal() {return promedioTotal;}
	
}