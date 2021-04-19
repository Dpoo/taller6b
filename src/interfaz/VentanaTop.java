package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaTop extends JDialog implements ActionListener {
	
	private JLabel instrucc;
	private JButton enter;
	private JTextField nombre;
	private VentanaJuego juego ;
	private String ejemplo = "";
	
	public VentanaTop(VentanaJuego juego) {
		this.juego = juego;
		
		setTitle("LightsOut");
		setSize(400, 100);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(false);
		setLayout(new BorderLayout());
		
		instrucc = new JLabel("Ingrese las primeras tres letras de su nombre");
		
		nombre = new JTextField();
		nombre.setSize(120, 20);
		
		enter = new JButton("OK");
		enter.addActionListener(this);
		
		add(instrucc, BorderLayout.NORTH);
		add(nombre, BorderLayout.CENTER);
		add(enter, BorderLayout.EAST);
		
		
	}

	public String getNombre() {
		String tres = ejemplo;
		return tres;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ejemplo = nombre.getText();
		try {
			juego.agregarTop(ejemplo);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
