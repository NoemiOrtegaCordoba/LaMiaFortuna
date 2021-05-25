package clases;

public class Bingo extends Juego {
	
	private byte ultimaBola;
	
	public Bingo(String nombre, byte ultimaBola) {
		super(nombre);
		 
		this.ultimaBola = ultimaBola;
	}

	public byte getUltimaBola() {
		return ultimaBola;
	}

	public void setUltimaBola(byte ultimaBola) {
		this.ultimaBola = ultimaBola;
	}
	
}
