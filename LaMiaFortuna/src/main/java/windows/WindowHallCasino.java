package windows;

import javax.swing.JFrame;
import java.sql.*;
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
		
		setSize(450, 450);
		
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Partida.jugador1.tieneAlgunaFicha()) {
					
					VentanaRuleta ventanaRuleta = new VentanaRuleta();
					
				} else {
					
					JOptionPane.showMessageDialog(null, "No puedes jugar si todavía no tienes ninguna ficha", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		
		
		
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
		
		JButton btnNewButton_5 = new JButton("Grabar partida");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 try
				    {
				      // create a mysql database connection
				      String myDriver = "com.mysql.jdbc.Driver";
				      String myUrl = "jdbc:mysql://localhost/lamiafortuna";
				      Class.forName(myDriver);
				      Connection conn = DriverManager.getConnection(myUrl, "root", "");
				      
				      Statement st = conn.createStatement();

				      // note that i'm leaving "date_created" out of this insert statement
				      st.executeUpdate("INSERT INTO `partida` (`id`, `jugador_nombre`, `jugador_dinero`, `dinero_casino`) VALUES (NULL, '" + Partida.jugador1.getNombre() + "', '" +  Partida.jugador1.getDinero() + "', '" + Partida.casino.getDinero() + "')");

				      conn.close();
				      
				      JOptionPane.showMessageDialog(null, "Partida grabada con éxito en la BD", "Info", JOptionPane.PLAIN_MESSAGE);
				    }
				    catch (Exception error2)
				    {
				    	error2.printStackTrace();
				    	JOptionPane.showMessageDialog(null, "Error al grabar la partida en la BD", "Error", JOptionPane.ERROR_MESSAGE);
				    }
				
			}
		});
		
		JButton btnNewButton_6 = new JButton("Borrar partida");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaSeleccionarPartida windowSeleccionarPartida = new VentanaSeleccionarPartida(); 
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(99)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_6)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(138, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_5)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_6)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		setVisible(true);
	}
}
