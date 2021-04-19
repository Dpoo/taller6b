package interfaz;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelMarcador extends JPanel{
	
	private JLabel jugadas;
	private VentanaJuego juego;
	private int conteo;

	public PanelMarcador(VentanaJuego vjuego) {
		setSize(100,100);
		juego=vjuego;
		jugadas = new JLabel("0");
		jugadas.setFont(new Font("arial", Font.BOLD, 40));

		setLayout (new BorderLayout());
		add(new JLabel("        "));
		add(jugadas,BorderLayout.CENTER);

	}

	public void setJugadas(int conteo) {
		jugadas.setText(String.valueOf(conteo));
	}

	
}
