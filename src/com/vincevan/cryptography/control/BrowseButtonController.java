package com.vincevan.cryptography.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BrowseButtonController implements ActionListener{

	private JFrame mainFrame;
	private JTextField target;
//	private int lineCount=0;
	
	public BrowseButtonController(JFrame frame, JTextField target){
		this.mainFrame = frame;
		this.target = target;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		final JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(mainFrame);
		
		File file = fc.getSelectedFile();
		String resultText = "";
		try {
			BufferedReader in;
			in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			while(line!=null) {
//				lineCount++;
				resultText += line + "\\n";
				line = in.readLine();
			}
			target.setText(resultText);
//			if(lineCount == 1) {
//				target.setText(resultText);
//			}else {
//				target.setText("<Loaded multiple lines>");
//			}
//			lineCount =0;
			resultText = "";
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
