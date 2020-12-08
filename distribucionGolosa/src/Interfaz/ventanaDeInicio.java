package Interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Logica.instancia;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class ventanaDeInicio {

	//VARIABLES
	private JFrame frame;

	//CONSTRUYE LA VENTANA DE INICIO DE LA APLICACIÓN
	public ventanaDeInicio() {
		initialize();
	}

	//INICIALIZA LOS CONTENIDOS DEL FRAME
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(650, 200, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Título = new JLabel("Centros de Distribuci\u00F3n");
		Título.setHorizontalAlignment(SwingConstants.CENTER);
		Título.setFont(new Font("Arial Black", Font.BOLD, 25));
		Título.setBounds(159, 52, 373, 82);
		frame.getContentPane().add(Título);
		
		JButton Botón = new JButton("Continuar");
		Botón.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				instancia i = new instancia();
				mapaDatos mapa = new mapaDatos(i.getCentros(), i.getClientes());
				mapa.getFrame().setVisible(true);
				frame.dispose();			
			}
		});
		Botón.setFont(new Font("Arial", Font.BOLD, 13));
		Botón.setBounds(306, 451, 99, 34);
		frame.getContentPane().add(Botón);
		
		JTextPane Texto = new JTextPane();
		Texto.setEditable(false);
		Texto.setBackground(SystemColor.menu);
		Texto.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		Texto.setText("Este programa ayudar\u00E1 a decidir cuales de los centros de distribuci\u00F3n disponibles\r\n le ser\u00E1 m\u00E1s conveniente abrir. Este algoritmo le mostrar\u00E1 los centros que tienen menor costo hacia los clientes, y tambi\u00E9n estad\u00EDsticas sobre los mismos para complementar la informaci\u00F3n y ayudar a tomar la decisi\u00F3n final, seg\u00FAn sus conveniencias.");
		Texto.setBounds(205, 165, 308, 232);
		frame.getContentPane().add(Texto);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
