package windows;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Carta;
import clases.Partida;
import clases.SieteYMedia;

public class VentanaSieteYMedia extends JFrame {
	
	private JTextField textFieldApuestaEstaMano;
	private JTextField carta1;
	private JTextField carta2;
	private JTextField carta3;
	private JTextField carta4;
	private JTextField carta5;
	private JTextField carta6;
	private JTextField carta7;
	private JTextField carta8;
	private JTextField carta9;
	private JTextField carta10;
	private JTextField carta11;
	private JTextField carta12;
	private JTextField carta13;
	private JTextField carta14;

	private SieteYMedia juegoCartas;
	
	public VentanaSieteYMedia() {
		setTitle("Sala de las Siete y Media");
		setSize(800, 600);
	
		// creamos el objeto de las siete y media para que pueda jugarse
		juegoCartas = new SieteYMedia();
		
		JButton btnNewButton = new JButton("Jugar Mano");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// jugar una mano, lo que implica que se haya escrito algo en apuesta de esta mano -se reseteara en cada mano-
				byte textFieldApuestaEstaManoByte = Byte.valueOf( textFieldApuestaEstaMano.getText() );
				
				if (textFieldApuestaEstaManoByte == 0) {
					
					JOptionPane.showMessageDialog(null, "No se puede quedar la apuesta a 0", "Info", JOptionPane.ERROR_MESSAGE);
					
				} else {
					
					// se juega esta mano:
				
					// establecemos la acción del usuario
					//jugador.setAccionCartas(accionUsuario); // aquí se preguntará la acción del usuario con un diálogo box o un combobox
					
					// si es el jugador, la apuesta la sacamos del parámetro, que vendrá de un TextField
					try {
						double apuestaUsuario = Double.valueOf( textFieldApuestaEstaMano.getText() );
						Partida.jugador1.setUltimaApuesta(apuestaUsuario);
						
						// y aquí se echa a jugar a los otros jugadores y se decide cuánto gana cada uno y qué ocurre
						
					} catch (NumberFormatException error2) {
						//error2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Escribe por favor una cantidad en euros en la cantidad de apuesta", "Info", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				
				
			}
		});
		
		textFieldApuestaEstaMano = new JTextField();
		textFieldApuestaEstaMano.setText("0");
		textFieldApuestaEstaMano.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Apuesta en esta mano:");
		
		JLabel lblNewLabel_1 = new JLabel("Tus cartas en esta mano:");
		
		carta1 = new JTextField();
		carta1.setText("0");
		carta1.setEditable(false);
		carta1.setColumns(10);
		
		carta2 = new JTextField();
		carta2.setText("0");
		carta2.setEditable(false);
		carta2.setColumns(10);
		
		carta3 = new JTextField();
		carta3.setText("0");
		carta3.setEditable(false);
		carta3.setColumns(10);
		
		carta4 = new JTextField();
		carta4.setText("0");
		carta4.setEditable(false);
		carta4.setColumns(10);
		
		carta5 = new JTextField();
		carta5.setText("0");
		carta5.setColumns(10);
		
		carta6 = new JTextField();
		carta6.setText("0");
		carta6.setEditable(false);
		carta6.setColumns(10);
		
		carta7 = new JTextField();
		carta7.setText("0");
		carta7.setEditable(false);
		carta7.setColumns(10);
		
		carta8 = new JTextField();
		carta8.setText("0");
		carta8.setEditable(false);
		carta8.setColumns(10);
		
		carta9 = new JTextField();
		carta9.setText("0");
		carta9.setEditable(false);
		carta9.setColumns(10);
		
		carta10 = new JTextField();
		carta10.setText("0");
		carta10.setEditable(false);
		carta10.setColumns(10);
		
		carta11 = new JTextField();
		carta11.setText("0");
		carta11.setEditable(false);
		carta11.setColumns(10);
		
		carta12 = new JTextField();
		carta12.setText("0");
		carta12.setEditable(false);
		carta12.setColumns(10);
		
		carta13 = new JTextField();
		carta13.setText("0");
		carta13.setEditable(false);
		carta13.setColumns(10);
		
		carta14 = new JTextField();
		carta14.setText("0");
		carta14.setEditable(false);
		carta14.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Pedir carta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// generamos una carta nueva y la guardamos en la lista de cartas del jugador usuario
				Carta carta = juegoCartas.sacarCartaAzar();
				
				ponerDatosCartaEnHueco(carta);			
				
				// y guardamos la carta en la lista de cartas del jugador
				Partida.jugador1.getCartas7YMedia().add(carta);
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Abandonar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(200)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(32)
									.addComponent(btnNewButton_1)
									.addGap(18)
									.addComponent(btnNewButton_2))
								.addComponent(lblNewLabel)
								.addComponent(textFieldApuestaEstaMano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(carta1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(carta2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(carta3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(carta4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(carta5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(carta6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(carta7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(carta8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(carta9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(carta10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(carta11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(carta12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(carta13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(carta14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldApuestaEstaMano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(64)
					.addComponent(lblNewLabel_1)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(carta1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(carta8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carta14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(264, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);		
		
		setVisible(true);
	}
	
	private void ponerDatosCartaEnHueco(Carta carta) {
		
		JTextField hueco = null;
		
		if (carta1.getText().equals("0")) {
			hueco = carta1;
		} else if (carta2.getText().equals("0")) {
			hueco = carta2;			
		} else if (carta3.getText().equals("0")) {
			hueco = carta3;
		} else if (carta4.getText().equals("0")) {
			hueco = carta4;		
		} else if (carta5.getText().equals("0")) {
			hueco = carta5;			
		} else if (carta6.getText().equals("0")) {
			hueco = carta6;			
		} else if (carta7.getText().equals("0")) {
			hueco = carta7;
		} else if (carta8.getText().equals("0")) {
			hueco = carta8;		
		} else if (carta9.getText().equals("0")) {
			hueco = carta9;			
		} else if (carta10.getText().equals("0")) {
			hueco = carta10;
		} else if (carta11.getText().equals("0")) {
			hueco = carta11;
		} else if (carta12.getText().equals("0")) {
			hueco = carta12;
		} else if (carta13.getText().equals("0")) {
			hueco = carta13;			
		} else if (carta14.getText().equals("0")) {
			hueco = carta14;			
		} else {
			JOptionPane.showMessageDialog(null, "No se pueden pedir más cartas, porque la suma necesariamente de 14 cartas en una baraja española da más de 7 y medio, y por lo tanto ya has perdido", "Info", JOptionPane.INFORMATION_MESSAGE);			
		}
		
		// y ahora ponemos el texto en el próximo hueco libre
		String textoCarta = carta.toString();
		hueco.setText(textoCarta);
	}
	
}
