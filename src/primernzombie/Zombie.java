/*
 

 */
package primernzombie;

/**
 *
 * @author NataliaPabon
 */
public class Zombie {

    private boolean direccion;
    private int colisiones = 0;
    private int x;
    private int y;
    private int ancho = 108;
    private int alto = 90;

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
        direccion = true;
    }

    public int getColisiones() {
        return colisiones;
    }

    public void setColisiones(int colisiones) {
        this.colisiones = colisiones;
    }

    public int getX() {
        return x;
    }

    public boolean isDireccion() {
        return direccion;
    }

    public void setDireccion(boolean direccion) {
        this.direccion = direccion;
    }

    public int getX1() {
        return direccion ? x : x + ancho;
    }

    public int getX2() {
        return direccion ? x + ancho : x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
}
