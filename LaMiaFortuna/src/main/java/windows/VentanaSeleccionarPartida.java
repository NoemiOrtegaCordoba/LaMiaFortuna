package windows;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import clases.Partida;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaSeleccionarPartida extends JFrame {

	public VentanaSeleccionarPartida() {
		
		setSize(800, 600);
		
		JLabel lblNewLabel = new JLabel("Borrar Partida (selecciona el id)");
		
		// rellenamos el combobox con los id de las partidas de la bd:
		  ArrayList<String> arrayList = new ArrayList<String>();
		  try
		    {
		      // create our mysql database connection
		      String myDriver = "com.mysql.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost/lamiafortuna";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		      
		      // our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM partida";

		      // create the java statement
		      Statement st2 = conn.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs2 = st2.executeQuery(query);
		      
		      // iterate through the java resultset
		      while (rs2.next())
		      {
		        int id = rs2.getInt("id");
		        arrayList.add( String.valueOf(id) );
		      }
		      st2.close();
		    }
		    catch (Exception e)
		    { 
		      System.err.println(e.getMessage());
		    }
		  
		 
		
		String[] array = new String[arrayList.size()];
		for(int i = 0; i < array.length; i++) {
		    array[i] = arrayList.get(i);
		}
		JComboBox comboBoxBorrar = new JComboBox(array);
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
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
				      st.executeUpdate("DELETE FROM `partida` WHERE `id` = " + comboBoxBorrar.getSelectedItem().toString() + ";");

				      conn.close();
				      
				      JOptionPane.showMessageDialog(null, "Partida borrada con éxito en la BD", "Info", JOptionPane.PLAIN_MESSAGE);
				      
				      dispose();
				    }
				    catch (Exception error2)
				    {
				    	error2.printStackTrace();
				    	JOptionPane.showMessageDialog(null, "Error al grabar la partida en la BD", "Error", JOptionPane.ERROR_MESSAGE);
				    }				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(339)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(comboBoxBorrar, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(296, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(169)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(comboBoxBorrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(297, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		setVisible(true);
		
	}
	
}
