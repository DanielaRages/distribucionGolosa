package readerData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

import Logica.calculoDistanciaRecta;
import Logica.centroDistribucion;
import Logica.cliente;

public class readerData {
	
	public  ArrayList<centroDistribucion> listaCentroDistribucion(){
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
	
	
	public  ArrayList<cliente> listaClientes(){
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
//	
//	public static void main(String args[]) {
//		ArrayList <cliente> listaDeClientes = listaClientes();
//		for (cliente c : listaDeClientes) {
//			System.out.println(c.toString());
//		}
//		
//		ArrayList<centroDistribucion> listaDeCentros = listaCentroDistribucion();
//		for (centroDistribucion c : listaDeCentros) {
//			System.out.println(c.toString());
//		}
//		
//		for (int i = 0; i < listaDeCentros.size(); i++) {
//			 calculoDistanciaRecta t = new calculoDistanciaRecta();
//			 double aux = 0;
//			for (int j = 0; j < listaDeClientes.size(); j++) {
//				aux += t.calcularSemiverseno(listaDeCentros.get(i).getLatitud(), listaDeCentros.get(i).getLongitud(), listaDeClientes.get(j).getLatitud(), listaDeClientes.get(i).getLongitud());
//			}
//			System.out.println("Distancia total centro con los clientes: " + aux);
//		}
//	}

}

