package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;

import uniandes.dpoo.taller6.modelo.RegistroTop10;
import uniandes.dpoo.taller6.modelo.Top10;

public class Top10ventana extends JDialog{
	
	private Top10 top10;
	private VentanaJuego juego;
	static JList b;
	
	public Top10ventana(VentanaJuego vjuego,Top10 top10) {
		juego=vjuego;
		
		Collection<RegistroTop10> registros = top10.darRegistros();
		String puntajes[] = new String[11];
		puntajes[0]="# Nombre Puntaje";
		int puesto= 1;
		for(RegistroTop10 r : registros) { 
			puntajes[puesto]= Integer.toString(puesto)+ ". "+ r.toString(); 
			puesto++;
		}
		b = new JList(puntajes);
		b.setSelectedIndex(2);
		
		b.setForeground(Color.DARK_GRAY);
		b.setBackground(Color.MAGENTA);
		b.setSelectionBackground(Color.GRAY);
		b.setSelectionForeground(Color.CYAN);
		JDialog v = new JDialog();
		v.setTitle("Top-10");
		v.setSize(70,240);
		v.setLocation(800,40);
		
		v.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		v.getContentPane().add(b);
		v.setVisible(true);
		
		}
}