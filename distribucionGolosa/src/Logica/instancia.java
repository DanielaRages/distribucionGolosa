package Logica;

import java.util.ArrayList;

import readerData.readerData;

public class instancia {
	
	//VARIABLES
	private int cantidadCentrosAbrir;
	private ArrayList <centroDistribucion> centros;
	private ArrayList <cliente> clientes;
	private readerData data = new readerData();
	

	//CONSTRUCTOR
	public instancia(){ //PIDE LA CANTIDAD DE CENTROS QUE DESEA ABRIR
		centros = data.listaCentroDistribucion();
		clientes = data.listaClientes();
	}
	
	public void setCantidadCentrosAbrir(int cant) {
		if(cant > centros.size())
		throw new IllegalArgumentException ("La cantidad no debe superar a la cantidad de centros disponibles.");
	cantidadCentrosAbrir = cant;
	}
	//GETTERS
	public int getCantidadCentrosAbrir() {
		return cantidadCentrosAbrir;
	}
	
	public ArrayList<centroDistribucion> getCentros() {
		return centros;
	}
	
	public ArrayList<cliente> getClientes() {
		return clientes;
	}

//	@SuppressWarnings("unchecked")
//	public ArrayList<centroDistribucion> getCentros() { //ENTREGA UNA COPIA DE LA LISTA
//		return (ArrayList<centroDistribucion>) centros.clone();
//	}
//	
//
//	@SuppressWarnings("unchecked")
//	public ArrayList<cliente> getClientes() { //ENTREGA UNA COPIA DE LA LISTA
//		return (ArrayList<cliente>) clientes.clone();
//	}
	
}
