package interfaz;

import uniandes.dpoo.taller6.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class PanelTablero extends JPanel implements ActionListener {
    private JButton[][] botones;
    private VentanaJuego ventana;
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
        boolean[][] tableroB = tablero.darTablero();
        int largo = tableroB.length;
        this.botones =  new JButton[largo][largo];
        GridLayout gl = new GridLayout(largo,largo);
        setLayout(gl);

        for (int i = 0; i < largo; i++) {
            for (int ii = 0; ii < largo; ii++) {
                JButton acB = new JButton();
                acB.addActionListener(this);
                acB.setActionCommand(i + "," + ii);
                add(acB);
                botones[i][ii] = acB;
            }
        }
        actulizarPanel(tablero);
    }

    public void actulizarPanel(Tablero tablero){
        boolean[][] tableroB = tablero.darTablero();
        int largo = tableroB.length;

        for (int i = 0; i < largo; i++) {
            for (int ii = 0; ii < largo; ii++) {
                if (tableroB[i][ii]) {
                    botones[i][ii].setIcon(new ImageIcon(GatoON.getImage().
                            getScaledInstance((int)(ventana.getWidth()*0.8)/largo,(int)(ventana.getHeight()*0.8)/largo,Image.SCALE_DEFAULT)));
                    botones[i][ii].setBackground(new java.awt.Color(255, 239, 108));
                } else {
                    botones[i][ii].setIcon(new ImageIcon(GatoOff.getImage().
                            getScaledInstance((int)(ventana.getWidth()*0.8)/largo,(int)(ventana.getHeight()*0.8)/largo,Image.SCALE_DEFAULT)));
                    botones[i][ii].setBackground(new java.awt.Color(39, 97, 128));
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] grito = e.getActionCommand().split(",");
        int i = Integer.parseInt(grito[0]);
        int j = Integer.parseInt(grito[1]);
        ventana.Jugar(i, j);

    }
}
