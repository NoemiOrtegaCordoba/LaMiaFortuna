package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Bingo;
import clases.Partida;
import excepciones.CartonesCeroException;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WindowBingo extends JFrame {

	private JTextArea textArea; 
	private JTextField textFieldCartonesJugados;
	private JTextField textFieldUltimoNumero;
	private Bingo bingo;
		
	public WindowBingo() {
		    textArea = new JTextArea();
	        textArea.setText("Preparen sus cartones que el Bingo comienza pronto. \n \n \n");
	
	        JScrollPane scrollPane = new JScrollPane(textArea);

	        setTitle("Sala del Bingo");
	        
	        JButton btnNewButtonSacarBola = new JButton("Esperar nuevo número");
	        btnNewButtonSacarBola.setEnabled(false);
	        btnNewButtonSacarBola.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {

	        		saleNuevaBola();
	        		
	        	}
	        });
	        
	        JButton btnNewButton_1 = new JButton("Comenzar bingo");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	
	        		// comienza una nueva partida de bingo
	        		bingo = new Bingo();
	        		
	        		String cartonesJugados = textFieldCartonesJugados.getText();
	        		try {
	        			int cartonesJugadosNumero = Integer.parseInt(cartonesJugados);
	        		
	        			if (cartonesJugadosNumero == 0) {
	        				throw new CartonesCeroException("No se puede jugar al bingo con cero cartones");
	        			}

	        			// se va a jugar al bingo con estos cartones del jugador:
	        			bingo.jugarConCartones(Partida.jugador1, cartonesJugadosNumero);
	        			
	        			JOptionPane.showMessageDialog(null, "Has elegido ese número de cartones y ya no podrás modificarlo hasta que termine la partida, tras sacar las 90 bolas del bingo", "Info", JOptionPane.INFORMATION_MESSAGE);
	        			
	        			textFieldCartonesJugados.setEnabled(false);
	        			
	        			// ahora sale una nueva bola y se activan los campos para 
	        			// esperar a que salga otra bola:
	        			
	        			textFieldUltimoNumero.setEnabled(true);
	        			btnNewButtonSacarBola.setEnabled(true);
	        		
	        			saleNuevaBola();
	        			
	        		} catch (NumberFormatException e2) {

	        			JOptionPane.showMessageDialog(null, "Debes poner sólo números en los cartones que quieres jugar ahora", "Error", JOptionPane.ERROR_MESSAGE);
	        			
	        		} catch (CartonesCeroException e1) {

						e1.printStackTrace();
						
						JOptionPane.showMessageDialog(null, "Debes poner un número distinto a 0 en los cartones que quieres jugar ahora", "Error", JOptionPane.ERROR_MESSAGE);
					}
	        		
	        		
	        	}
	        });
	        
	        JLabel lblNewLabel = new JLabel("Cartones jugados");
	        
	        textFieldCartonesJugados = new JTextField();
	        textFieldCartonesJugados.setText("0");
	        textFieldCartonesJugados.setColumns(10);
	        
	        JLabel lblNewLabel_1 = new JLabel("Último número bingo");
	        
	        textFieldUltimoNumero = new JTextField();
	        textFieldUltimoNumero.setEnabled(false);
	        textFieldUltimoNumero.setColumns(10);
	        GroupLayout groupLayout = new GroupLayout(getContentPane());
	        groupLayout.setHorizontalGroup(
	        	groupLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addGap(34)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
	        				.addGroup(groupLayout.createSequentialGroup()
	        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	        						.addComponent(btnNewButton_1)
	        						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	        							.addComponent(textFieldCartonesJugados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        							.addComponent(lblNewLabel)))
	        					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
	        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	        						.addComponent(textFieldUltimoNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(lblNewLabel_1)
	        						.addComponent(btnNewButtonSacarBola))))
	        			.addContainerGap())
	        );
	        groupLayout.setVerticalGroup(
	        	groupLayout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblNewLabel)
	        				.addComponent(lblNewLabel_1))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(textFieldCartonesJugados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(textFieldUltimoNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(btnNewButtonSacarBola)
	        				.addComponent(btnNewButton_1))
	        			.addGap(36)
	        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
	        			.addGap(25))
	        );
	        getContentPane().setLayout(groupLayout);

	        // make it easy to close the application
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // set the frame size (you'll usually want to call frame.pack())
	        setSize(new Dimension(415, 315));
	        
	        // center the frame
	        setLocationRelativeTo(null);
	        
	        // make it visible to the user
	        setVisible(true);
	}
	
	private void saleNuevaBola() {
		// sacamos una bola nueva y la mostramos
		bingo.sacarBola();
		textFieldUltimoNumero.setText( String.valueOf(bingo.getUltimaBola()) );
		
		String textoPartida = bingo.tacharYComprobarSiLineaOBingo();
		String texto = textoPartida + "\n";
		
		textArea.setText( textArea.getText() + texto );
		
		// se comprueba si ha terminado el juego
		if (bingo.isBingoCantado()) {
			JOptionPane.showMessageDialog(null, "Como has cantado bingo, termina el juego, ¡enhorabuena!", "Info", JOptionPane.INFORMATION_MESSAGE);
			
			// el jugador gana algo de dinero:
			Partida.jugador1.ganarDinero(200); // gana 200€ por ganar el bingo
			
			// cerramos esta ventana: termina el juego
			this.setVisible(false);
			this.dispose();
			
		} else if (bingo.getLineasCantadas() > 0) {
			
			// por cada línea cantada le dan 50€: y no partida la partida
			Partida.jugador1.ganarDinero( bingo.getLineasCantadas() * 50 );
			bingo.setLineasCantadas(0);
			
		}
		
		// comprobamos también si ya termina el juego porque se han sacado todas las bolas:
		if (bingo.getBolasSacadasHastaAhora() >= 91) {
			
			JOptionPane.showMessageDialog(null, "Ya han salido todas las bolas!, termina el juego", "Info", JOptionPane.INFORMATION_MESSAGE);
			
			// cerramos esta ventana: termina el juego
			this.setVisible(false);
			this.dispose();
			
		}
		
	}
	
}

