package Interfaz;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import Logica.algoritmoGoloso;
import Logica.centroDistribucion;

import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class estadisticas {

	//VARIABLES
	private JFrame frame;
	private JTable table;

	//CONSTRUYE LA VENTANA QUE MUESTRA ESTADÍSTICAS
	public estadisticas(ArrayList<centroDistribucion> centrosDefinitivos, algoritmoGoloso g) {
		initialize(centrosDefinitivos, g);
	}

	//INICIALIZA LOS CONTENIDOS DEL FRAME
	private void initialize(ArrayList<centroDistribucion> centrosDefinitivos, algoritmoGoloso g) {
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
		
		JLabel Subtítulo2 = new JLabel("Promedio total de la distancia de los clientes a todos los centros");
		Subtítulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Subtítulo2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		Subtítulo2.setBounds(138, 358, 437, 53);
		frame.getContentPane().add(Subtítulo2);
		
		JLabel PromedioTotal = new JLabel(String.valueOf(g.promedioDistanciaTodosLosCentros()));
		PromedioTotal.setBackground(SystemColor.menu);
		PromedioTotal.setHorizontalAlignment(SwingConstants.CENTER);
		PromedioTotal.setFont(new Font("Arial", Font.PLAIN, 14));
		PromedioTotal.setBounds(170, 421, 363, 39);
		frame.getContentPane().add(PromedioTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 230, 386, 118);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Centro", "Promedio", "Costo total"
			}
		));
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		//BOTÓN FINALIZAR PROGRAMA
		JButton Salir = new JButton("Finalizar");
		Salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		Salir.setFont(new Font("Arial Black", Font.BOLD, 12));
		Salir.setBounds(309, 498, 91, 21);
		frame.getContentPane().add(Salir);
		
		//
		for (int i = 0; i < centrosDefinitivos.size(); i++) {
            int numCols = table.getModel().getColumnCount();

            Object [] fila = new Object[numCols]; 

            fila[0] = centrosDefinitivos.get(i).getIdentificacion();
            fila[1] = centrosDefinitivos.get(i).getPromedioDistanciaConClientes();
            fila[2] = centrosDefinitivos.get(i).getDistanciaConClientes();
            
            ((DefaultTableModel) table.getModel()).addRow(fila);
        }
	}

	//GETTER
	public JFrame getFrame() {return frame;}
}
