package parser;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GUIapp {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Tag finder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(1000, 1200));
		frame.setMinimumSize(new Dimension(1000, 1200));

		MainPanel mainPanel = new MainPanel();
		frame.getContentPane().add(mainPanel);

		frame.pack();
		frame.setVisible(true);
	}
}
