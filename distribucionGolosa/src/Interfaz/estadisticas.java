package Interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Logica.algoritmoGoloso;
import Logica.centroDistribucion;
import Logica.instancia;
import javax.swing.JList;
import java.awt.SystemColor;

public class estadisticas {

	//VARIABLES
	private JFrame frame;

	//CONSTRUYE LA VENTANA QUE MUESTRA ESTAD�STICAS
	public estadisticas() {
		initialize();
	}

	//INICIALIZA LOS CONTENIDOS DEL FRAME
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(650, 200, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel T�tulo = new JLabel("Estad\u00EDsticas");
		T�tulo.setHorizontalAlignment(SwingConstants.CENTER);
		T�tulo.setFont(new Font("Arial Black", Font.BOLD, 24));
		T�tulo.setBounds(179, 59, 306, 53);
		frame.getContentPane().add(T�tulo);
		
		JLabel Subt�tulo1 = new JLabel("Promedio de la distancia de los clientes a cada uno de los centros");
		Subt�tulo1.setHorizontalAlignment(SwingConstants.CENTER);
		Subt�tulo1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		Subt�tulo1.setBounds(126, 159, 437, 45);
		frame.getContentPane().add(Subt�tulo1);
		
		JList<centroDistribucion> Lista = new JList<>();
		Lista.setBackground(SystemColor.text);
		Lista.setFont(new Font("Arial", Font.PLAIN, 14));
		Lista.setBounds(126, 251, 437, 132);
		frame.getContentPane().add(Lista);
		Lista.setFixedCellWidth(300);
		
		JLabel Subt�tulo2 = new JLabel("Promedio total de la distancia de los clientes a todos los centros");
		Subt�tulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Subt�tulo2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		Subt�tulo2.setBounds(126, 415, 437, 53);
		frame.getContentPane().add(Subt�tulo2);
		
		instancia i = new instancia();
		algoritmoGoloso alg = new algoritmoGoloso(i);
		JLabel PromedioTotal = new JLabel(String.valueOf(alg.promedioDistanciaTodosLosCentros()));
		PromedioTotal.setBackground(SystemColor.menu);
		PromedioTotal.setHorizontalAlignment(SwingConstants.CENTER);
		PromedioTotal.setFont(new Font("Arial", Font.PLAIN, 14));
		PromedioTotal.setBounds(173, 466, 363, 51);
		frame.getContentPane().add(PromedioTotal);
	}

	//GETTER
	public JFrame getFrame() {return frame;}
}
