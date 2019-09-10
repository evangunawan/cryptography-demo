package com.vincevan.cryptography.control;

import java.util.ArrayList;

public class CaesarCipher {

	private String plainText;
	private int key;

	private String encryptedText = "";
	private String decryptedText = "";
	
	private ArrayList<Integer> encryptedIntegers;

	public CaesarCipher(String plainText, int key) {
		this.plainText = plainText;
		this.key = key;
		this.plainText = this.plainText.toLowerCase();
		
		this.encryptedIntegers = new ArrayList<>();
		
		encryptText();
		decryptText();
	}
	private Integer convertToInteger(char c) {
		return (int)c - 97;
	}
	
	private char convertToChar(int i) {
		int res = i+97;
		return (char)res;
	}

	private void encryptText() {
		Integer temp = 0;
		for (int i = 0; i < plainText.length(); i++) {
			temp = (convertToInteger(plainText.charAt(i)) + key) % 26;
			encryptedIntegers.add(temp);
		}
		
		for(int x : encryptedIntegers) {
			encryptedText+=convertToChar(x);
		}
//		System.out.println("Caesar Encrypted: " + encryptedText);
	}

	private void decryptText() {
		Integer temp;
		for (int x : encryptedIntegers) {
			temp = x-key;
			if (temp < 0) {
				temp += 26;
			}
			decryptedText+=convertToChar(temp);
		}
	}
	
	public String getEncryptedText() {
		return encryptedText;
	}
	
	public String getDecryptedText() {
		return decryptedText;
	}
	public Integer getKey() {
		return key;
	}

}
