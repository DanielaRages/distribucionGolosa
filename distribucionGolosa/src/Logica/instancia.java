package Logica;

import java.util.ArrayList;

//instancia del problema
public class instancia {
	private int cantidadCentrosAbrir;
	private ArrayList <centroDistribucion> centros;
	private ArrayList <cliente> clientes;
	
	instancia(int cant){
		if(cant > centros.size())
			throw new IllegalArgumentException ("La cantidad no debe superar a la cantidad de centros disponibles.");
		cantidadCentrosAbrir = cant;
	}
	
}
