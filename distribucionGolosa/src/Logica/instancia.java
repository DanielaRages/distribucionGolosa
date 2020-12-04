package Logica;

import java.util.ArrayList;

import readerData.readerData;

//instancia del problema
public class instancia {
	private int cantidadCentrosAbrir;
	private ArrayList <centroDistribucion> centros;
	private ArrayList <cliente> clientes;
	readerData data = new readerData();
	
	
	instancia(int cant){ //se inicializan
		if(cant > centros.size())
			throw new IllegalArgumentException ("La cantidad no debe superar a la cantidad de centros disponibles.");
		cantidadCentrosAbrir = cant;
		centros = data.listaCentroDistribucion();
		clientes = data.listaClientes();
	}
	

	public int getCantidadCentrosAbrir() {
		return cantidadCentrosAbrir;
	}
	

	@SuppressWarnings("unchecked")
	public ArrayList<centroDistribucion> getCentros() {
		return (ArrayList<centroDistribucion>) centros.clone();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<cliente> getClientes() {
		return (ArrayList<cliente>) clientes.clone();
	}
	
	
	
	
}
