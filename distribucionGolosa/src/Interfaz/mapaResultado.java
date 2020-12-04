package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import java.awt.BorderLayout;

public class mapaResultado {

	private JFrame frame;
	private JMapViewer mapa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mapaResultado window = new mapaResultado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mapaResultado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		mapa = new JMapViewer();
		frame.setBounds(650, 200, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Distribucion Golosa");
		Coordinate coordinada = new Coordinate(-34.550, -58.719);
		mapa.setDisplayPosition(coordinada, 12);
		//mapa.setZoomControlsVisible(false); -- oculta la barra de zoom
		
		//Agregado de un marcador	
		MapMarker marcador1 = new MapMarkerDot("aqui", coordinada);
		marcador1.getStyle().setBackColor(Color.RED);
		//marcador1.getStyle().setColor(Color.blue);
		mapa.addMapMarker(marcador1);
		
		frame.getContentPane().add(mapa);
		mapa.setLayout(null);
	}
}
