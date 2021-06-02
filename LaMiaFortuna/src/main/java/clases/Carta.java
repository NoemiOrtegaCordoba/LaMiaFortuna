package clases;

import enumeradores.Palo;

public class Carta {

	private int numero; // va del 1 al 10; 8, 9 y 10 corresponden a Sota, Caballo y Rey
	private Palo palo;
	
	public Carta(int numero, Palo palo) {
		super();
		this.numero = numero;
		this.palo = palo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	@Override
	public String toString() {
		return numero + " de " + palo + "s";
	}
	
}
