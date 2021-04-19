package interfaz;

import uniandes.dpoo.taller6.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;


public class PanelTablero extends JPanel implements MouseListener {
    private Rectangle[][] Rectangulos;
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
    }

    public void nuevoPanel(Tablero tablero){
        this.removeAll();
        ;
        boolean[][] tableroB = tablero.darTablero();
        int largo = tableroB.length;
        this.cantidades = new int[largo][largo];
        this.Rectangulos =  new Rectangle[largo][largo];
        GridLayout gl = new GridLayout(largo,largo);
        setLayout(gl);
        actulizarPanel(tablero);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int disx = this.getX();
        int disy = this.getY();
        int lx;
        int ly;
        if(this.getWidth() ==0){
            ly = 600/largo;
            lx = 600/largo;
        }else{
            lx = this.getWidth()/largo;
            ly = this.getHeight()/largo;
        }
        for (int i = 0; i < largo; i++) {
            for (int ii = 0; ii < largo; ii++) {
                g2d.fillRoundRect(disx,disy,lx,ly,20,20);
                if (tablero[i][ii]) {
                    g2d.setColor(Color.CYAN);
                }else{
                    g2d.setColor(Color.DARK_GRAY);
                }
                disx += lx;
                disy += ly;
            }
        }
    }


    public void actulizarPanel(Tablero tableroC){
        tablero = tableroC.darTablero();
        largo = tablero.length;
        cantidades = new int[largo][largo];
        repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        cantidades[casilla[0]][casilla[1]]++;
        ventana.Jugar(casilla[0], casilla[1]);
        repaint();
    }
    private int[] convertirCoordenadasACasilla(int x, int y)
    {
        int ladoTablero = largo;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
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
