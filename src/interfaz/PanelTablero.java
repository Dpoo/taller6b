package interfaz;

import uniandes.dpoo.taller6.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PanelTablero extends JPanel implements MouseListener {
    private VentanaJuego ventana;
    private int[][] cantidades;
    private int largo;
    private boolean[][] tablero;



    public PanelTablero(VentanaJuego ventana){
        setSize(600,600);
        this.ventana = ventana;
        this.addMouseListener(this);
    }

    public void nuevoPanel(Tablero tableroC){
        this.removeAll();
        this.tablero = tableroC.darTablero();
        this.largo = tablero.length;
        this.cantidades = new int[largo][largo];
        GridLayout gl = new GridLayout(largo,largo);
        setLayout(gl);

        actulizarPanel();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int la = Math.min(this.getWidth()/largo, this.getHeight()/largo);
        int sdisx = (getWidth()-la*largo)/2;
        int disy = (getHeight()-la*largo)/2;
        for (int i = 0; i < largo; i++) {
        	int disx = sdisx;
            for (int ii = 0; ii < largo; ii++) {
                GradientPaint gp;
                if (tablero[i][ii]) {
                    gp = new GradientPaint(disx, disy, Color.CYAN, disx + la, disy + la, Color.WHITE);

                }else{
                    gp = new GradientPaint(disx, disy, Color.GRAY, disx + la, disy + la, Color.BLACK);
                }
                g2d.setPaint(gp);
                g2d.fillRoundRect(disx,disy,la,la,20,20);
                disx += la;
            }
            disy += la;
        }
    }


    public void actulizarPanel(){
        repaint();
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
        int la = Math.min(this.getWidth()/largo, this.getHeight()/largo);
        int fila =  (y-((getHeight()-la*largo)/2)) / (la);
        int columna =(x-((getWidth()-la*largo)/2)) / (la);
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
