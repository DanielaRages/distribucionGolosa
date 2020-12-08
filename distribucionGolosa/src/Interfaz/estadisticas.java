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

	//CONSTRUYE LA VENTANA QUE MUESTRA ESTADÍSTICAS
	public estadisticas() {
		initialize();
	}

	//INICIALIZA LOS CONTENIDOS DEL FRAME
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(650, 200, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Título = new JLabel("Estad\u00EDsticas");
		Título.setHorizontalAlignment(SwingConstants.CENTER);
		Título.setFont(new Font("Arial Black", Font.BOLD, 24));
		Título.setBounds(179, 59, 306, 53);
		frame.getContentPane().add(Título);
		
		JLabel Subtítulo1 = new JLabel("Promedio de la distancia de los clientes a cada uno de los centros");
		Subtítulo1.setHorizontalAlignment(SwingConstants.CENTER);
		Subtítulo1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		Subtítulo1.setBounds(126, 159, 437, 45);
		frame.getContentPane().add(Subtítulo1);
		
		JList<centroDistribucion> Lista = new JList<>();
		Lista.setBackground(SystemColor.text);
		Lista.setFont(new Font("Arial", Font.PLAIN, 14));
		Lista.setBounds(126, 251, 437, 132);
		frame.getContentPane().add(Lista);
		Lista.setFixedCellWidth(300);
		
		JLabel Subtítulo2 = new JLabel("Promedio total de la distancia de los clientes a todos los centros");
		Subtítulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Subtítulo2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		Subtítulo2.setBounds(126, 415, 437, 53);
		frame.getContentPane().add(Subtítulo2);
		
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
