package parser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileSelectPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	String pathStr, tag;
	File path;
	JFileChooser chooser;
	JButton browseButton;
	JTextField pathField, tagField;
	JLabel pathLabel, tagLabel;

	FileSelectPanel() {
		setBackground(Color.gray);
		setPreferredSize(new Dimension(1000, 50));

		pathField = new JTextField(30);
		tagField = new JTextField(20);
		pathLabel = new JLabel("Type path here: ");
		tagLabel = new JLabel("Tag: ");
		browseButton = new JButton("Select directory");

		OptionListener listener = new OptionListener();
		browseButton.addActionListener(listener);

		add(pathLabel);
		add(pathField);
		add(browseButton);
		add(tagLabel);
		add(tagField);
	}

	public void update() {
		pathStr = pathField.getText();
		tag = tagField.getText();
	}

	private void browsePath() {
		chooser = new JFileChooser();
		chooser.setPreferredSize(new Dimension(600, 800));
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Select a folder");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			// Can also use null instead of this
			path = chooser.getSelectedFile();
			pathStr = path.toString();
			pathField.setText(pathStr);
		} else {
			System.out.println("No Selection ");
		}
	}

	private class OptionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			browsePath();
		}
	}

	public String getPathStr() {
		return pathStr;
	}

	public String getTag() {
		return tag;
	}
}
