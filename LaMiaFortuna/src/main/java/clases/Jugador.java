/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

import enumeradores.AccionCartas;

/**
 *
 * @author noemi
 */
public class Jugador {

    private String nombre;
    private double dinero;
    // este es un uso del polimorfismo, de los dos pedidos:
    // CosaComprable al ser clase padre, será usada
    // para que en este ArrayList se puedan almacenar
    // tanto Cartones, como Ficha, etc.
    
    private ArrayList<CosaComprable> cosasCompradas;
    
    // variables para las 7 y media:
    private ArrayList<Carta> cartas7YMedia;
    private double ultimaApuesta;
    private AccionCartas accionCartas;
    private double puntosMano;

    public Jugador(String nombre, double dinero, ArrayList<CosaComprable> cosasCompradas) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.cosasCompradas = cosasCompradas;
        
        cartas7YMedia = new ArrayList<Carta>();
        ultimaApuesta = 0;
        accionCartas = AccionCartas.JUEGA;
        puntosMano = 0;
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
    	dinero = dinero + cantidad;
    }

    public void ganarPremio(int cantidad) {

    }

    public void comprarCosa(CosaComprable cosaComprable) {
    	cosasCompradas.add(cosaComprable);
    }
    
    public boolean tieneAlgunCarton() {
    	
    	boolean tieneCarton = false;
    	
		for ( CosaComprable cosa : this.getCosasCompradas()) {
			
			// si una de las cosas es un carton
			if (cosa instanceof CartonBingo) {
				
				tieneCarton = true; 
					
			}
			
		}
		
		return tieneCarton;
    	
    }
    
    public boolean tieneAlgunCartonLoteria() {
    	
    	boolean tieneCartonDeLoteria = false;
    	
		for ( CosaComprable cosa : this.getCosasCompradas()) {
			
			// si una de las cosas es un carton de lotería
			if (cosa instanceof CartonLoteria) {
				
				tieneCartonDeLoteria = true; 
					
			}
			
		}
		
		return tieneCartonDeLoteria;
    	
    }
    

    public void usarCartonDeLoteria() {
        
    	CosaComprable eliminarEste = null;
    	
        for ( CosaComprable cosa : this.getCosasCompradas()) {

        	// aquí se usa algo del polimorfimo:
			if (cosa instanceof CartonLoteria) {
				
				eliminarEste = cosa; 
					
			}
			
		}
        
        if (eliminarEste != null) {
        	
        	this.getCosasCompradas().remove(eliminarEste);
        	
        }
    	
    }

	public ArrayList<Carta> getCartas7YMedia() {
		return cartas7YMedia;
	}

	public void setCartas7YMedia(ArrayList<Carta> cartas7yMedia) {
		cartas7YMedia = cartas7yMedia;
	}

	public double getUltimaApuesta() {
		return ultimaApuesta;
	}

	public void setUltimaApuesta(double ultimaApuesta) {
		this.ultimaApuesta = ultimaApuesta;
	}

	public AccionCartas getAccionCartas() {
		return accionCartas;
	}

	public void setAccionCartas(AccionCartas accionCartas) {
		this.accionCartas = accionCartas;
	}
	
	public void calcularPuntosMano() {
		
		puntosMano = 0;
		
		// sota caballo y rey (8, 9 y 10) valen 0.5 puntos, el resto 1
		for (Carta unaCarta : cartas7YMedia) {

			if (unaCarta.getNumero() < 8) {
				puntosMano += 1;
			} else {
				puntosMano += 0.5;
			}
			
		}
		
	}

	public double getPuntosMano() {
		return puntosMano;
	}

	public void setPuntosMano(double puntosMano) {
		this.puntosMano = puntosMano;
	}
	
}
