package clases;

import java.util.ArrayList;
import java.util.Random;

import enumeradores.AccionCartas;
import enumeradores.Palo;

public class SieteYMedia extends Juego {

	private int jugadorActual;
	
	private ArrayList<Jugador> jugadores;
	private Jugador banca;
	
	public SieteYMedia() {
		super("Siete y media");
		
		// TODO Auto-generated constructor stub
		jugadores = new ArrayList<Jugador>();
		
		// el primero va a ser siempre la banca
		ArrayList<CosaComprable> cosasCompradas = new ArrayList<CosaComprable>();
		
		banca = new Jugador("banca", 0, cosasCompradas);
		jugadores.add(banca);
		
		jugadorActual = 0;
	}
	
	public void rellenarJugadores(Jugador jugadorUsuario) {
		
		// el jugador segundo del arraylist será siempre el jugadorusuario, así como el primero siempre será la banca:
		jugadores.add(jugadorUsuario);
		
		// se rellenan los jugadores que no sean la banca ni el jugador usuario:
		// cada partida de 7 y media tendrá 5 jugadores: banca, usuario y 3 automatizados
		for (int i = 3; i < 6; i++) {
			ArrayList<CosaComprable> cosasCompradas = new ArrayList<CosaComprable>();
			Jugador banca = new Jugador("jugador cartas " + i, 0, cosasCompradas);
			jugadores.add(banca);
		}
				
	}
	
	// en esta función gestionamos el comportamiento de los jugadores activos incluyendo al jugador
	public String jugarManoTodosJugadoresActivos(double apuestaUsuario, AccionCartas accionUsuario) {
		
		Random random = new Random();
		
		// se da una carta por azar a todos los jugadores:
		// (se recuerda que el primero será siempre la banca, gracias al constructor; y el segundo el jugador usuario)
		for (Jugador jugador : jugadores) {
			 
			// se decide qué hace cada jugador:
			// se decide cuánto apuesta cada uno, en caso de no ser el jugador principal o usuario:
			if (jugador.equals(Partida.jugador1) == false) {
				
				byte queHace = (byte) (random.nextInt(2) + 1);
				AccionCartas accionCartas = null;
				
				// el jugador coge tantas cargas como quiera
				int numerocartas = 0;
				do {
				
					switch (queHace) {
						case 1:
							accionCartas = AccionCartas.JUEGA;
							break;
							
						case 2:
							accionCartas = AccionCartas.ABANDONA;
							break;
					}
					
					jugador.setAccionCartas(accionCartas);
					
					// si un jugador juega una mano, entonces tiene que apostar algo:
					if (accionCartas == AccionCartas.JUEGA && jugador.getUltimaApuesta() == 0) {
						// todo jugador tiene cierta inteligencia: apuesta algo al principio
						byte cuantoApuesta = (byte) (random.nextInt(15) + 1); // 15€ como mucho
						jugador.setUltimaApuesta(cuantoApuesta);	
					}

					// y ahora qué carta recibe, en caso de jugar esta mano
					// además, el jugador usuario ya tiene sus cartas establecidas, por lo 
					if (jugador.getAccionCartas() == AccionCartas.JUEGA && jugador.equals(Partida.jugador1) == false) {
						
						jugador.getCartas7YMedia().add( sacarCartaAzar() );
						numerocartas++;
						
					}					
					
				} while (accionCartas != AccionCartas.ABANDONA && numerocartas != 14);
				
			} 
			
			/*
			else {

			}
			*/
			

			
		}
		
		// información sobre lo que ha ocurrido en esta mano, para mostrárselo al jugador:
		String infoMano = "";
		
		// ahora se decide quién gana y cuánto -recordemos que juegan contra la banca, que es el primer usuario-
		
		for (int i = 0; i < jugadores.size(); i++) {
		
			
			
		}
		
		return infoMano;
	}
	
	public Carta sacarCartaAzar() {
		Random random = new Random();
		
		byte numeroCarta = (byte) (random.nextInt(10) + 1);
		byte nuevoNumeroPalo = (byte) (random.nextInt(4) + 1);  

		Palo nuevoPalo = null;
		
		switch (nuevoNumeroPalo) {
			case 1:
				nuevoPalo = Palo.BASTO;
				break;
			
			case 2:
				nuevoPalo = Palo.COPA;
				break;
				
			case 3:
				nuevoPalo = Palo.ORO;
				break;
				
			case 4:
				nuevoPalo = Palo.ESPADA;
				break;
		}
		
		Carta cartaNueva = new Carta(numeroCarta, nuevoPalo);
		
		return cartaNueva;
	}
	
}
