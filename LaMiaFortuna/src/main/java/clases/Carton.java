/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Random;

/**
 *
 * @author noemi
 */
public class Carton extends CosaComprable {

    private byte[][] casillas;

    public Carton(double precio) {
        super(precio);
        //this.casillas = casillas;
        rellenarCasillasAlAzar();
    }

    public byte[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(byte[][] casillas) {
        this.casillas = casillas;
    }

    @Override
    public String toString() {
        return "Carton{" + "casillas=" + casillas + '}';
    }

    public void rellenarCasillasAlAzar() {
        byte[][] casillas = new byte[3][5];

        Random r = new Random();

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
            	// se van a rellenar con números al azar del 1 al 95
                casillas[i][j] = (byte) (r.nextInt(90) + 1);
            }
        }
        this.casillas = casillas;
    }
}
