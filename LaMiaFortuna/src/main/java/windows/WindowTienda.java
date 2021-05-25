package windows;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Casino;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowTienda extends JFrame {
	private JTextField textFieldDineroJugador;
	private JTextField textFieldCartonesJugador;
	private JTextField textFieldFichasJugador;
	private JTextField textFieldTickets7;
	private JTextField textFieldX;
	private JTextField textField;
	private JTextField textFieldDineroCasino;

	public WindowTienda() {
		setTitle("Tienda del Casino");
		setSize(800, 600);
		
		JLabel lblNewLabel = new JLabel("Tu dinero");
		
		textFieldDineroJugador = new JTextField();
		textFieldDineroJugador.setText("170");
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
		
		textFieldTickets7 = new JTextField();
		textFieldTickets7.setText("0");
		textFieldTickets7.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tus x");
		
		textFieldX = new JTextField();
		textFieldX.setText("0");
		textFieldX.setColumns(10);
		
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
					
					textFieldCartonesJugador.setText( String.valueOf(cartonesJugador) );
					textFieldDineroJugador.setText( String.valueOf(dineroJugador) );				
					textFieldDineroCasino.setText( String.valueOf(dineroCasino) );				
				} else {
					JOptionPane.showMessageDialog(null, "No tienes cartones por devolver al casino", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Comprar ficha");
		
		JButton btnNewButton_3 = new JButton("Devolver");
		
		JButton btnNewButton_4 = new JButton("Devolver");
		
		JButton btnNewButton_5 = new JButton("Comprar ticket");
		
		JButton btnNewButton_6 = new JButton("Comprar x");
		
		JButton btnNewButton_7 = new JButton("Devolver");
		
		textField = new JTextField();
		textField.setColumns(10);
		
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
										.addComponent(textFieldTickets7)
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
										.addComponent(textFieldX, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
										.addComponent(btnNewButton_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textFieldDineroCasino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(textFieldX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCartonesJugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTickets7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
