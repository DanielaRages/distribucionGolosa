package Main;

import java.awt.EventQueue;
import Interfaz.ventanaDeInicio;

public class mainPrograma {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaDeInicio window = new ventanaDeInicio();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
