package Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Logica.algoritmoGoloso;
import Logica.instancia;

public class algoritmoGolosoTest {
	
	@Test
	public void calcularDistanciaCentroTest() {
		
		instancia i = new instancia(1);
		algoritmoGoloso algoritmo = new algoritmoGoloso(i);
		algoritmo.calcularDistanciaCentro();
		assertTrue(i.getCentros().get(0).getDistanciaConClientes() == 11.225523227019298);
		
	}
	
	@Test
	public void 

}
