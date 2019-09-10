package com.vincevan.cryptography.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.vincevan.cryptography.model.AppData;
import com.vincevan.cryptography.view.MainView;

public class EncryptEvent implements ActionListener{

	String plainText;
	String vigenereKey;
	String caesarKey;
	MainView view;
	AppData appdata;
	
	public EncryptEvent(MainView view) {
		this.view = view;
		this.appdata = view.appData;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.plainText = view.txtPlainText.getText();
		this.caesarKey = view.txtCaesarKey.getText();
		this.vigenereKey = view.txtVigenereKey.getText();
		
		System.out.println("(DEBUG) Data received: " + plainText + "," + vigenereKey +  "," + caesarKey);
		//Check if null or not valid
		if(plainText.isEmpty() || vigenereKey.isEmpty() || !isNumber(caesarKey)) {
			JOptionPane.showMessageDialog(view.frame, "Inputs are empty or invalid.", "Warning", JOptionPane.WARNING_MESSAGE );
			return;
		}

		//Convert caesar key to int.
		int caesarKeyNum = Integer.parseInt(caesarKey);
		
		//Encryption
		appdata.caesar = new CaesarCipher(plainText, caesarKeyNum);
		view.txtResultCaesar.setText(appdata.caesar.getEncryptedText());
		
		appdata.vig = new VigenereCipher(plainText, vigenereKey);
		view.txtResultVigenere.setText(appdata.vig.getEncryptedText());
		
		appdata.autokey = new AutoKey(plainText, vigenereKey);
		view.txtResultAutoKey.setText(appdata.autokey.getEncryptedText());
		
		view.btnDecrypt.setEnabled(true);
		view.btnGetDecryptedFile.setEnabled(true);
	}
	
	private boolean isNumber(String str) {
		try {
	        int d = Integer.parseInt(str);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}

}
