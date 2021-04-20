package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import uniandes.dpoo.taller6.modelo.RegistroTop10;
import uniandes.dpoo.taller6.modelo.Top10;

public class Top10ventana extends JDialog {
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	private Top10 top10;
	private VentanaJuego juego;
	static JList b;
	
	public Top10ventana(VentanaJuego vjuego,Top10 top10) {
		juego=vjuego;
		
		Collection<RegistroTop10> registros = top10.darRegistros();
		  Object puntajes[]= new Object[11];
		  Object titulo[]= {new Font("Helvetica", Font.PLAIN, 20), Color.BLACK, null, "# Nombre Puntaje" };
		  puntajes[0] = titulo;
		int puesto= 1;
		for(RegistroTop10 r : registros) { 
			if (puesto == 1){
			String per = Integer.toString(puesto)+ ". "+ r.toString(); 
			Object puntaje[] = {new Font("Tahoma", Font.PLAIN, 17), new Color(51, 0, 255), new MyIconOro(), per };
			puntajes[puesto]= puntaje;
			puesto++;
			}
			else if (puesto == 2) {
			String per = Integer.toString(puesto)+ ". "+ r.toString(); 
			Object puntaje[] = {new Font("Tahoma", Font.PLAIN, 17), new Color(51, 0, 255), new MyIconPlata(), per };
			puntajes[puesto]= puntaje;
			puesto++;
			}
			else if (puesto == 3) {
			String per = Integer.toString(puesto)+ ". "+ r.toString(); 
			Object puntaje[] = {new Font("Tahoma", Font.PLAIN, 17), new Color(51, 0, 255), new MyIconBronce(), per };
			puntajes[puesto]= puntaje;
			puesto++;
			}
			else {
				String per = Integer.toString(puesto)+ ". "+ r.toString(); 
				Object puntaje[] = {new Font("Tahoma", Font.PLAIN, 17), new Color(51, 0, 255),new MyIconNull(), per };
				puntajes[puesto]= puntaje;
				puesto++;
		}
		}
		b = new JList(puntajes);
		ListCellRenderer renderer = new ComplexCellRenderer();
		b.setCellRenderer(renderer);
		b.setSelectedIndex(2);
		JScrollPane scrollPane = new JScrollPane(b);
	    
		b.setForeground(Color.PINK);
		b.setBackground(new Color(204, 255, 255));
		b.setSelectionBackground(Color.PINK);
		JDialog v = new JDialog();
		v.add(scrollPane, BorderLayout.CENTER);
	    v.setSize(300, 200);
	    v.setTitle("Top-10");
		v.setLocation(800,40);
		v.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		v.setVisible(true);
		b.setAlignmentX(Component.CENTER_ALIGNMENT);
		}

	class ComplexCellRenderer implements ListCellRenderer {
		  protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

		  public Component getListCellRendererComponent(JList list, Object value, int index,
		      boolean isSelected, boolean cellHasFocus) {
		    Font theFont = null;
		    Color theForeground = null;
		    Icon theIcon = null;
		    String theText = null;

		    JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
		        isSelected, cellHasFocus);

		    if (value instanceof Object[]) {
		      Object values[] = (Object[]) value;
		      theFont = (Font) values[0];
		      theForeground = (Color) values[1];
		      theIcon = (Icon) values[2];
		      theText = (String) values[3];
		    } else {
		      theFont = list.getFont();
		      theForeground = list.getForeground();
		      theText = "";
		    }
		    if (!isSelected) {
		      renderer.setForeground(theForeground);
		    }
		    if (theIcon != null) {
		      renderer.setIcon(theIcon);
		    }
		    renderer.setText(theText);
		    renderer.setFont(theFont);
		    return renderer;
		  }
		}
	  class MyIconOro implements Icon {

		  public MyIconOro() {
		  }

		  public int getIconHeight() {
		    return 20;
		  }

		  public int getIconWidth() {
		    return 20;
		  }

		  public void paintIcon(Component c, Graphics g, int x, int y) {
		    g.setColor(new Color(255, 204, 0));
		    g.drawOval(0, 0, 15, 15);
		    g.fillOval(0, 0, 15, 15);
		  }
		}
	  class MyIconPlata implements Icon {

		  public MyIconPlata() {
		  }

		  public int getIconHeight() {
		    return 20;
		  }

		  public int getIconWidth() {
		    return 20;
		  }

		  public void paintIcon(Component c, Graphics g, int x, int y) {
		    g.setColor(new Color(153, 153, 153));
		    g.drawOval(0, 0, 15, 15);
		    g.fillOval(0, 0, 15, 15);
		  }
		}
	  class MyIconBronce implements Icon {

		  public MyIconBronce() {
		  }

		  public int getIconHeight() {
		    return 20;
		  }

		  public int getIconWidth() {
		    return 20;
		  }

		  public void paintIcon(Component c, Graphics g, int x, int y) {
		    g.setColor(new Color(204, 102, 0));
		    g.drawOval(0, 0, 15, 15);
		    g.fillOval(0, 0, 15, 15);
		  }
		}
	  class MyIconNull implements Icon {

		  public MyIconNull() {
		  }

		  public int getIconHeight() {
		    return 20;
		  }

		  public int getIconWidth() {
		    return 20;
		  }

		  public void paintIcon(Component c, Graphics g, int x, int y) {
		    g.setColor(new Color(204, 255, 255));
		    g.drawOval(0, 0, 0, 0);
		  }
		}
	}
