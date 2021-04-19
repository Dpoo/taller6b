package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelBotones extends JPanel implements ActionListener{

	private VentanaJuego juego;
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop;

	
	public PanelBotones (VentanaJuego vjuego) {
		
		juego=vjuego;
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setActionCommand("NUEVO");
		
		btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("REINICIAR");
		
		btnTop = new JButton("TOP-10");
		btnTop.addActionListener(this);
		btnTop.setActionCommand("TOP");		
		
		FlowLayout fl = new FlowLayout();
		add(btnNuevo);
		add(btnReiniciar);
		add(btnTop);
		
	}

	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		
		if (accion.equals("NUEVO")) {
			juego.nuevoJuego();
		}
		else if (accion.equals("REINICIAR")) {
			juego.reiniciarJuego();	
		}
		else if (accion.equals("TOP")) {
			juego.top10();
		}
	}
}
