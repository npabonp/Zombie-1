package primernzombie;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author NataliaPabon
 */
public final class Nivel1 extends JPanel implements ActionListener, KeyListener {

    private static Nivel1 instance1 = null;

    private int m; // meteoritos
    private int k;
    private Zombie roberto = new Zombie(100, 350);
    private Timer timer;
    private int delay = 20;
    private Color color;
    private int secuencia;
    private Image zombieimg;
    private Image fondo;
    private Image MEteoros;
    private Image gameOver;

    private ArrayList<Meteoritos> bordeMeteoritos;
    private ArrayList<Meteoritos> colision = new ArrayList<>();

    private Nivel1() {
        this.addKeyListener(this);
        setFocusable(true);
        zombieimg = loadImage("ZRunn.png");
        fondo = loadImage("fondo1.jpg");
        MEteoros = loadImage("meteorito.png");
        gameOver = loadImage("images.png");
        timer = new Timer(delay, this);
        timer.start();
        this.bordeMeteoritos = new ArrayList<>();
        Meteoross();
    }

    public static Nivel1 getInstance1() {
        if (instance1 == null) {
            instance1 = new Nivel1();
        }
        return instance1;
    }

    public void Meteoross() {
        int iniX = 100;
        int iniY = 20;
        Random k = new Random();
        for (int i = 0; i < 50; i++) {
            iniX = 100 + Math.abs(k.nextInt() % (900));
            iniY = -(Math.abs(k.nextInt() % 5000));
            this.bordeMeteoritos.add(new Meteoritos(iniX, iniY));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (roberto.getColisiones() < 10) {
            if (roberto.getColisiones() < 10) {
                for (int i = 0; i < k; i++) {
                    g.drawImage(fondo, -k + (i * 800), 0, 800, 500, this);
                }
            }
             if (bordeMeteoritos.isEmpty()) {
                System.out.println("HAZ GANADOO");
            }
            g.drawImage(zombieimg, roberto.getX1(), 350, roberto.getX2(), 464,
                    (this.secuencia * 322), 0, (this.secuencia * 322) + 322, 388, this);
            g.drawString("Colisiones", 600, 30);
            g.drawString(": " + roberto.getColisiones(), 670, 30);
            int xr = 0;
            int yr = 0;
            for (int i = 0; i < bordeMeteoritos.size(); i++) {
                Random l = new Random();
                int in = Math.abs(l.nextInt() % 6000);
                xr = this.bordeMeteoritos.get(i).getX();
                yr = this.bordeMeteoritos.get(i).getY();

               if (this.bordeMeteoritos.get(i).getY() > 500) {

                  bordeMeteoritos.remove(i);
                    continue;
                }
                g.drawImage(MEteoros, xr, yr, 60, 100, this);

                this.bordeMeteoritos.get(i).setY(this.bordeMeteoritos.get(i).getY() + 1);
                this.bordeMeteoritos.get(i).setX(this.bordeMeteoritos.get(i).getX() - 1);
                if (this.bordeMeteoritos.get(i).Colision(roberto)) {
                                       roberto.setColisiones(roberto.getColisiones() + 1);
                    bordeMeteoritos.remove(i);
                }
            }
        } else {
            g.drawImage(gameOver, 0, 0, 800, 500, null);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        k += 3;
        repaint();
    }

    public Image loadImage(String imageName) {
        ImageIcon im = new ImageIcon(imageName);
        Image image = im.getImage();
        return image;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_RIGHT && roberto.getX() + 10 < 700) {
            roberto.setDireccion(true);
            roberto.setX(roberto.getX() + 10);
            if (this.secuencia == 9) {
                this.secuencia = 0;
            } else {
                this.secuencia++;
            }

        }
        if (key == KeyEvent.VK_LEFT && roberto.getX() - 10 > 0) {
            roberto.setDireccion(false);
            roberto.setX(roberto.getX() - 10);
            if (this.secuencia == 0) {
                this.secuencia = 9;
            } else {
                this.secuencia--;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
}
