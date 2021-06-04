package windows;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.CartonBingo;
import clases.CartonLoteria;
import clases.Casino;
import clases.Ficha;
import clases.Partida;
import clases.Ticket;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowTienda extends JFrame {
	private JTextField textFieldDineroJugador;
	private JTextField textFieldCartonesJugador;
	private JTextField textFieldFichasJugador;
	private JTextField textFieldTickets7Jugador;
	private JTextField textFieldCartonesLoteria;
	private JTextField textFieldDineroCasino;

	public WindowTienda() {
		setTitle("Tienda del Casino");
		setSize(840, 340);
		
		JLabel lblNewLabel = new JLabel("Tu dinero");
		
		textFieldDineroJugador = new JTextField();
		textFieldDineroJugador.setText( String.valueOf(Partida.jugador1.getDinero()) );
		textFieldDineroJugador.setColumns(10);
		
		textFieldCartonesJugador = new JTextField();
		textFieldCartonesJugador.setText("0");
		textFieldCartonesJugador.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tus cartones");
		
		JLabel lblNewLabel_2 = new JLabel("Tus fichas");
		
		textFieldFichasJugador = new JTextField();
		textFieldFichasJugador.setText("0");
		textFieldFichasJugador.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tus tickets para 7 y media");
		
		textFieldTickets7Jugador = new JTextField();
		textFieldTickets7Jugador.setText("0");
		textFieldTickets7Jugador.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tus cartones de lotería");
		
		textFieldCartonesLoteria = new JTextField();
		textFieldCartonesLoteria.setText("0");
		textFieldCartonesLoteria.setColumns(10);
		
		JButton btnNewButton = new JButton("Comprar cartón");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cartonesJugador = Integer.valueOf( textFieldCartonesJugador.getText() );
				double dineroJugador = Double.valueOf( textFieldDineroJugador.getText() );
				double dineroCasino = Double.valueOf( textFieldDineroCasino.getText() );
				
				if (dineroJugador >= Casino.precioCarton) {
					cartonesJugador++;
					dineroJugador = dineroJugador - Casino.precioCarton;
					dineroCasino = dineroCasino + Casino.precioCarton;

					Partida.jugador1.setDinero(dineroJugador);
					Partida.jugador1.comprarCosa( new CartonBingo(Casino.precioCarton) );
					
					textFieldCartonesJugador.setText( String.valueOf(cartonesJugador) );
					textFieldDineroJugador.setText( String.valueOf(dineroJugador) );				
					textFieldDineroCasino.setText( String.valueOf(dineroCasino) );
				} else {
					JOptionPane.showMessageDialog(null, "No tienes suficiente dinero para comprar un cartón", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Devolver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cartonesJugador = Integer.valueOf( textFieldCartonesJugador.getText() );
				double dineroJugador = Double.valueOf( textFieldDineroJugador.getText() );
				double dineroCasino = Double.valueOf( textFieldDineroCasino.getText() );
				
				if (cartonesJugador > 0) {
					cartonesJugador--;
					dineroJugador = dineroJugador + Casino.precioCarton;
					dineroCasino = dineroCasino - Casino.precioCarton;

					Partida.jugador1.setDinero(dineroJugador);
					
					textFieldCartonesJugador.setText( String.valueOf(cartonesJugador) );
					textFieldDineroJugador.setText( String.valueOf(dineroJugador) );				
					textFieldDineroCasino.setText( String.valueOf(dineroCasino) );				
				} else {
					JOptionPane.showMessageDialog(null, "No tienes cartones por devolver al casino", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Comprar ficha");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int fichasJugador = Integer.valueOf( textFieldFichasJugador.getText() );
				double dineroJugador = Double.valueOf( textFieldDineroJugador.getText() );
				double dineroCasino = Double.valueOf( textFieldDineroCasino.getText() );
				
				if (dineroJugador >= Casino.precioFicha) {
					fichasJugador++;
					dineroJugador = dineroJugador - Casino.precioFicha;
					dineroCasino = dineroCasino + Casino.precioFicha;
					
					Partida.jugador1.setDinero(dineroJugador);
					Partida.jugador1.comprarCosa( new Ficha("roja", Casino.precioFicha, (byte) 0) );
					
					textFieldFichasJugador.setText( String.valueOf(fichasJugador) );
					textFieldDineroJugador.setText( String.valueOf(dineroJugador) );				
					textFieldDineroCasino.setText( String.valueOf(dineroCasino) );				
				} else {
					JOptionPane.showMessageDialog(null, "No tienes suficiente dinero para comprar una ficha", "Error", JOptionPane.ERROR_MESSAGE);
				}				
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("Devolver");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int fichasJugador = Integer.valueOf( textFieldFichasJugador.getText() );
				double dineroJugador = Double.valueOf( textFieldDineroJugador.getText() );
				double dineroCasino = Double.valueOf( textFieldDineroCasino.getText() );
				
				if (fichasJugador > 0) {
					fichasJugador--;
					dineroJugador = dineroJugador + Casino.precioFicha;
					dineroCasino = dineroCasino - Casino.precioFicha;
					
					Partida.jugador1.setDinero(dineroJugador);
					
					textFieldFichasJugador.setText( String.valueOf(fichasJugador) );
					textFieldDineroJugador.setText( String.valueOf(dineroJugador) );				
					textFieldDineroCasino.setText( String.valueOf(dineroCasino) );				
				} else {
					JOptionPane.showMessageDialog(null, "No tienes fichas por devolver", "Error", JOptionPane.ERROR_MESSAGE);
				}				
				
			}
		});
		
		JButton btnNewButton_4 = new JButton("Devolver");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ticketsJugador = Integer.valueOf( textFieldTickets7Jugador.getText() );
				double dineroJugador = Double.valueOf( textFieldDineroJugador.getText() );
				double dineroCasino = Double.valueOf( textFieldDineroCasino.getText() );
				
				if (ticketsJugador > 0) {
					ticketsJugador--;
					dineroJugador = dineroJugador + Casino.precioTicket7;
					dineroCasino = dineroCasino - Casino.precioTicket7;
					
					Partida.jugador1.setDinero(dineroJugador);
					
					textFieldTickets7Jugador.setText( String.valueOf(ticketsJugador) );
					textFieldDineroJugador.setText( String.valueOf(dineroJugador) );				
					textFieldDineroCasino.setText( String.valueOf(dineroCasino) );				
				} else {
					JOptionPane.showMessageDialog(null, "No tienes tickets de las 7 y media por devolver", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JButton btnNewButton_5 = new JButton("Comprar ticket");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ticketsJugador = Integer.valueOf( textFieldTickets7Jugador.getText() );
				double dineroJugador = Double.valueOf( textFieldDineroJugador.getText() );
				double dineroCasino = Double.valueOf( textFieldDineroCasino.getText() );
				
				if (dineroJugador >= Casino.precioTicket7) {
					ticketsJugador++;
					dineroJugador = dineroJugador - Casino.precioTicket7;
					dineroCasino = dineroCasino + Casino.precioTicket7;

					Partida.jugador1.setDinero(dineroJugador);
					Partida.jugador1.comprarCosa( new Ticket(Casino.precioTicket7) );
					
					textFieldTickets7Jugador.setText( String.valueOf(ticketsJugador) );
					textFieldDineroJugador.setText( String.valueOf(dineroJugador) );				
					textFieldDineroCasino.setText( String.valueOf(dineroCasino) );
				} else {
					JOptionPane.showMessageDialog(null, "No tienes suficiente dinero para comprar un ticket para las 7 y 30", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JButton btnNewButton_6 = new JButton("Comprar cartones de Lotería");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cartonesJugador = Integer.valueOf( textFieldCartonesLoteria.getText() );
				double dineroJugador = Double.valueOf( textFieldDineroJugador.getText() );
				double dineroCasino = Double.valueOf( textFieldDineroCasino.getText() );
				
				if (dineroJugador >= Casino.precioCartonLoteria) {
					cartonesJugador++;
					dineroJugador = dineroJugador - Casino.precioCartonLoteria;
					dineroCasino = dineroCasino + Casino.precioCartonLoteria;
					
					Partida.jugador1.setDinero(dineroJugador);
					Partida.jugador1.comprarCosa( new CartonLoteria(Casino.precioCartonLoteria) );
					
					textFieldCartonesLoteria.setText( String.valueOf(cartonesJugador) );
					textFieldDineroJugador.setText( String.valueOf(dineroJugador) );				
					textFieldDineroCasino.setText( String.valueOf(dineroCasino) );				
				} else {
					JOptionPane.showMessageDialog(null, "No tienes suficiente dinero para comprar cartones de lotería", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JButton btnNewButton_7 = new JButton("Devolver");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cartonesJugador = Integer.valueOf( textFieldCartonesLoteria.getText() );
				double dineroJugador = Double.valueOf( textFieldDineroJugador.getText() );
				double dineroCasino = Double.valueOf( textFieldDineroCasino.getText() );
				
				if (cartonesJugador > 0) {
					cartonesJugador--;
					dineroJugador = dineroJugador + Casino.precioCartonLoteria;
					dineroCasino = dineroCasino - Casino.precioCartonLoteria;
					
					Partida.jugador1.setDinero(dineroJugador);
					
					textFieldCartonesLoteria.setText( String.valueOf(cartonesJugador) );
					textFieldDineroJugador.setText( String.valueOf(dineroJugador) );				
					textFieldDineroCasino.setText( String.valueOf(dineroCasino) );				
				} else {
					JOptionPane.showMessageDialog(null, "No tienes cartones de lotería por devolver", "Error", JOptionPane.ERROR_MESSAGE);
				}				
				
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Dinero casino");
		
		textFieldDineroCasino = new JTextField();
		textFieldDineroCasino.setText("10000");
		textFieldDineroCasino.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textFieldDineroJugador, Alignment.LEADING)
							.addComponent(textFieldCartonesJugador, Alignment.LEADING)
							.addComponent(lblNewLabel_1, Alignment.LEADING)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNewLabel))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldFichasJugador))
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(4))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textFieldTickets7Jugador)
										.addGap(4))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_3)
										.addGap(30)))
								.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textFieldCartonesLoteria, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
										.addComponent(btnNewButton_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
						.addComponent(textFieldDineroCasino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(186))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDineroJugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDineroCasino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldFichasJugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCartonesLoteria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCartonesJugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTickets7Jugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_6)
						.addComponent(btnNewButton_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_7)
						.addComponent(btnNewButton_4))
					.addContainerGap(325, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		
		
		setVisible(true);
	}
	
}
