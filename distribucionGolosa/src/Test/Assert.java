package Test;

import java.util.ArrayList;

import Logica.centroDistribucion;
import Logica.cliente;

import static org.junit.Assert.*;

public class Assert 
{
	public static void igualesCentros(centroDistribucion [] esperado, ArrayList<centroDistribucion> alcanzables)
	{
		assertEquals(esperado.length, alcanzables.size());
		int cont = 0;
		for (int i = 0; i < esperado.length; i++) {
			if(esperado[i].equals(alcanzables.get(i))) 
			{
				cont++;
			}
		}
		assertTrue(cont == esperado.length);
	}
	
	public static void igualesClientes(cliente [] esperado, ArrayList<cliente> alcanzables)
	{
		assertEquals(esperado.length, alcanzables.size());
		int cont = 0;
		for (int i = 0; i < esperado.length; i++) {
			if(esperado[i].equals(alcanzables.get(i))) 
			{
				cont++;
			}
		}
		assertTrue(cont == esperado.length);
	}
	

}