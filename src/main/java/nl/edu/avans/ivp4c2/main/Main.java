package nl.edu.avans.ivp4c2.main;

import javax.swing.JFrame;

import nl.edu.avans.ivp4c2.manager.BarManager;
import nl.edu.avans.ivp4c2.presentation.BarGUIFrame;

import static javax.swing.JOptionPane.*;

public class Main{
	public static void main(String args[] ) {
		BarManager barmanager = new BarManager();
		final JFrame frame = new BarGUIFrame(barmanager);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (showConfirmDialog(frame,
						"Weet u zeker dat u de applicatie wilt sluiten?",
						"Applicatie afsluiten?",
						YES_NO_OPTION,
						QUESTION_MESSAGE) == YES_OPTION) {
					System.exit(0);
				}
			}
		});
}
}