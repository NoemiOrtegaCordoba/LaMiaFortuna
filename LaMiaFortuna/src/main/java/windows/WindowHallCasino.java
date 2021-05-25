package windows;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowHallCasino extends JFrame {
	
	public WindowHallCasino() {
		setTitle("Bienvenido al Casino");
		setSize(800, 600);
		
		JButton btnNewButton = new JButton("Ir a Tienda del Casino");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WindowTienda windowTienda = new WindowTienda();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Jugar a Bingo");
		
		JButton btnNewButton_2 = new JButton("Jugar a Ruleta");
		
		JButton btnNewButton_3 = new JButton("Jugar a X");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(99)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(596, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(18)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_3)
					.addContainerGap(353, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		setVisible(true);
	}
	
}