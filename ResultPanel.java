package parser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultPanel extends JPanel{

		private static final long serialVersionUID = 1L;
		
		//private ArrayList<String> results;
		private JTextArea textOutput;
		private JScrollPane scroll;
		
		ResultPanel(){
			setBackground(Color.darkGray);
			setPreferredSize(new Dimension(1000, 1100));
			textOutput = new JTextArea();
			scroll = new JScrollPane(textOutput);
			scroll.setPreferredSize(new Dimension(900,1000));
			scroll.setBorder(BorderFactory.createLineBorder(Color.black));
			scroll.scrollRectToVisible(new Rectangle());
			//	TODO make text output scalable and with scroll bars
			add(scroll);
		}
		
		public void display(ArrayList<String> results){
			String data = "";
			for (String entry : results) {
				data += entry + "\n";
			}
			textOutput.setText(data);
		}
}
