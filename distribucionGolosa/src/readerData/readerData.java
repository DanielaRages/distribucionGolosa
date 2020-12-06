package readerData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Logica.algoritmoGoloso;
import Logica.centroDistribucion;
import Logica.cliente;
import Logica.instancia;

public class readerData {

	
	//M�TODO QUE LEE Y DEVUELVE LA LISTA DE CENTROS DESDE UNA PLANILLA DE EXCEL

	public ArrayList<centroDistribucion> listaCentroDistribucion(){
		String path;
		ArrayList <centroDistribucion> arrayCentros = new ArrayList <centroDistribucion>();
		BufferedReader br = null;
		path = "datosCsv/centrosDistribucion.csv";

		try {
			br = new BufferedReader (new FileReader (path));
			String line = br.readLine();
			while (line != null) {
				String [] array = line.split(";");
				if(array.length!=3) 
				{
					br.close();
					throw new IllegalArgumentException ("No debe de estar vacia ninguna de las casillas del csv.");
				}
				centroDistribucion centro = new centroDistribucion(
											(array[0]),
											Double.parseDouble(array[1]),
											Double.parseDouble(array[2]));
				arrayCentros.add(centro);
				line = br.readLine();
			}				
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return arrayCentros;
	}
	
	//M�TODO QUE LEE Y DEVUELVE LA LISTA DE CLIENTES DESDE UNA PLANILLA DE EXCEL
	
	public ArrayList<cliente> listaClientes(){
		String path;
		ArrayList <cliente> arrayClientes = new ArrayList <cliente>();
		BufferedReader br = null;

     	path = "datosCsv/clientes.csv";
		
		try {
			br = new BufferedReader (new FileReader (path));
			String line = br.readLine();
			while (line != null) {
				String [] array = line.split(";");
				if(array.length!=3) 
				{
					br.close();
					throw new IllegalArgumentException ("No debe de estar vacia ninguna de las casillas del csv.");
				}
				cliente cliente = new cliente(
											(array[0]),
											Double.parseDouble(array[1]),
											Double.parseDouble((array[2])));
				
				arrayClientes.add(cliente);
				line = br.readLine();
			}		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return arrayClientes;
	}

	
	//DEVUELVE LA CANTIDAD DE CENTROS DE LA LISTA
	public int CantDeCentroDistribucion(){
        String path;
        int cont = 0;
        BufferedReader br = null;
        path = "datosCsv/centrosDistribucion.csv";
        
        try {
            br = new BufferedReader (new FileReader (path));
            String line = br.readLine();
            while (line != null) {
               cont++;
                line = br.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return cont;
    }
		
	public static void main(String args[]) {
        instancia i = new instancia(3);
        algoritmoGoloso n = new algoritmoGoloso(i);
        n.calcularDistanciaCentro();
    //    n.ordenarCentros();
    //    ArrayList<centroDistribucion> definitiva = n.abrirCentros();
        for (centroDistribucion d : i.getCentros()) {
            System.out.println(d.toString());
        }
    }


}


