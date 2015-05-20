package nl.edu.avans.ivp4c2.presentation;

import javax.swing.*;

import nl.edu.avans.ivp4c2.manager.BarManager;

import static javax.swing.JOptionPane.*;

public class BarGUIFrame extends JFrame {
	BarManager barmanager;
	
	public BarGUIFrame(BarManager barmanager) {
		this.barmanager = barmanager;
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("Bedieningsysteem");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JPanel panel = new BarGUI(barmanager);
		this.setContentPane(panel);
		this.setVisible(true);


}
}
