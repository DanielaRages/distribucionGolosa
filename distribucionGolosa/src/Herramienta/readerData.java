package Herramienta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class readerData <T> {
	
	//la idea es hacerlo generico para que lea los 2 csv y luego devuelva un arraylist
	//con los objetos del tipo que sean
	public ArrayList<T> leerData(String parametro){
		String path;
		ArrayList <T> arrayDatos = new ArrayList <T>();
		BufferedReader br = null;
		if (parametro.equals("cliente")) 
			 path = "/ClientesEjemplo.csv";
		path = "/centrosDistribucionEjemplo.csv";

		return arrayDatos;
	}

}

