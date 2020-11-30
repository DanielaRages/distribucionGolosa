package Herramienta;
//
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

		//considerar casos bordes
		try {
			br = new BufferedReader (new FileReader (path));
			String line = br.readLine();
			while (line != null) {
				String [] array = line.split(";");
				//aca deberia de crear un objeto generico con los 3 parametros
				//y que lo añada a arrayDatos
				//otra opcion es hacer un if grande y repetir la parte del 
				//codigo de try and catch para cliente y exactamente
				//lo mismo para centrosDistrib
				//arrayDatos.add();
				line = br.readLine();
			}		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		return arrayDatos;
	}

}

