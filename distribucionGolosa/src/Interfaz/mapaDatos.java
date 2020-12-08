package Interfaz;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import java.awt.EventQueue;
import Logica.centroDistribucion;
import Logica.cliente;
import Logica.instancia;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mapaDatos {

	//VARIABLES
	private JFrame frame;
	private JMapViewer mapa;

	//CONSTRUYE EL MAPA CON LOS CENTROS DE DISTRIBUCIÓN Y LOS CLIENTES
	public mapaDatos(ArrayList<centroDistribucion> centros, ArrayList<cliente> clientes) {
		initialize();
		ilustrarCentros(centros);
		ilustrarClientes(clientes);
}

	//INICIALIZA LOS CONTENIDOS DEL FRAME
	private void initialize() {
		frame = new JFrame();
		mapa = new JMapViewer();
		frame.setBounds(650, 200, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mapa);
		mapa.setLayout(null);
		frame.setTitle("Clientes y Centros de Distribución");
		Coordinate coordenadaUbicacion = new Coordinate(-34.54122953311153, -58.71367855692343);
		mapa.setDisplayPosition(coordenadaUbicacion, 12);
		
		//AGREGA UN MARCADOR USTED ESTÁ AQUÍ	
		MapMarker marcador = new MapMarkerDot("Usted está aquí", coordenadaUbicacion);
		marcador.getStyle().setBackColor(Color.RED);
		mapa.addMapMarker(marcador);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(mapa);
		mapa.setLayout(null);
		
		JButton Botón = new JButton("Continuar");
		Botón.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaPrincipal vent = new ventanaPrincipal();
				vent.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		Botón.setFont(new Font("Arial", Font.BOLD, 12));
		Botón.setBounds(567, 518, 95, 21);
		frame.getContentPane().add(Botón);
		
	}

	//MÉTODO QUE MUESTRA LOS CENTROS DE DISTRIBUCIÓN EN EL MAPA
	void ilustrarCentros(ArrayList<centroDistribucion> centros) {
		for (centroDistribucion centro : centros) {
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
	public JFrame getFrame() {
		return frame;
	}
}
