package windows;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Casino;
import clases.CosaComprable;
import clases.Jugador;
import clases.Partida;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class WindowHallCasino extends JFrame {
	
	public WindowHallCasino() {
		setTitle("Bienvenido al Casino");
		
		// se crea un jugador:
		// public Jugador(String nombre, double dinero, ArrayList<CosaComprable> cosasCompradas) {
		ArrayList<CosaComprable> cosasCompradas = new ArrayList<CosaComprable>();
		
		if (Partida.jugador1 == null) {
			Partida.jugador1 = new Jugador("Jugador Usuario", 150, cosasCompradas);
		}
		
		if (Partida.casino == null) {
			Partida.casino = new Casino();
		}
		
		setSize(390, 370);
		
		JButton btnNewButton = new JButton("Ir a Tienda del Casino");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WindowTienda windowTienda = new WindowTienda();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Jugar a Bingo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Partida.jugador1.tieneAlgunCarton()) {
				
					WindowBingo windowBingo = new WindowBingo();
					
				} else {
					
					JOptionPane.showMessageDialog(null, "No puedes jugar si todavía no tienes ningún cartón", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Jugar a Ruleta");
		
		JButton btnNewButton_3 = new JButton("Jugar a 7 media");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Partida.jugador1.tieneAlgunTicket()) {
					
					VentanaSieteYMedia ventanaSieteYMedia = new VentanaSieteYMedia();
					
				} else {
					
					JOptionPane.showMessageDialog(null, "No puedes jugar si todavía no tienes ningún ticket para jugar a las Siete y Media", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		
		JButton btnNewButton_4 = new JButton("Jugar a Lotería");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Partida.jugador1.tieneAlgunCartonLoteria()) {
					
					WindowLoteria windowLoteria = new WindowLoteria();
					
				} else {
					
					JOptionPane.showMessageDialog(null, "No puedes jugar si todavía no tienes ningún cartón de Lotería, cómpralo antes", "Error", JOptionPane.ERROR_MESSAGE);
					
				}				
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(99)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(548, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(18)
					.addComponent(btnNewButton_4)
					.addGap(17)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_3)
					.addContainerGap(313, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		setVisible(true);
	}
}
