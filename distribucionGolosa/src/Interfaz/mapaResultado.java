package Interfaz;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import Logica.centroDistribucion;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mapaResultado {

	//VARIABLES
	private JFrame frame;
	private JMapViewer mapa;

	//CONSTRUYE EL MAPA CON LOS RESULTADOS DEL ALGORITMO
	public mapaResultado(ArrayList<centroDistribucion> centrosDefinitivos) {
		initialize();
		ilustrarCentros(centrosDefinitivos);
	}

	//INICIALIZA EL CONTENIDO DEL FRAME
	private void initialize() {
		frame = new JFrame();
		mapa = new JMapViewer();
		frame.setBounds(650, 200, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Distribucion Golosa");
		Coordinate coordenadaUbicacion = new Coordinate(-34.54122953311153, -58.71367855692343);
		mapa.setDisplayPosition(coordenadaUbicacion, 12);
		//mapa.setZoomControlsVisible(false); -- oculta la barra de zoom
		
		//AGREGA UN MARCADOR USTED EST� AQU�	
		MapMarker marcador = new MapMarkerDot("Usted est� aqu�", coordenadaUbicacion);
		marcador.getStyle().setBackColor(Color.RED);
		mapa.addMapMarker(marcador);
		frame.getContentPane().add(mapa);
		mapa.setLayout(null);
		
		//BOT�N CONTINUAR
		JButton Bot�n = new JButton("Continuar");
		Bot�n.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				estadisticas vent = new estadisticas();
				vent.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		Bot�n.setBounds(572, 532, 85, 21);
		mapa.add(Bot�n);
	}
	
	//M�TODO QUE MUESTRA LOS CENTROS DE DISTRIBUCI�N EN EL MAPA
	void ilustrarCentros(ArrayList<centroDistribucion> centrosDefinitivos) {
		for (centroDistribucion centro : centrosDefinitivos) {
			Coordinate coordenada = new Coordinate(centro.getLatitud(), centro.getLongitud());
			MapMarker marcador = new MapMarkerDot(centro.getIdentificacion(), coordenada);
			mapa.addMapMarker(marcador);
		}
	}
	
	//GETTER
	public JFrame getFrame() {return frame;}
}
