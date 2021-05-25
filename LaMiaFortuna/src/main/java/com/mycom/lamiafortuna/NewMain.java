/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycom.lamiafortuna;

import clases.Carton;
import clases.Casino;
import clases.CosaComprable;
import clases.Ficha;
import clases.Jugador;
import clases.Partida;
import windows.WindowHallCasino;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author noemi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    	WindowHallCasino windowPortada = new WindowHallCasino();
    	
    	/*
        Scanner sc = new Scanner(System.in);

        // inicializamos las variables básicas del juego
        ArrayList<CosaComprable> cosasDelJugador = new ArrayList<CosaComprable>();
        Partida.jugador1 = new Jugador("Noemí", 4, cosasDelJugador);

        // añadimos cosas al casino
        ArrayList<CosaComprable> cosasEnCasino = new ArrayList<CosaComprable>();
        for (int i = 0; i < 2; i++) { // el casino tiene ahora 2 cartones de 3 euros cada uno
            Carton carton = new Carton(3);

            cosasEnCasino.add(carton);
        }

        Ficha ficha = new Ficha("azul", 2); // y ahora el casino tendrá una ficha además de los dos cartones de bingo
        cosasEnCasino.add(ficha);

        Partida.casino = new Casino(1000000, cosasEnCasino);

        // el menú principal del juego:
        byte opcion;

        do {
            System.out.println("¿Qué quieres hacer?\n"
                    + "\t0- Ver datos del jugador y del casino.\n"
                    + "\t1- Comprar.\n"
                    + "\t2- Jugar Bingo.\n"
                    + "\t3- Jugar a la Ruleta.\n"
                    + "\t7- Salir.");

            opcion = Byte.parseByte(sc.nextLine());

            switch (opcion) {
                case 0:
                    System.out.println("Datos del jugador:");
                    System.out.println("------------------");

                    System.out.println("Objetos del jugador:");
                    for (CosaComprable unaCosaComprable : Partida.jugador1.getCosasCompradas()) {
                        System.out.println("datos de una cosa:" + unaCosaComprable.toString());
                    }

                    System.out.println("Tu dinero: " + Partida.jugador1.getDinero());

                    System.out.println("");

                    System.out.println("Datos del Casino:");
                    System.out.println("-----------------");

                    System.out.println("Objetos del casino:");
                    for (CosaComprable unaCosaComprable : Partida.casino.getCosasComprables()) {
                        System.out.println("datos de una cosa:" + unaCosaComprable.toString());
                    }

                    System.out.println("Dinero del casino: " + Partida.casino.getDinero());
                    break;

                case 1:
                    opcionComprar();
                    break;
                case 2:
                    // paso 1 - vemos si el jugador tiene cartones, porque si no no puede jugar
                    ArrayList<CosaComprable> cartonesJugador = Partida.jugador1.getCosasCompradas();
                    int numeroCartones = 0;
                    for (int i = 0; i < cartonesJugador.size(); i++) {
                        if (cartonesJugador.get(i) instanceof Carton) {
                            numeroCartones++;
                        }
                    }

                    if (numeroCartones == 0) {
                        System.out.println("Comprar antes de jugar");
                        continue;
                    }

                    // paso 2 - jugar al bingo
                    jugarBingo();
                    break;
            }

        } while (opcion != 7);
        
        */
    }

    public static void opcionComprar() {
        Scanner sc = new Scanner(System.in);

        byte opcionComprar;

        do {
            System.out.println("¿Qué quieres comprar?\n"
                    + "\t1- Comprar Cartón.\n"
                    + "\t2- Comprar Ficha.\n"
                    + "\t3- Comprar Boleto Lotería.\n"
                    + "\t4- Comprar Ticket de las 7 y media.\n"
                    + "\t5- Salir.");

            opcionComprar = Byte.parseByte(sc.nextLine());

            switch (opcionComprar) {
                case 1:
                    // paso 1 - comprobamos si tiene hay algún cartón para que pueda ser comprado
                    ArrayList<CosaComprable> stockCasino = Partida.casino.getCosasComprables();
                    int numeroCartones = 0;
                    for (int i = 0; i < stockCasino.size(); i++) {
                        if (stockCasino.get(i) instanceof Carton) {
                            numeroCartones++;
                        }
                    }

                    if (numeroCartones == 0) {
                        System.out.println("No hay cartones para comprar");
                        continue;
                    }

                    // paso 2 - comprobamos si tiene suficiente dinero para comprar un cartón el jugador
                    Carton uncarton = null;
                    for (int i = 0; i < stockCasino.size(); i++) {
                        if (stockCasino.get(i) instanceof Carton) {
                            uncarton = (Carton) stockCasino.get(i);
                            break;
                        }
                    }

                    if (Partida.jugador1.getDinero() < uncarton.getPrecio()) {
                        System.out.println("No tienes suficiente dinero");
                        continue;
                    }

                    // paso 3 - el jugador compra el cartón                    
                    System.out.println("Toma tu cartón");
                    Partida.casino.getCosasComprables().remove(uncarton);
                    Partida.jugador1.getCosasCompradas().add(uncarton);

                    double precioCarton = uncarton.getPrecio();
                    double miDinero = Partida.jugador1.getDinero();
                    miDinero -= precioCarton;
                    Partida.jugador1.setDinero(miDinero);

                    double dineroCasino = Partida.casino.getDinero();
                    dineroCasino -= precioCarton;
                    Partida.casino.setDinero(dineroCasino);
                    break;

            }
        } while (opcionComprar != 5);

    }

    public static void jugarBingo() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {

        }

    }

}
