package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;

import uniandes.dpoo.taller6.modelo.RegistroTop10;
import uniandes.dpoo.taller6.modelo.Top10;

public class Top10ventana extends JDialog{
	
	private Top10 top10;
	private VentanaJuego juego;
	
	public Top10ventana(VentanaJuego vjuego,Top10 top10) {
		juego=vjuego;
		JDialog v = new JDialog();
		v.setTitle("Top-10");
		v.setSize(70,240);
		v.setLocation(800,40);
		v.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		v.setVisible(true);
		Collection<RegistroTop10> registros = top10.darRegistros();
		v.getContentPane().setLayout(new BoxLayout(v.getContentPane(),BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel("# Nombre Puntaje"); 
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		titulo.setFont(new Font("arial", Font.BOLD, 16));
		v.getContentPane().add(titulo);
		int puesto= 1;
		for(RegistroTop10 r : registros) { 
			JLabel registro = new JLabel(Integer.toString(puesto)+". "+r.toString()); 
			registro.setAlignmentX(Component.CENTER_ALIGNMENT);
			registro.setFont(new Font("arial", Font.BOLD, 15));
			v.getContentPane().add(registro); 
			puesto++;
		}
	}
}
