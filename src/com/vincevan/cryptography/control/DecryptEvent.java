package com.vincevan.cryptography.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.vincevan.cryptography.model.AppData;
import com.vincevan.cryptography.view.MainView;

public class DecryptEvent implements ActionListener {

	private MainView view;
	private String result;
	private AppData appData;
	
	public DecryptEvent(MainView view) {
		this.view = view;
		this.result = "";
		this.appData = view.appData;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.result = "";
		
		String caesarResult = appData.caesar.getDecryptedText();
		this.result += "Caesar (Does not support multi line): \n" + caesarResult + "\nWith Caesar Key: " + appData.caesar.getKey() + "\n---";
		
		String vigenereResult = appData.vig.getDecryptedText();
		vigenereResult = vigenereResult.replace("\\n", "\n");
		this.result += "\nVigenere: \n" + vigenereResult + "\nWith Key: " + appData.vig.getKey() + "\n---";
		
		String autokeyResult = appData.autokey.getDecryptedText();
		autokeyResult = autokeyResult.replace("\\n", "\n");
		this.result += "\nVigenere AutoKey: \n" + autokeyResult + "\nWith Key: " + appData.autokey.getKey() + "\n---";
		
		view.textArea.setText(result);
		
	}
	

}
