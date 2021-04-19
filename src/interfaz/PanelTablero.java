package interfaz;

import uniandes.dpoo.taller6.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;


public class PanelTablero extends JPanel implements MouseListener {
    private VentanaJuego ventana;
    private int[][] cantidades;
    private int largo;
    private boolean[][] tablero;
    ImageIcon GatoOff = new ImageIcon("./data/gatoOff.png");
    ImageIcon GatoON = new ImageIcon("./data/gatoON.png");


    public PanelTablero(VentanaJuego ventana){
        setSize(600,600);
        this.ventana = ventana;

        Tablero tablero = ventana.getTablero();
        nuevoPanel(tablero);
        this.addMouseListener(this);
    }

    public void nuevoPanel(Tablero tablero){
        this.removeAll();
        ;
        boolean[][] tableroB = tablero.darTablero();
        int largo = tableroB.length;
        this.cantidades = new int[largo][largo];
        GridLayout gl = new GridLayout(largo,largo);
        setLayout(gl);
        actulizarPanel(tablero);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int disx = 0;
        int disy = 0;
        int lx = (int) (this.getWidth()/largo);
        int ly = (int) (this.getHeight()/largo);
        System.out.print("\n");
        for (int i = 0; i < largo; i++) {
        	disy = 0;
            for (int ii = 0; ii < largo; ii++) {
            	System.out.print(disx+"-"+disy+"."+ii+"-"+i+"/");
                if (tablero[ii][i]) {
                    g2d.setColor(Color.CYAN);
                }else{
                    g2d.setColor(Color.DARK_GRAY);
                }
                g2d.fillRoundRect(disx,disy,lx,ly,20,20);
                disy += ly;
            }
            disx += lx;
        }
    }


    public void actulizarPanel(Tablero tableroC){
        tablero = tableroC.darTablero();
        largo = tablero.length;
        cantidades = new int[largo][largo];
        repaint();
        System.out.print("dee");
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    	 System.out.print("dd");
    	 int click_x = e.getX();
         int click_y = e.getY();
         int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
         
         cantidades[casilla[0]][casilla[1]]++;
         ventana.Jugar(casilla[0], casilla[1]);
         repaint();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    	
    }
    private int[] convertirCoordenadasACasilla(int x, int y)
    {
        int ladoTablero = largo;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int fila = (int) ((y*ladoTablero) / (altoPanelTablero));
        int columna = (int) ((x*ladoTablero) / (anchoPanelTablero));
        System.out.print(fila);
        System.out.print(columna);

        return new int[] { fila, columna };
    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
