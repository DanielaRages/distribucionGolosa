package Interfaz;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import Logica.algoritmoGoloso;
import Logica.centroDistribucion;
import Logica.cliente;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class mapaResultado {

	//VARIABLES
	private JFrame frame;
	private JMapViewer mapa;

	//CONSTRUYE EL MAPA CON LOS RESULTADOS DEL ALGORITMO
	public mapaResultado(ArrayList<centroDistribucion> centrosDefinitivos, ArrayList<cliente> clientes, algoritmoGoloso g) {
		initialize(centrosDefinitivos, g);
		ilustrarCentros(centrosDefinitivos);
		ilustrarClientes(clientes);
	}

	//INICIALIZA EL CONTENIDO DEL FRAME
	private void initialize(ArrayList<centroDistribucion> centrosDefinitivos, algoritmoGoloso g) {
		frame = new JFrame();
		mapa = new JMapViewer();
		frame.setBounds(650, 200, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Distribucion Golosa");
		Coordinate coordenadaUbicacion = new Coordinate(-34.540, -58.710);
		mapa.setDisplayPosition(coordenadaUbicacion, 14);
		frame.getContentPane().add(mapa);
		mapa.setLayout(null);
		
		//BOTÓN CONTINUAR
		JButton Botón = new JButton("Continuar");
		Botón.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		Botón.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				estadisticas vent = new estadisticas(centrosDefinitivos, g);
				vent.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		Botón.setBounds(557, 532, 100, 21);
		mapa.add(Botón);
	}
	
	//MÉTODO QUE MUESTRA LOS CENTROS DE DISTRIBUCIÓN EN EL MAPA
	void ilustrarCentros(ArrayList<centroDistribucion> centrosDefinitivos) {
		for (centroDistribucion centro : centrosDefinitivos) {
			Coordinate coordenada = new Coordinate(centro.getLatitud(), centro.getLongitud());
			MapMarker marcador = new MapMarkerDot(centro.getIdentificacion(), coordenada);
			mapa.addMapMarker(marcador);
		}
	}
	
	//MÉTODO QUE MUESTRA LOS CLIENTES EN EL MAPA
	void ilustrarClientes(ArrayList<cliente> clientes) {
		for(cliente cliente: clientes) {
			Coordinate coordenada = new Coordinate(cliente.getLatitud(), cliente.getLongitud());
			MapMarker marcador = new MapMarkerDot(cliente.getNombre(), coordenada);
			marcador.getStyle().setBackColor(Color.green);
			mapa.addMapMarker(marcador);
		}
	}
	
	//GETTER
	public JFrame getFrame() {return frame;}
}
