package clases;

import java.util.ArrayList;
import java.util.Random;

public class Ruleta extends Juego {
	
	private byte ultimoNumero;
	private ArrayList<Jugador> jugadoresRuleta; 
	
	public Ruleta(String nombre) {
		
		super(nombre);
		
		// TODO Auto-generated constructor stub
		
		this.jugadoresRuleta = new ArrayList<Jugador>();
		
	}
	
	public void rellenarJugadores() {
		// el primer jugador será el usuario		
		jugadoresRuleta.add(Partida.jugador1);
		
		Random random = new Random();
		int limite = random.nextInt(10) + 1;
		
		// ...el resto se generan al azar:
		for (int i = 1; i < limite; i++) {
			// public Jugador(String nombre, double dinero, ArrayList<CosaComprable> cosasCompradas) {
			ArrayList<CosaComprable> cosasCompradas = new ArrayList<CosaComprable>(); 
			
			Jugador jugador = new Jugador("jugador " + i + 1, 100, cosasCompradas);
			
			// el número de fichas que tiene al azar:
			int numeroFichas = random.nextInt(50) + 1;
			jugador.setFichasQueTienes( numeroFichas );
						
			jugadoresRuleta.add( jugador );
		}
		
	}

	public void darVueltasARuleta() {
		
		Random random = new Random();		
		ultimoNumero = (byte) (random.nextInt(36) + 1);
		
	}

	// aquí se hacen todas las apuestas que son automáticas -no del usuario-
	public void apuestanLosJugadores() {
		
		Random random = new Random();
		
		// ...el resto se generan al azar:
		for (int i = 1; i < jugadoresRuleta.size(); i++) {
			
			// número de fichas que apuesta al azar este jugador:
			int numeroFichas = random.nextInt(5) + 1;
			
			// si el número de fichas a sacar en esta partida es superior o igual al que
			// tienes podrás usarlas:
			if (numeroFichas >= jugadoresRuleta.get(i).getFichasQueTienes()) {
				int fichasQueda = jugadoresRuleta.get(i).getFichasQueTienes() - numeroFichas;
				jugadoresRuleta.get(i).setFichasQueTienes(fichasQueda);
			} else {
				// si usas todas las que tienes
				numeroFichas = jugadoresRuleta.get(i).getFichasQueTienes();
				jugadoresRuleta.get(i).setFichasQueTienes(0);
			}
			
			//se ponen al azar las fichas que van a ser jugadas:
			for (int j = 1; j < numeroFichas; j++) {
				
				// si un jugador tiene fichas disponibles, puede usarlas:
				if (numeroFichas > 0) {
					
					// public Ficha(String color, double precio, byte numeroDondeEsta) {
					// generamos al azar el número o grupo de números donde está:
					byte lugarApuesta = (byte) (random.nextInt(43) + 1);
					
					Ficha ficha = new Ficha("negra", Casino.precioFicha, lugarApuesta);
					
					// el jugador pone algunas de sus fichas en la ruleta
					jugadoresRuleta.get(i).getFichasRuleta().add(ficha);
					// y por lo tanto tiene una ficha menos en sus cosascompradas
					jugadoresRuleta.get(i).usarFichaCasino();
				}	
				
			}
			
		}		
		
	}
	
	// esto genera un texto que servirá para saber qué ha ocurrido durante el juego en cada turno
	public String cobranLosJugadoresOCasino() {

		String mensaje = "";
		
		for (int i = 0; i < jugadoresRuleta.size(); i++) {
			
			Jugador jugador = jugadoresRuleta.get(i);
			
			// se van sacando sus fichas para ver dónde las colocaron:
			for (Ficha ficha : jugador.getFichasRuleta()) {

				byte lugarApostado = ficha.getNumeroDondeEsta(); 
				
				// si se ha acertado el número exacto
				if (lugarApostado <= 36 && this.ultimoNumero == ficha.getNumeroDondeEsta()) {

					// si se ha apostado por este grupo el jugador gana el doble:
					double dinero = (jugador.getDineroGanadoUltimoGiro()) + (double) (Casino.precioFicha * 2);
					jugador.setDineroGanadoMano(dinero);
					
					// el casino pierde dinero:
					double dineroCasino = Partida.casino.getDinero() - (Casino.precioFicha * 1);
					Partida.casino.setDinero(dineroCasino);
					
					// si se ha apostado por más o igual a 36 -grupos-
				} else if (lugarApostado >= 36) {
					
					// si se apostó por el primer grupo de números
					if (this.ultimoNumero >= 1 && this.ultimoNumero <= 12) {
					
						// si se ha apostado por este grupo el jugador gana la mitad de lo apostado:
						if (lugarApostado == 37) {
							
							double dinero = (jugador.getDineroGanadoUltimoGiro()) + (double) (Casino.precioFicha * 0.5);
							jugador.setDineroGanadoMano(dinero);
							
							double dineroCasino = Partida.casino.getDinero() + (Casino.precioFicha * 0.5);
							Partida.casino.setDinero(dineroCasino);							
							
							// por estos ganaría lo apostado
							// si se ha apostado por el grupo de dos filas del primer grupo:
						} else if (lugarApostado == 40) {
							
							double dinero = (jugador.getDineroGanadoUltimoGiro()) + (double) (Casino.precioFicha * 1);
							jugador.setDineroGanadoMano(dinero);
							
							// si se ha apostado por el grupo de ultimas filas del primer grupo:
						} else if (lugarApostado == 41) {
							
							double dinero = (jugador.getDineroGanadoUltimoGiro()) + (double) (Casino.precioFicha * 1);
							jugador.setDineroGanadoMano(dinero);
							
						} else {
							
							double dineroCasino = Partida.casino.getDinero() + (Casino.precioFicha * 1);
							Partida.casino.setDinero(dineroCasino);
							
						}
						
					} else if (this.ultimoNumero >= 13 && this.ultimoNumero <= 24) {
						
						// si se ha apostado por este grupo el jugador gana lo apostado:
						if (lugarApostado == 38) {
							
							double dinero = (jugador.getDineroGanadoUltimoGiro()) + (double) (Casino.precioFicha * 0.5);
							jugador.setDineroGanadoMano(dinero);

							// casino gana la mitad
							double dineroCasino = Partida.casino.getDinero() + (Casino.precioFicha * 0.5);
							Partida.casino.setDinero(dineroCasino);							
							
						} else if (lugarApostado == 42) {
							
							double dinero = (jugador.getDineroGanadoUltimoGiro()) + (double) (Casino.precioFicha * 1);
							jugador.setDineroGanadoMano(dinero);							
							
						} else if (lugarApostado == 43) {
							
							double dinero = (jugador.getDineroGanadoUltimoGiro()) + (double) (Casino.precioFicha * 1);
							jugador.setDineroGanadoMano(dinero);							
							
						} else {

							double dineroCasino = Partida.casino.getDinero() + (Casino.precioFicha);
							Partida.casino.setDinero(dineroCasino);
							
						}
						
					} else if (this.ultimoNumero >= 25 && this.ultimoNumero <= 36) {
						
						// si se ha apostado por este grupo el jugador gana lo apostado:
						if (lugarApostado == 39) {
							
							double dinero = (jugador.getDineroGanadoUltimoGiro()) + (double) (Casino.precioFicha * 0.5);
							jugador.setDineroGanadoMano(dinero);
							
							// casino gana la mitad
							double dineroCasino = Partida.casino.getDinero() + (Casino.precioFicha * 0.5);
							Partida.casino.setDinero(dineroCasino);
							
						} else if (lugarApostado == 44) {
							
							double dinero = (jugador.getDineroGanadoUltimoGiro()) + (double) (Casino.precioFicha * 1);
							jugador.setDineroGanadoMano(dinero);							
							
						} else if (lugarApostado == 45) {
							
							double dinero = (jugador.getDineroGanadoUltimoGiro()) + (double) (Casino.precioFicha * 1);
							jugador.setDineroGanadoMano(dinero);							
							
						} else {
							// gana casino
							double dineroCasino = Partida.casino.getDinero() + (Casino.precioFicha);
							Partida.casino.setDinero(dineroCasino);
						}
						
					} else {
						
						// gana casino
						double dineroCasino = Partida.casino.getDinero() + (Casino.precioFicha);
						Partida.casino.setDinero(dineroCasino);
						
					}
					
					
				}
				
				// aquí decimos cuánto ha ganado:
				mensaje = mensaje + jugador.getNombre() + " ha ganado " + jugador.getDineroGanadoUltimoGiro();
			}
			
			// ya has jugado esas fichas y ya no las tienes:
			jugador.getFichasRuleta().clear();
			
		}
		
		return mensaje;
		
	}
	
	public byte getUltimoNumero() {
		return ultimoNumero;
	}

	public void setUltimoNumero(byte ultimoNumero) {
		this.ultimoNumero = ultimoNumero;
	}

	public ArrayList<Jugador> getJugadoresRuleta() {
		return jugadoresRuleta;
	}

	public void setJugadoresRuleta(ArrayList<Jugador> jugadoresRuleta) {
		this.jugadoresRuleta = jugadoresRuleta;
	}
	
}