package Interfaz;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import Logica.algoritmoGoloso;
import Logica.centroDistribucion;
import Logica.instancia;
import readerData.readerData;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class ventanaPrincipal {
	
	//VARIABLES
	private JFrame frame;
	private mapaResultado mapa; 
	private JTextField txtCantidad;
	private readerData reader;
	private instancia instancia;

	//CONSTRUYE LA VENTANA PRINCIPAL DE LA APLICACIÓN
	public ventanaPrincipal() {
		initialize();
	}

	//INICIALIZA LOS CONTENIDOS DEL FRAME
	private void initialize() {
		
		reader = new readerData();
		frame = new JFrame();
		frame.setBounds(650, 200, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Distribucion Golosa");
		frame.getContentPane().setLayout(null);
		
		//LABEL TÍTULO
		JLabel lblTitulo = new JLabel("Distribucion Golosa");
		lblTitulo.setFont(new Font("Adobe Gothic Std B", Font.PLAIN, 36));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(62, 95, 539, 100);
		frame.getContentPane().add(lblTitulo);
		
		//LABEL ENUNCIADO
		JLabel lblEnunciado = new JLabel("Ingrese la cantidad de centros que desea abrir:");
		lblEnunciado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnunciado.setBounds(169, 238, 371, 59);
		frame.getContentPane().add(lblEnunciado);
		
		//FRANJA DE TEXTO DONDE EL USUARIO DIGITA UN NÚMERO
		txtCantidad = new JTextField();
		txtCantidad.setBounds(268, 321, 139, 28);
		frame.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		//BOTÓN QUE GUARDA LA INFO DADA POR EL USUARIO
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cant = Integer.parseInt(txtCantidad.getText());		
				if (cant > reader.CantDeCentroDistribucion()) {
					JOptionPane.showMessageDialog(null, "Cantidad de centros excedida.");
				}
				else {
					instancia = new instancia();
					instancia.setCantidadCentrosAbrir(cant);
					algoritmoGoloso g = new algoritmoGoloso(instancia);
					g.calcularDistanciaCentro();
					ArrayList<centroDistribucion> listaDefinitiva = g.abrirCentros();
					mapa = new mapaResultado(listaDefinitiva);
					mapa.getFrame().setVisible(true);
					frame.setVisible(false);
					
				}	
			}
		});
		btnGuardar.setBounds(293, 410, 89, 23);
		frame.getContentPane().add(btnGuardar);
	}

	//GETTER
	public JFrame getFrame() {
		return frame;
	}
}
