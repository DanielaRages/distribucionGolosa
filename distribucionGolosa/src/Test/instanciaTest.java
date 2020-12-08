package Test;

import org.junit.Test;

import Logica.instancia;

public class instanciaTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void NumeroInvalidoTest() 
	{
		instancia i = new instancia();
		i.setCantidadCentrosAbrir(5);
	}

}
