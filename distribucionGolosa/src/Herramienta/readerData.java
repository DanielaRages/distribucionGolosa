package Herramienta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

import Logica.centroDistribucion;
import Logica.cliente;

public class readerData {
	
	public static ArrayList<centroDistribucion> listaCentroDistribucion(){
		String path;
		ArrayList <centroDistribucion> arrayCentros = new ArrayList <centroDistribucion>();
		BufferedReader br = null;
		path = "datosCsv/centrosDistribucion.csv";

		try {
			br = new BufferedReader (new FileReader (path));
			String line = br.readLine();
			while (line != null) {
				String [] array = line.split(";");
				centroDistribucion centro = new centroDistribucion(
											(array[0]),
											Double.parseDouble(array[1]),
											Double.parseDouble(array[2]));
				arrayCentros.add(centro);
				line = br.readLine();
			}		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		return arrayCentros;
	}
	
	
	public static ArrayList<cliente> listaClientes(){
		String path;
		ArrayList <cliente> arrayClientes = new ArrayList <cliente>();
		BufferedReader br = null;

     	path = "datosCsv/clientes.csv";
		
		try {
			br = new BufferedReader (new FileReader (path));
			String line = br.readLine();
			while (line != null) {
				String [] array = line.split(";");
				cliente cliente = new cliente(
											(array[0]),
											Double.parseDouble(array[1]),
											Double.parseDouble((array[2])));
				
				arrayClientes.add(cliente);
				line = br.readLine();
			}		
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return arrayClientes;
	}
	
	public static void main(String args[]) {
		ArrayList <cliente> test = listaClientes();
		for (cliente c : test) {
			System.out.println(c.toString());
		}
		
		ArrayList<centroDistribucion> test2 = listaCentroDistribucion();
		for (centroDistribucion c : test2) {
			System.out.println(c.toString());
		}
		
	}

}

