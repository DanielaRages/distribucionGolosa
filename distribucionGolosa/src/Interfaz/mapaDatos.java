package Interfaz;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import Logica.centroDistribucion;
import Logica.cliente;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mapaDatos {

	//VARIABLES
	private JFrame frame;
	private JMapViewer mapa;

	//CONSTRUYE EL MAPA CON LOS CENTROS DE DISTRIBUCI�N Y LOS CLIENTES
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
		frame.setTitle("Clientes y Centros de Distribuci�n");
		Coordinate coordenadaUbicacion = new Coordinate(-34.540, -58.710);
		mapa.setDisplayPosition(coordenadaUbicacion, 14);
		frame.getContentPane().add(mapa);
		mapa.setLayout(null);
		
		//BOT�N PARA CONTINUAR A LAS ESTAD�STICAS
		JButton Bot�n = new JButton("Continuar");
		Bot�n.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		Bot�n.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaPrincipal vent = new ventanaPrincipal();
				vent.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		Bot�n.setBounds(564, 532, 93, 21);
		mapa.add(Bot�n);
	}

	//M�TODO QUE MUESTRA LOS CENTROS DE DISTRIBUCI�N EN EL MAPA
	void ilustrarCentros(ArrayList<centroDistribucion> centros) {
		for (centroDistribucion centro : centros) {
			Coordinate coordenada = new Coordinate(centro.getLatitud(), centro.getLongitud());
			MapMarker marcador = new MapMarkerDot(centro.getIdentificacion(), coordenada);
			mapa.addMapMarker(marcador);
		}
	}

	//M�TODO QUE MUESTRA LOS CLIENTES EN EL MAPA
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
