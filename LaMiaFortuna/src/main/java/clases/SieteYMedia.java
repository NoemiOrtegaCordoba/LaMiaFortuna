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
	// (se recuerda que el primero será siempre la banca, gracias al constructor; y el segundo el jugador usuario)	
	public String jugarManoTodosJugadoresActivos() {

		// información sobre lo que ha ocurrido en esta mano, para mostrárselo al jugador:
		String infoMano = "";
		
		Random random = new Random();
		
		// aquí se hace que todos los jugadores hagan 3 cosas (decidir si juegan, apostar, y sacar cartas)

		for (Jugador jugador : jugadores) {
			 
			System.out.println("pasa por 1");
			
			// se decide qué hace cada jugador en caso de no ser el jugador principal o usuario:
			if (jugador.equals(Partida.jugador1) == false) {
			
				System.out.println("pasa por 2");
				
				AccionCartas accionCartas = null;
				
				// 1 - se sortea qué hace el jugador
				// el jugador coge tantas cartas como quiera
				int numerocartas = 0;
				do {

					byte queHace = (byte) (random.nextInt(2) + 1);
					
					// por sentido común, nadie deja de jugar si tiene 4 puntos sólo:
					jugador.calcularPuntos7YMedia();
					if (jugador.getPuntosMano() < 5) {
						queHace = 1;
					}
					
					switch (queHace) {
						case 1:
							System.out.println("pasa por 3");
							accionCartas = AccionCartas.JUEGA;
							break;
							
						case 2:							
							System.out.println("pasa por 4");
							accionCartas = AccionCartas.ABANDONA;
							jugador.setAbandonaMano(true);
							break;
					}
					
					
					System.out.println("pasa por 4");
					// 2 - se apuesta algo: si un jugador juega una mano, entonces tiene que apostar algo:
					if (jugador.isAbandonaMano() == false && jugador.getUltimaApuesta() == 0) {
						// todo jugador tiene cierta inteligencia: apuesta algo al principio
						byte cuantoApuesta = (byte) (random.nextInt(15) + 1); // 15€ como mucho
						jugador.setUltimaApuesta(cuantoApuesta);
						System.out.println("pasa por 5");
					}

					// 3 - y si sigue jugando, saca una carta más
					// y ahora qué carta recibe, en caso de jugar esta mano
					// además, el jugador usuario ya tiene sus cartas establecidas, por lo 
					if (jugador.isAbandonaMano() == false && jugador.equals(Partida.jugador1) == false) {
						
						System.out.println("pasa por 6");
						jugador.getCartas7YMedia().add( sacarCartaAzar() );
						numerocartas++;
						
					}					
					
				} while (accionCartas != AccionCartas.ABANDONA && numerocartas != 14);
				
				System.out.println("pasa por 7");
				
				
			} 
			
		}
		
		// ahora se decide quién gana y cuánto -recordemos que juegan contra la banca, que es el primer usuario-
		
		// calculamos los puntos de cada uno
		for (int i = 0; i < jugadores.size(); i++) {
			
			jugadores.get(i).calcularPuntos7YMedia();
			
			if (i != 0) {
				infoMano += "Jugador " + i + " tiene estos puntos: " + jugadores.get(i).getPuntosMano() + " \n";
			}
			
			System.out.println("pasa por 20");
		}

		// todos los jugadores juegan contra la banca:
		Jugador banca = jugadores.get(0);
		
		// calculamos los puntos de cada uno
		for (int i = 1; i < jugadores.size(); i++) {
			
			System.out.println("pasa por 21");
			
			// ahora comparamos cada jugador con la banca
			Jugador unjugador = jugadores.get(i);
			
			// si ha sacado más de 7 y media, entonces pierde automáticamente
			if (unjugador.getPuntosMano() > 7.5) {
			
				System.out.println("pasa por 22");
				
				unjugador.setDineroGanadoMano(0);
				unjugador.setDinero( unjugador.getDinero() - unjugador.getUltimaApuesta() );
				Partida.casino.setDinero( Partida.casino.getDinero() + unjugador.getUltimaApuesta());
				
				infoMano += "Jugador " + i + " ha perdido toda su apuesta por tener más de 7.5 en puntos, y lo gana la banca \n";
				
				// si saca 7 y media, entonces gana el doble de lo apostado:
			} else if (unjugador.getPuntosMano() == 7.5) {
				
				System.out.println("pasa por 22");
				
				unjugador.setDineroGanadoMano( unjugador.getUltimaApuesta() * 2 );
				unjugador.setDinero( unjugador.getDinero() + unjugador.getDineroGanadoMano() );
				Partida.casino.setDinero( Partida.casino.getDinero() - (unjugador.getUltimaApuesta() * 2) );
				
				infoMano += "Jugador " + i + " ha sacado 7.5 en puntos, y gana " + unjugador.getDineroGanadoMano() + "€ \n";
				
				// si se saca menos de 7.5, entonces se compite con la banca, 
			} else if (unjugador.getPuntosMano() < 7.5) {
				
				// si se saca más que la banca, se gana lo apostado
				if (unjugador.getPuntosMano() > banca.getPuntosMano()) {
				
					System.out.println("pasa por 23");
					
					unjugador.setDineroGanadoMano( unjugador.getUltimaApuesta() );
					unjugador.setDinero( unjugador.getDinero() + unjugador.getDineroGanadoMano() );
					Partida.casino.setDinero( Partida.casino.getDinero() - (unjugador.getUltimaApuesta()) );
					
					infoMano += "Jugador " + i + " ha sacado mas que la banca y gana " + unjugador.getDineroGanadoMano() + "€ \n";
					
				  // si no, se pierde
				} else {
					
					System.out.println("pasa por 24");
					
					unjugador.setDineroGanadoMano(0);
					unjugador.setDinero( unjugador.getDinero() - unjugador.getUltimaApuesta() );
					Partida.casino.setDinero( Partida.casino.getDinero() + unjugador.getUltimaApuesta());

					infoMano += "Jugador " + i + " ha sacado menos que la banca y lo pierde todo ante ella, que lo gana \n";
				}
				
			}
			
			// el jugador ya pierde sus cartas, tras usarlas
			unjugador.getCartas7YMedia();
			
		}		
		
		infoMano += "\n \n \n";		
		
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
