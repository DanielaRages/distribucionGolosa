package Test;

import java.util.ArrayList;

import org.junit.Test;

import Logica.centroDistribucion;
import Logica.cliente;
import readerData.readerData;

public class readerDataTest {
	
	centroDistribucion centro1 = new centroDistribucion("Centro Zapiola",-34.5357713,-58.7111123);
	centroDistribucion centro2 = new centroDistribucion("Centro Muñoz",-34.5322766,-58.7162855);
	centroDistribucion centro3 = new centroDistribucion("Centro Mendoza",-34.5361073,-58.7193135);
	centroDistribucion centro4 = new centroDistribucion("Centro Velazquez",-34.5369559,-58.7122991);
	cliente cliente1 = new cliente("Cliente Conesa", -34.5426564, -58.7016914);
	cliente cliente2 = new cliente("Cliente Las Heras", -34.5412454, -58.7040789);
	cliente cliente3 = new cliente("Cliente Malnatti", -34.5351635, -58.7080826);
	cliente cliente4 = new cliente("Cliente San Lorenzo", -34.5332466, -58.7233678);
	cliente cliente5 = new cliente("Cliente Darragueira", -34.5253765, -58.7054305);
	cliente cliente6 = new cliente("Cliente Urquiza", -34.5258803, -58.7253989);
	cliente cliente7 = new cliente("Cliente Maria Paz", -34.5350873, -58.7183408);
	cliente cliente8 = new cliente("Cliente Libertad", -34.5485302, -58.7200444);
	cliente cliente9 = new cliente("Cliente Roque", -34.5428841, -58.7171066);
	cliente cliente10 = new cliente("Cliente Roca", -34.5492275, -58.7120463);
	
	@Test
	public void listaCentroDistribucionTest() 
	{
		readerData data = new readerData();
		ArrayList<centroDistribucion> lista = data.listaCentroDistribucion(); 
		centroDistribucion[] centros = new centroDistribucion[4];
		centros[0] = centro1;
		centros[1] = centro2;
		centros[2] = centro3;
		centros[3] = centro4;
		
		Assert.igualesCentros(centros, lista);
	}
	
	@Test
	public void listaClientesTest() 
	{
		readerData data = new readerData();
		ArrayList<cliente> lista = data.listaClientes();
		cliente[] clientes = new cliente[10];
		clientes[0] = cliente1;
		clientes[1] = cliente2;
		clientes[2] = cliente3;
		clientes[3] = cliente4;
		clientes[4] = cliente5;
		clientes[5] = cliente6;
		clientes[6] = cliente7;
		clientes[7] = cliente8;
		clientes[8] = cliente9;
		clientes[9] = cliente10;
		
		Assert.igualesClientes(clientes, lista);
	}

}
