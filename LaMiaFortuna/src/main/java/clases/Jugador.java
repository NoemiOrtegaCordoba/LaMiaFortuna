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
public class Jugador {

    private String nombre;
    private double dinero;
    private ArrayList<CosaComprable> cosasCompradas;

    public Jugador(String nombre, double dinero, ArrayList<CosaComprable> cosasCompradas) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.cosasCompradas = cosasCompradas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public ArrayList<CosaComprable> getCosasCompradas() {
        return cosasCompradas;
    }

    public void setCosasCompradas(ArrayList<CosaComprable> cosasCompradas) {
        this.cosasCompradas = cosasCompradas;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", dinero=" + dinero + ", cosasCompradas=" + cosasCompradas + '}';
    }

    public void ganarDinero(int cantidad) {

    }

    public void ganarPremio(int cantidad) {

    }

    public void comprarCosa(CosaComprable cosaComprable) {

    }

}
