package parser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
// TODO add radio button settingds
public class MainPanel extends JPanel{
	
//	BorderLayout layout;
	String pathStr;
	String tag;
	ArrayList<String> results;
	JButton submitButton;
	SubmitListener submit;
	
	private static final long serialVersionUID = 1L;
	
	FileSelectPanel inputPanel;
	ResultPanel outputPanel;
	
	MainPanel(){
		setBackground(Color.darkGray);
		setPreferredSize(new Dimension(1000, 1200));
		setMinimumSize(new Dimension(1000, 1200));
		
//		layout = new BorderLayout();
//		setLayout(layout);
		
		inputPanel = new FileSelectPanel();
		outputPanel = new ResultPanel();
		
		submitButton = new JButton("Submit");
		submit = new SubmitListener();
		submitButton.addActionListener(submit);
		
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		add(inputPanel);
		add(submitButton);
		add(outputPanel);
		
	}
	
	public class SubmitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			inputPanel.update();
			pathStr = inputPanel.getPathStr();
			tag = inputPanel.getTag();
			
			Parser parser = new Parser(pathStr, tag);
			parser.data();
			
			outputPanel.display(parser.getData());
		}

	}
	
}
