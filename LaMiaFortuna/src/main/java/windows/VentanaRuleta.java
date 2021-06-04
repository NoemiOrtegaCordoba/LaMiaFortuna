package windows;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Casino;
import clases.Ficha;
import clases.Partida;
import clases.Ruleta;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRuleta extends JFrame {
	private JTextField textFieldFichasDisponibles;
	private JTextArea jTextArea;
	private JComboBox comboBoxNumerosApostados;
	
	private Ruleta ruleta;
	
	public VentanaRuleta() {

		ruleta = new Ruleta("ruleta del casino");
		
		setTitle("Sala de la Ruleta");
		setSize(800, 600);
		
		JLabel lblNewLabel = new JLabel("Fichas disponibles:");
		
		textFieldFichasDisponibles = new JTextField();

		// ponemos aquí las fichas disponibles en total del jugador usuario:
		Partida.jugador1.calcularFichasQueTienes();
		textFieldFichasDisponibles.setText( String.valueOf( Partida.jugador1.getFichasQueTienes() ) );
		
		textFieldFichasDisponibles.setEditable(false);
		textFieldFichasDisponibles.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona un número para apostar por él:");
		
		JComboBox comboBoxNumerosParaApostar = new JComboBox();
		comboBoxNumerosParaApostar.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "910", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36"}));
		
		JButton botonApostarFicha = new JButton("Poner ficha en ese número");
		botonApostarFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// si no hay fichas para poder apostar, nos lo advierte:
				int fichasDisponibles = Integer.valueOf( textFieldFichasDisponibles.getText() );
				
				if (fichasDisponibles == 0) {
					JOptionPane.showMessageDialog(null, "No tienes fichas para apostar a un número", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (Partida.jugador1.getFichasQueTienes() < fichasDisponibles) {

					Partida.jugador1.calcularFichasQueTienes();
					textFieldFichasDisponibles.setText( String.valueOf( Partida.jugador1.getFichasQueTienes() ) );
					
					JOptionPane.showMessageDialog(null, "No tienes tantas fichas", "Error", JOptionPane.ERROR_MESSAGE);
					
				} else {
					// al usar una, queda una menos:
					fichasDisponibles--;
					textFieldFichasDisponibles.setText( String.valueOf(fichasDisponibles) );

					// pasamos de un combobox a otro:
					String numeroSeleccionado = comboBoxNumerosParaApostar.getSelectedItem().toString();
					comboBoxNumerosApostados.addItem( numeroSeleccionado );
				}
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Números por los que se ha apostado:");
		
		comboBoxNumerosApostados = new JComboBox();
		
		JButton btnNewButton = new JButton("Esperar a que la ruleta dé vueltas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// el jugador usuario juega con estas fichas del combobox:
			    int count = comboBoxNumerosApostados.getItemCount();
	            for (int i = 0; i < count; i++) {
	                    int numero = Integer.parseInt( comboBoxNumerosApostados.getItemAt(i).toString() );
	                    
	                    // public Ficha(String color, double precio, byte numeroDondeEsta) {
	                    Ficha ficha = new Ficha("roja", Casino.precioFicha, (byte) numero);
	                    Partida.jugador1.getFichasRuleta().add(ficha);
	                    
	            }				

				ruleta.apuestanLosJugadores();
				ruleta.darVueltasARuleta();
				String texto = ruleta.cobranLosJugadoresOCasino();
				
				jTextArea.setText( "Ha salido el numero " + ruleta.getUltimoNumero() + "\n \n");
				jTextArea.setText( jTextArea.getText() + texto );
				
			}
		});
		
		jTextArea = new JTextArea();
		jTextArea.setRows(10);
		jTextArea.setColumns(10);
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(jTextArea);
		
		JLabel lblNewLabel_3 = new JLabel("Resultados de la ruleta:");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textFieldFichasDisponibles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 733, GroupLayout.PREFERRED_SIZE)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(comboBoxNumerosApostados, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(comboBoxNumerosParaApostar, Alignment.LEADING, 0, 226, Short.MAX_VALUE))
									.addComponent(lblNewLabel_3))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(botonApostarFicha)
										.addGap(340))))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldFichasDisponibles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxNumerosParaApostar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonApostarFicha))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(89)
							.addComponent(btnNewButton)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxNumerosApostados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3)
							.addGap(10)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		setVisible(true);
	}
}
