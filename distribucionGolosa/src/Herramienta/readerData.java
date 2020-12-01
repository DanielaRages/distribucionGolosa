package Herramienta;
//
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Logica.centroDistribucion;
import Logica.cliente;

public class readerData <T> {
	
	//la idea es hacerlo generico para que lea los 2 csv y luego devuelva un arraylist
	//con los objetos del tipo que sean
	public ArrayList<centroDistribucion> listaCentroDistribucion(){
		String path;
		ArrayList <centroDistribucion> arrayCentros = new ArrayList <centroDistribucion>();
		BufferedReader br = null;
//		if (parametro.equals("cliente")) 
//			 path = "/ClientesEjemplo.csv";
		path = "/centrosDistribucionEjemplo.csv";

		//considerar casos bordes
		try {
			br = new BufferedReader (new FileReader (path));
			String line = br.readLine();
			while (line != null) {
				String [] array = line.split(";");
				//aca deberia de crear un objeto generico con los 3 parametros
				//y que lo añada a arrayDatos
				centroDistribucion centro = new centroDistribucion(
											(array[0]),
											Integer.parseInt(array[1]),
											Integer.parseInt(array[2]));
				
				//otra opcion es hacer un if grande y repetir la parte del 
				//codigo de try and catch para cliente y exactamente
				//lo mismo para centrosDistrib
				arrayCentros.add(centro);
				line = br.readLine();
			}		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		return arrayCentros;
	}
	
	
	public ArrayList<cliente> listaClientes(){
		String path;
		ArrayList <cliente> arrayClientes = new ArrayList <cliente>();
		BufferedReader br = null;

     	path = "/ClientesEjemplo.csv";
		

		//considerar casos bordes
		try {
			br = new BufferedReader (new FileReader (path));
			String line = br.readLine();
			while (line != null) {
				String [] array = line.split(";");
				//aca deberia de crear un objeto generico con los 3 parametros
				//y que lo añada a arrayDatos
				cliente cliente = new cliente(
											(array[0]),
											Integer.parseInt(array[1]),
											Integer.parseInt(array[2]));
				
				//otra opcion es hacer un if grande y repetir la parte del 
				//codigo de try and catch para cliente y exactamente
				//lo mismo para centrosDistrib
				arrayClientes.add(cliente);
				line = br.readLine();
			}		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		return arrayClientes;
	}
	

}

