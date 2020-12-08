package Test;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import Logica.algoritmoGoloso;
import Logica.centroDistribucion;
import Logica.instancia;

public class algoritmoGolosoTest {
	
	centroDistribucion centro1 = new centroDistribucion("Centro Velazquez",-34.5369559,-58.7122991);
	centroDistribucion centro2 = new centroDistribucion("Centro Zapiola",-34.5357713,-58.7111123);
	centroDistribucion centro3 = new centroDistribucion("Centro Mendoza",-34.5361073,-58.7193135);
	centroDistribucion centro4 = new centroDistribucion("Centro Muñoz",-34.5322766,-58.7162855);
	
	@Test
	public void calcularDistanciaCentroTest() {
		
		instancia i = new instancia();
		i.setCantidadCentrosAbrir(1);
		algoritmoGoloso algoritmo = new algoritmoGoloso(i);
		algoritmo.calcularDistanciaCentro();
		assertTrue(i.getCentros().get(0).getDistanciaConClientes() == 11.225523227019298);
		
	}
	
	@Test
	public void ordenarCentrosTest() 
	{
		instancia i = new instancia();
		i.setCantidadCentrosAbrir(4);
		algoritmoGoloso algoritmo = new algoritmoGoloso(i);
		algoritmo.calcularDistanciaCentro();
		algoritmo.ordenarCentros();
		centroDistribucion[] centros = new centroDistribucion[4];
		centros[0] = centro1;
		centros[1] = centro2;
		centros[2] = centro3;
		centros[3] = centro4;
		Assert.igualesCentros(centros, i.getCentros());
	}
	
	@Test
	public void promedioDistanciaClientesCentroTest() 
	{
		instancia i = new instancia();
		i.setCantidadCentrosAbrir(4);
		algoritmoGoloso algoritmo = new algoritmoGoloso(i);
		algoritmo.calcularDistanciaCentro();
		algoritmo.promedioDistanciaClientesCentro();
		assertTrue(i.getCentros().get(0).getDistanciaConClientes() == 11.225523227019298);
	}
	
	@Test
	public void promedioDistanciaTodosLosCentrosTest() 
	{
		instancia i = new instancia();
		i.setCantidadCentrosAbrir(4);
		algoritmoGoloso algoritmo = new algoritmoGoloso(i);
		algoritmo.calcularDistanciaCentro();
		algoritmo.promedioDistanciaClientesCentro();
		algoritmo.promedioDistanciaTodosLosCentros();
		assertTrue(algoritmo.promedioDistanciaTodosLosCentros() == 11.575681556126826);
	}
	
	@Test
	public void abrirCentrosTest() 
	{
		instancia i = new instancia();
		i.setCantidadCentrosAbrir(2);
		algoritmoGoloso algoritmo = new algoritmoGoloso(i);
		algoritmo.calcularDistanciaCentro();
		algoritmo.ordenarCentros();
		ArrayList<centroDistribucion> abrirCentro = algoritmo.abrirCentros();
		centroDistribucion[] centros = new centroDistribucion[2];
		centros[0] = centro1;
		centros[1] = centro2;
		Assert.igualesCentros(centros, abrirCentro);
	}
	

}
