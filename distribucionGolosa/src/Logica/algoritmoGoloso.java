package Logica;

public class algoritmoGoloso {
	
	private instancia instancia;
	
	algoritmoGoloso(instancia inst){
		instancia = inst;
	}
	
	public void calcularDistanciaCentro() { //añade a cada uno de los centros la distancia total de los clientes hacia el 
		calculoDistanciaRecta calculo = new calculoDistanciaRecta(); 
		for (int centro = 0; centro < instancia.getCentros().size(); centro++) {
			double aux = 0;
			for (int cliente = 0; cliente < instancia.getClientes().size(); cliente++) {
				aux += calculo.calcularSemiverseno(instancia.getCentros().get(centro).getLatitud(), instancia.getCentros().get(centro).getLongitud(), instancia.getClientes().get(cliente).getLatitud(), instancia.getClientes().get(cliente).getLongitud());
			}
			instancia.getCentros().get(centro).setDistanciaTotalConClientes(aux);
		}
	}
	
	
	
	

}
