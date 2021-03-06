/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author noemi
 */
public class Casino {

    private double dinero;
    private ArrayList<CosaComprable> stock;
    
    public static final double precioCarton = 1; // en euros
    public static final double precioFicha = 0.50; // en euros
    public static final double precioTicket7 = 0.50; // en euros
    public static final double precioCartonLoteria = 0.75; // en euros

    public Casino() {
        this.dinero = 10000;
        this.stock = new ArrayList<CosaComprable>();
    }    
    
    public Casino(double dinero, ArrayList<CosaComprable> cosasComprables) {
        this.dinero = dinero;
        this.stock = cosasComprables;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public ArrayList<CosaComprable> getCosasComprables() {
        return stock;
    }

    public void setCosasComprables(ArrayList<CosaComprable> cosasComprables) {
        this.stock = cosasComprables;
    }

    @Override
    public String toString() {
        return "Casino{" + "dinero=" + dinero + ", cosasComprables=" + stock + '}';
    }

}
