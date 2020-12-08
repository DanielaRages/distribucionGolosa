package Interfaz;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import Logica.algoritmoGoloso;
import Logica.centroDistribucion;
import Logica.cliente;
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

	//CONSTRUYE LA VENTANA PRINCIPAL DE LA APLICACI�N
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
		
		//LABEL T�TULO
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
		
		//FRANJA DE TEXTO DONDE EL USUARIO DIGITA UN N�MERO
		txtCantidad = new JTextField();
		txtCantidad.setBounds(268, 321, 139, 28);
		frame.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		//BOT�N QUE GUARDA LA INFO DADA POR EL USUARIO
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cant = Integer.parseInt(txtCantidad.getText());	
				if(validarInput(txtCantidad)) {
					instancia = new instancia();
					instancia.setCantidadCentrosAbrir(cant);
					algoritmoGoloso g = new algoritmoGoloso(instancia);
					g.calcularDistanciaCentro();
					g.promedioDistanciaClientesCentro();
					ArrayList<centroDistribucion> listaDefinitiva = g.abrirCentros();
					ArrayList<cliente> listaClientes = instancia.getClientes();
					mapa = new mapaResultado(listaDefinitiva, listaClientes, g);
					mapa.getFrame().setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		btnGuardar.setBounds(293, 410, 89, 23);
		frame.getContentPane().add(btnGuardar);
	}

	//VALIDACI�N DE LOS DATOS INGRESADOS POR EL USUARIO.
	public boolean validarInput(JTextField txtCantidad) {
		
		int cant = Integer.parseInt(txtCantidad.getText());		
		if (txtCantidad.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "No debe de estar vac�o.");		
			return false;
		}
		else if (cant > reader.CantDeCentroDistribucion()) {
			JOptionPane.showMessageDialog(null, "Cantidad de centros excedida.");
			return false;
		}
		else {		
			try {Integer.parseInt(txtCantidad.getText());}
			catch (NumberFormatException excepcion){
				JOptionPane.showMessageDialog(null, "Ingrese solo n�meros");
				txtCantidad.setText(null);
				return false; 
			}
		}
		return true;	
	}
	//GETTER
	public JFrame getFrame() {return frame;}
}
