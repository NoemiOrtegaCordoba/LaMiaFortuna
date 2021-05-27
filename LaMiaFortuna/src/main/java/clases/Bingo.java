package clases;

import java.util.ArrayList;
import java.util.Random;

public class Bingo extends Juego {
	
	private byte bolasSacadasHastaAhora;
	private byte ultimaBola;
	private ArrayList<Carton> cartonesJugadosAhora;
	private boolean bingoCantado;
	private int lineasCantadas;
	
	public Bingo() {
		super("Bingo");
		
		// todavía no se ha sacado ninguna bola
		bolasSacadasHastaAhora = 0;
		// -1 significa que todavía no se ha sacado ninguna bola
		this.ultimaBola = -1;
		
		cartonesJugadosAhora = new ArrayList<Carton>();
		
		bingoCantado = false;
		lineasCantadas = 0;
	}
	
	// se van a jugar a con un cierto número de cartones
	// al bingo, indicado en "numeroCartones", y extraído
	// de "jugador" para pasarlo al arraylist de arriba
	public void jugarConCartones(Jugador jugador, int numeroCartones) {
		
		int conta = 0;
		
		// se ponen sobre la mesa los cartones con los que va a jugar el jugador:
		ArrayList<CosaComprable> cosasJugador = jugador.getCosasCompradas();
		
		for ( CosaComprable cosa : cosasJugador) {
			
			// si una de las cosas es un carton
			if (cosa instanceof Carton) {
				
				if (conta < numeroCartones) {
					conta++;
					
					// almacenamos el carton que vamos a usar
					// (puede haber varios)
					// (aquí también se está usando polimorfismo)
					cartonesJugadosAhora.add( (Carton) cosa);
				}
				
			}
			
		}
		
		// ahora borramos los cartones que hemos sacado
		// de los objetos del jugador:
		
		for ( Carton uncarton : cartonesJugadosAhora) {
			
			// otro uso del polimorfimos, esta vez de una clase
			// hijo a una clase padre, y para borrar de un 
			// arraylist, usando el método "remove":
			
			cosasJugador.remove( (CosaComprable) uncarton);

		}
		
	}
	
	public int getLineasCantadas() {
		return lineasCantadas;
	}

	public void setLineasCantadas(int lineasCantadas) {
		this.lineasCantadas = lineasCantadas;
	}

	public ArrayList<Carton> getCartonesJugadosAhora() {
		return cartonesJugadosAhora;
	}
	
	public void setCartonesJugadosAhora(ArrayList<Carton> cartonesJugadosAhora) {
		this.cartonesJugadosAhora = cartonesJugadosAhora;
	}

	public boolean isBingoCantado() {
		return bingoCantado;
	}

	public void setBingoCantado(boolean bingoCantado) {
		this.bingoCantado = bingoCantado;
	}

	public void sacarBola() {
		
		Random random = new Random();
		
		bolasSacadasHastaAhora++;
		ultimaBola = (byte) (random.nextInt(90) + 1);
		
	}
	
	// Esta función retorna un mensaje que indica al jugador si ha hecho bingo o línea
	public String tacharYComprobarSiLineaOBingo() {
		
		// primero se tachan todos los cartones con el número de la última bola:

		for (Carton uncarton : cartonesJugadosAhora) {
			
			byte[][] numeros = uncarton.getCasillas();
			
			for (int fila = 0; fila < numeros.length; fila++) {
				
				for (int columna = 0; columna < numeros[fila].length; columna++) {
					
					if (numeros[fila][columna] == ultimaBola) {
						
						numeros[fila][columna] = -1; // - 1 significa que ha salido ese número
						
					}
					
				}
				
			}

		}
		
		// ahora se comprueba si hay alguna línea o bingo
		
		int numeroBingos = 0;
		int numeroLineas = 0;
		
		for (Carton uncarton : cartonesJugadosAhora) {

			int cuantosTachados = 0;
			
			byte[][] numeros = uncarton.getCasillas();
			
			for (int fila = 0; fila < numeros.length; fila++) {
			
				int cuantosTachadosEnMismaFila = 0;
				
				for (int columna = 0; columna < numeros[fila].length; columna++) {
					
					// este if sirve para comprobar si hay bingo:
					if (numeros[fila][columna] == -1) {
						
						cuantosTachados++;
						cuantosTachadosEnMismaFila++;
						
					}
					
					// comprobamos si se ha hecho línea
					if (cuantosTachadosEnMismaFila == 5) {
						numeroLineas++;
						
						lineasCantadas++;
					}
					
				}
				
			}

			// si hay 15 números tachados en este carton -ya se han recorrido todos sus números-, es que hay bingo
			if (cuantosTachados == 15) {
				bingoCantado = true;
				
				numeroBingos++;
			}
			
		}		
		
		String mensajeParaElJugador = "Líneas del propio jugador " + numeroLineas + " y Bingos del propio jugador " + numeroBingos + ".";
		
		return mensajeParaElJugador;
	}
	
	public byte getUltimaBola() {
		return ultimaBola;
	}

	public void setUltimaBola(byte ultimaBola) {
		this.ultimaBola = ultimaBola;
	}

	public byte getBolasSacadasHastaAhora() {
		return bolasSacadasHastaAhora;
	}

	public void setBolasSacadasHastaAhora(byte bolasSacadasHastaAhora) {
		this.bolasSacadasHastaAhora = bolasSacadasHastaAhora;
	}
	
}

