/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author noemi
 */
public class Ficha extends CosaComprable {

    private String color;
    private byte numeroDondeEsta; // esto va del 1 al 36 + 7 
    							  // (los últimos 7 es votar por grupos de números)

    public Ficha(String color, double precio, byte numeroDondeEsta) {
        super(precio);
        this.color = color;
        this.numeroDondeEsta = numeroDondeEsta;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ficha{" + "color=" + color + '}';
    }

	public byte getNumeroDondeEsta() {
		return numeroDondeEsta;
	}

	public void setNumeroDondeEsta(byte numeroDondeEsta) {
		this.numeroDondeEsta = numeroDondeEsta;
	}
    
}
