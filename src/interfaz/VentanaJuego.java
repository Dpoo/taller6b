package interfaz;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javax.swing.*;

//import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller6.modelo.*;

public class VentanaJuego extends JFrame {

	private VentanaTop ventanaTop;
	private PanelOpciones panelOpciones;
	private PanelMarcador panelMarcador;
	private PanelTablero panelTablero;
	private PanelBotones panelBotones;
	private Top10ventana to10ventana;
	private Tablero tablero;
	private Top10 top;
	private int tamanio = 5;
	private int dificultad = 2;
	private int puntaje;

	public VentanaJuego() {
		tablero = new Tablero(5);
		top = new Top10();
		top.cargarRecords(new File("data/top10.csv"));
		setTitle("LightsOut");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("./data/gatoON.png").getImage());

		ventanaTop = new VentanaTop(this);
		panelOpciones = new PanelOpciones(this);
		panelMarcador = new PanelMarcador(this);
		panelTablero = new PanelTablero(this);
		panelBotones = new PanelBotones(this);

		setLayout(new BorderLayout());

		this.add(panelOpciones, BorderLayout.NORTH);
		this.add(panelMarcador, BorderLayout.WEST);
		this.add(panelTablero, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);

		int panelX = (getWidth() - panelTablero.getWidth() - getInsets().left - getInsets().right) / 2;
		int panelY = ((getHeight() - panelTablero.getHeight() - getInsets().top - getInsets().bottom) / 2);

		panelTablero.setLocation(panelX, panelY);
		nuevoJuego();
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try {
					top.salvarRecords(new File("data/top10.csv"));
				} catch (FileNotFoundException | UnsupportedEncodingException fileNotFoundException) {
					fileNotFoundException.printStackTrace();
				}
			}
		});
		setVisible(true);
	}

	public void Jugar(int i, int j) {
		tablero.jugar(i, j);
		panelTablero.actulizarPanel(tablero);
		int conteo = tablero.darJugadas();
		panelMarcador.setJugadas(conteo);
		int puntaje = tablero.calcularPuntaje();

		if (tablero.tableroIluminado()) {
			comprobarTop(puntaje);
		}
	}

	public void comprobarTop(int punt) {

		if (top.esTop10(punt)) {
			ventanaTop.setVisible(true);
			this.puntaje = punt; 
		} else {
			JOptionPane.showMessageDialog(this, "El puntaje no alcanza el top 10.");
		}

	}

	public void establecerDificultad(int i) {
		this.dificultad = i;
	}

	public void establecerTamanio(int i) {
		this.tamanio = i;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public static void main(String[] args) {
//		FlatLightLaf.install();
		new VentanaJuego();
	}

	public void nuevoJuego() {
		tablero = new Tablero(tamanio);
		tablero.desordenar(dificultad);
		panelTablero.nuevoPanel(tablero);
		panelMarcador.setJugadas(0);
	}

	public void reiniciarJuego() {
		tablero.reiniciar();
		panelTablero.actulizarPanel(tablero);
		panelMarcador.setJugadas(0);
	}
	
	public void agregarTop(String nombre) throws FileNotFoundException, UnsupportedEncodingException {
		int punt = this.puntaje;
		top.agregarRegistro(nombre, punt);
		ventanaTop.setVisible(false);
	}

	public void top10() {
		Top10ventana top10ventana = new Top10ventana(this, top);
	}

}
