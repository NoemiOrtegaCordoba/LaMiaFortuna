package windows;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Partida;
import excepciones.CasillaSinRellenarException;
import excepciones.LoteriaFueraRango;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class WindowLoteria extends JFrame {
	private JTextField casilla1;
	private JTextField casilla2;
	private JTextField casilla3;
	private JTextField casilla4;
	private JTextField casilla5;
	private JTextField casilla6;
	private JTextField casillla7;
	private JTextField textField;
	private JButton botonSiguienteNumero;
	
	private int celda1;
	private int celda2;
	private int celda3;
	private int celda4;
	private int celda5;
	private int celda6;
	private int celda7;
	
	private int ultimoNumero;
	private int bolasSacadas = 0;
	
	private int cuantasNumerosAcertados = 0;
	
	public WindowLoteria() {
		setTitle("Sala de Lotería");
		
		JLabel lblNewLabel = new JLabel("Números elegidos:");
		
		casilla1 = new JTextField();
		casilla1.setText("0");
		casilla1.setColumns(10);
		
		casilla2 = new JTextField();
		casilla2.setText("0");
		casilla2.setColumns(10);
		
		casilla3 = new JTextField();
		casilla3.setText("0");
		casilla3.setColumns(10);
		
		casilla4 = new JTextField();
		casilla4.setText("0");
		casilla4.setColumns(10);
		
		casilla5 = new JTextField();
		casilla5.setText("0");
		casilla5.setColumns(10);
		
		casilla6 = new JTextField();
		casilla6.setText("0");
		casilla6.setColumns(10);
		
		casillla7 = new JTextField();
		casillla7.setText("0");
		casillla7.setColumns(10);
		
		JButton btnNewButton = new JButton("Empezar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					celda1 = Integer.valueOf( casilla1.getText() );
					celda2 = Integer.valueOf( casilla2.getText() );
					celda3 = Integer.valueOf( casilla3.getText() );
					celda4 = Integer.valueOf( casilla4.getText() );
					celda5 = Integer.valueOf( casilla5.getText() );
					celda6 = Integer.valueOf( casilla6.getText() );
					celda7 = Integer.valueOf( casillla7.getText() );
					
					// si no se ha rellenado las casillas, no se puede empezar
					if (celda1 == 0 || celda2 == 0 || celda2 == 0 || celda3 == 0 || 
						celda4 == 0 || celda5 == 0 || celda6 == 0 || celda7 == 0) {
	
						throw new CasillaSinRellenarException();
						
					} else if (celda1 < 1 || celda1 > 50 || celda2 < 1 || celda2 > 50  ||
							celda3 < 1 || celda3 > 50 || celda4 < 1 || celda4 > 50  ||
							celda5 < 1 || celda5 > 50 || celda6 < 1 || celda6 > 50  ||
							celda7 < 1 || celda7 > 50 ) {
						
						throw new LoteriaFueraRango();
						
					}
					
					// como no tiene ningún 0, comienza el juego
					btnNewButton.setEnabled(false);					
					botonSiguienteNumero.setEnabled(true);

					// eliminamos un carton de lotería del jugador
					Partida.jugador1.usarCartonDeLoteria();
					
					// y ya no pueden cambiarse los números:
					casilla1.setEditable(false);
					casilla2.setEditable(false);
					casilla3.setEditable(false);
					casilla4.setEditable(false);
					casilla5.setEditable(false);
					casilla6.setEditable(false);
					casillla7.setEditable(false);					
				
					sortearNumero();
					colorearCasillasPremiadas();
					
				} catch (NumberFormatException error1) {
					
					error1.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "No se puede quedar ninguna casilla vacía", "Info", JOptionPane.ERROR_MESSAGE);
									
				} catch (CasillaSinRellenarException error2) {
					
					error2.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "No se puede quedar ninguna casilla con un 0", "Info", JOptionPane.ERROR_MESSAGE);
					
				} catch (LoteriaFueraRango error3) {
					
					error3.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "Cada número debe estar entre 1 y 50, inclusive", "Info", JOptionPane.ERROR_MESSAGE);
					
				}
					
			}
		});
		
		botonSiguienteNumero = new JButton("Siguiente número");
		botonSiguienteNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Se sortea un nuevo número
				sortearNumero();
				colorearCasillasPremiadas();
				
				// se comprueba si se ha ganado o si se ha perdido
				if (cuantasNumerosAcertados >= 7) {
					
					// se ha ganado y se bloquea el botón "siguiente número", reseteando todas las celdas:
					resetearCasillas();
					
					botonSiguienteNumero.setEnabled(false);
					btnNewButton.setEnabled(true);
					
					JOptionPane.showMessageDialog(null, "Has acertado todos los números, enhorabuena! Se inicia una nueva partida", "Info", JOptionPane.INFORMATION_MESSAGE);
					
				} else if (bolasSacadas >= 100) {
					
					// entonces es que se ha acabado el juego también, perdiendo:
					JOptionPane.showMessageDialog(null, "Lo siento pero no has acertado ningún número. Se inicia una nueva partida", "Info", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
		});
		
		botonSiguienteNumero.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("Último número:");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(casilla1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(casilla2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(casilla3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(casilla4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(casilla5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(casilla6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(casillla7, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
								.addComponent(botonSiguienteNumero))))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(botonSiguienteNumero)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(casilla1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(casilla2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(casilla3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(casilla4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(casilla5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(casilla6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(casillla7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60))
		);
		getContentPane().setLayout(groupLayout);
        setVisible(true);
	}
	
	public void sortearNumero() {
		
		Random random = new Random();
		
		// los números posibles son de 1 a 50:
		ultimoNumero = random.nextInt(50) + 1;
		
		bolasSacadas++;
		
	}
	
	public void colorearCasillasPremiadas() {
		
		Color colorPremiado = Color.BLUE;
		
		if (celda1 == ultimoNumero && casilla1.getForeground() != colorPremiado) {
			casilla1.setForeground( colorPremiado );
			cuantasNumerosAcertados++;
		}
		
		if (celda2 == ultimoNumero && casilla2.getForeground() != colorPremiado) {
			casilla2.setForeground( colorPremiado );
			cuantasNumerosAcertados++;
		}
		
		if (celda3 == ultimoNumero && casilla3.getForeground() != colorPremiado) {
			casilla3.setForeground( colorPremiado );
			cuantasNumerosAcertados++;
		}
		
		if (celda4 == ultimoNumero && casilla4.getForeground() != colorPremiado) {
			casilla4.setForeground( colorPremiado );
			cuantasNumerosAcertados++;
		}
		
		if (celda5 == ultimoNumero && casilla5.getForeground() != colorPremiado) {
			casilla5.setForeground( colorPremiado );
			cuantasNumerosAcertados++;
		}
		
		if (celda6 == ultimoNumero && casilla6.getForeground() != colorPremiado) {
			casilla6.setForeground( colorPremiado );	
		}
		
		if (celda7 == ultimoNumero && casillla7.getForeground() != colorPremiado) {
			casillla7.setForeground( colorPremiado );
			cuantasNumerosAcertados++;
		}
				
	}
	
	public void resetearCasillas() {
		
		Color colorPremiado = Color.WHITE;

		casilla1.setForeground( colorPremiado );
		casilla2.setForeground( colorPremiado );
		casilla3.setForeground( colorPremiado );
		casilla4.setForeground( colorPremiado );
		casilla5.setForeground( colorPremiado );
		casilla6.setForeground( colorPremiado );	
		casillla7.setForeground( colorPremiado );
		
		casilla1.setText("0");
		casilla2.setText("0");
		casilla3.setText("0");
		casilla4.setText("0");
		casilla5.setText("0");
		casilla6.setText("0");	
		casillla7.setText("0");
		
	}
}

