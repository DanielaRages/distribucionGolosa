package Test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import Logica.calculoDistanciaRecta; 

public class calculoDistanciaRectaTest {
	
	@Test
	public void calcularDistancia() 
	{
		calculoDistanciaRecta distancia = new calculoDistanciaRecta();
		double km = distancia.calcularSemiverseno(-54.807222, -68.304444, -53.783333, -67.7);
		assertTrue(km == 120.41768294002374);
	}

}
