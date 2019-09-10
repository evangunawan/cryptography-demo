package com.vincevan.cryptography.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import com.vincevan.cryptography.control.BrowseButtonController;
import com.vincevan.cryptography.control.DecryptEvent;
import com.vincevan.cryptography.control.EncryptEvent;
import com.vincevan.cryptography.model.AppData;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JTextArea;

public class MainView {

	public JFrame frame;
	private JPanel panel;
	public JTextField txtPlainText;
	private JButton btnBrowse;
	private JLabel lblOr;
	private JLabel lblInputPlainText;
	private JPanel panel_1;
	private JButton btnEncrypt;
	private JLabel lblCaecarCypher;
	private JLabel lblVigenereC;
	private JLabel lblVigenereCipherautokey;
	public JTextField txtCaesarKey;
	private JLabel lblCipherKey;
	private JPanel panel_2;
	public JButton btnDecrypt;
	public JButton btnGetDecryptedFile;
	private JPanel panel_3;
	public JTextArea textArea;
	private JLabel lblResult;
	private JScrollPane scrollPane;
	private JLabel lblViginereKey;
	public JTextField txtVigenereKey;
	public JTextField txtResultCaesar;
	public JTextField txtResultVigenere;
	public JTextField txtResultAutoKey;
	public AppData appData;

	public MainView() {
		this.appData = new AppData();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cryptography Demo");
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(600,500));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{103, 128, 40, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{32, 62, 0, 0, 0, 0, 0, 32, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblInputPlainText = new JLabel("Input Plain Text to Encrypt");
		GridBagConstraints gbc_lblInputPlainText = new GridBagConstraints();
		gbc_lblInputPlainText.gridwidth = 2;
		gbc_lblInputPlainText.anchor = GridBagConstraints.WEST;
		gbc_lblInputPlainText.insets = new Insets(0, 0, 5, 5);
		gbc_lblInputPlainText.gridx = 1;
		gbc_lblInputPlainText.gridy = 2;
		panel.add(lblInputPlainText, gbc_lblInputPlainText);
		
		txtPlainText = new JTextField();
		GridBagConstraints gbc_txtPlainText = new GridBagConstraints();
		gbc_txtPlainText.fill = GridBagConstraints.BOTH;
		gbc_txtPlainText.gridwidth = 4;
		gbc_txtPlainText.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlainText.gridx = 1;
		gbc_txtPlainText.gridy = 3;
		panel.add(txtPlainText, gbc_txtPlainText);
		txtPlainText.setColumns(10);
		
		lblOr = new JLabel("OR");
		GridBagConstraints gbc_lblOr = new GridBagConstraints();
		gbc_lblOr.fill = GridBagConstraints.VERTICAL;
		gbc_lblOr.insets = new Insets(0, 0, 5, 5);
		gbc_lblOr.gridx = 5;
		gbc_lblOr.gridy = 3;
		panel.add(lblOr, gbc_lblOr);
		
		btnBrowse = new JButton("Browse File");
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.fill = GridBagConstraints.VERTICAL;
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrowse.gridx = 6;
		gbc_btnBrowse.gridy = 3;
		btnBrowse.addActionListener(new BrowseButtonController(frame,txtPlainText));
		panel.add(btnBrowse, gbc_btnBrowse);
		
		lblCipherKey = new JLabel("Caesar Key");
		GridBagConstraints gbc_lblCipherKey = new GridBagConstraints();
		gbc_lblCipherKey.fill = GridBagConstraints.VERTICAL;
		gbc_lblCipherKey.anchor = GridBagConstraints.EAST;
		gbc_lblCipherKey.insets = new Insets(0, 0, 5, 5);
		gbc_lblCipherKey.gridx = 1;
		gbc_lblCipherKey.gridy = 4;
		panel.add(lblCipherKey, gbc_lblCipherKey);
		
		txtCaesarKey = new JTextField();
		GridBagConstraints gbc_txtCaesarKey = new GridBagConstraints();
		gbc_txtCaesarKey.insets = new Insets(0, 0, 5, 5);
		gbc_txtCaesarKey.fill = GridBagConstraints.BOTH;
		gbc_txtCaesarKey.gridx = 2;
		gbc_txtCaesarKey.gridy = 4;
		panel.add(txtCaesarKey, gbc_txtCaesarKey);
		txtCaesarKey.setColumns(10);
		
		lblViginereKey = new JLabel("Viginere Key");
		GridBagConstraints gbc_lblViginereKey = new GridBagConstraints();
		gbc_lblViginereKey.anchor = GridBagConstraints.EAST;
		gbc_lblViginereKey.insets = new Insets(0, 0, 5, 5);
		gbc_lblViginereKey.gridx = 3;
		gbc_lblViginereKey.gridy = 4;
		panel.add(lblViginereKey, gbc_lblViginereKey);
		
		txtVigenereKey = new JTextField();
		GridBagConstraints gbc_txtViginereKey = new GridBagConstraints();
		gbc_txtViginereKey.insets = new Insets(0, 0, 5, 5);
		gbc_txtViginereKey.fill = GridBagConstraints.BOTH;
		gbc_txtViginereKey.gridx = 4;
		gbc_txtViginereKey.gridy = 4;
		panel.add(txtVigenereKey, gbc_txtViginereKey);
		txtVigenereKey.setColumns(10);
		
		btnEncrypt = new JButton("ENCRYPT");
		GridBagConstraints gbc_btnEncrypt = new GridBagConstraints();
		gbc_btnEncrypt.fill = GridBagConstraints.BOTH;
		gbc_btnEncrypt.insets = new Insets(0, 0, 5, 5);
		gbc_btnEncrypt.gridx = 6;
		gbc_btnEncrypt.gridy = 4;
		btnEncrypt.addActionListener(new EncryptEvent(this));
		panel.add(btnEncrypt, gbc_btnEncrypt);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{32, 0, 64, 32, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblCaecarCypher = new JLabel("Caesar Cipher:");
		GridBagConstraints gbc_lblCaecarCypher = new GridBagConstraints();
		gbc_lblCaecarCypher.anchor = GridBagConstraints.EAST;
		gbc_lblCaecarCypher.insets = new Insets(0, 0, 5, 5);
		gbc_lblCaecarCypher.gridx = 1;
		gbc_lblCaecarCypher.gridy = 1;
		panel_1.add(lblCaecarCypher, gbc_lblCaecarCypher);
		
		txtResultCaesar = new JTextField();
		txtResultCaesar.setToolTipText("");
		txtResultCaesar.setEditable(false);
		GridBagConstraints gbc_txtResultCaesar = new GridBagConstraints();
		gbc_txtResultCaesar.insets = new Insets(0, 0, 5, 5);
		gbc_txtResultCaesar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtResultCaesar.gridx = 2;
		gbc_txtResultCaesar.gridy = 1;
		panel_1.add(txtResultCaesar, gbc_txtResultCaesar);
		txtResultCaesar.setColumns(10);
		
		lblVigenereC = new JLabel("Vigenere Cipher:");
		GridBagConstraints gbc_lblVigenereC = new GridBagConstraints();
		gbc_lblVigenereC.anchor = GridBagConstraints.EAST;
		gbc_lblVigenereC.insets = new Insets(0, 0, 5, 5);
		gbc_lblVigenereC.gridx = 1;
		gbc_lblVigenereC.gridy = 2;
		panel_1.add(lblVigenereC, gbc_lblVigenereC);
		
		txtResultVigenere = new JTextField();
		txtResultVigenere.setEditable(false);
		GridBagConstraints gbc_txtResultVigenere = new GridBagConstraints();
		gbc_txtResultVigenere.insets = new Insets(0, 0, 5, 5);
		gbc_txtResultVigenere.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtResultVigenere.gridx = 2;
		gbc_txtResultVigenere.gridy = 2;
		panel_1.add(txtResultVigenere, gbc_txtResultVigenere);
		txtResultVigenere.setColumns(10);
		
		lblVigenereCipherautokey = new JLabel("Vigenere Cipher (Auto-Key):");
		GridBagConstraints gbc_lblVigenereCipherautokey = new GridBagConstraints();
		gbc_lblVigenereCipherautokey.anchor = GridBagConstraints.EAST;
		gbc_lblVigenereCipherautokey.insets = new Insets(0, 0, 5, 5);
		gbc_lblVigenereCipherautokey.gridx = 1;
		gbc_lblVigenereCipherautokey.gridy = 3;
		panel_1.add(lblVigenereCipherautokey, gbc_lblVigenereCipherautokey);
		
		txtResultAutoKey = new JTextField();
		txtResultAutoKey.setEditable(false);
		GridBagConstraints gbc_txtResultAutoKey = new GridBagConstraints();
		gbc_txtResultAutoKey.insets = new Insets(0, 0, 5, 5);
		gbc_txtResultAutoKey.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtResultAutoKey.gridx = 2;
		gbc_txtResultAutoKey.gridy = 3;
		panel_1.add(txtResultAutoKey, gbc_txtResultAutoKey);
		txtResultAutoKey.setColumns(10);
		
		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{32, 128, 128, 32, 0};
		gbl_panel_2.rowHeights = new int[]{23, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		btnDecrypt = new JButton("DECRYPT");
		btnDecrypt.setEnabled(false);
		GridBagConstraints gbc_btnDecrypt = new GridBagConstraints();
		gbc_btnDecrypt.insets = new Insets(0, 0, 0, 5);
		gbc_btnDecrypt.anchor = GridBagConstraints.NORTH;
		gbc_btnDecrypt.gridx = 1;
		gbc_btnDecrypt.gridy = 0;
		btnDecrypt.addActionListener(new DecryptEvent(this));
		panel_2.add(btnDecrypt, gbc_btnDecrypt);
		
		btnGetDecryptedFile = new JButton("Get Decrypted File");
		btnGetDecryptedFile.setEnabled(false);
		GridBagConstraints gbc_btnGetDecryptedFile = new GridBagConstraints();
		gbc_btnGetDecryptedFile.insets = new Insets(0, 0, 0, 5);
		gbc_btnGetDecryptedFile.gridx = 2;
		gbc_btnGetDecryptedFile.gridy = 0;
		panel_2.add(btnGetDecryptedFile, gbc_btnGetDecryptedFile);
		
		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		frame.getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{16, 547, 16, 0};
		gbl_panel_3.rowHeights = new int[]{0, 8, 0, 8, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		lblResult = new JLabel("Result");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.anchor = GridBagConstraints.WEST;
		gbc_lblResult.insets = new Insets(0, 0, 5, 5);
		gbc_lblResult.gridx = 1;
		gbc_lblResult.gridy = 1;
		panel_3.add(lblResult, gbc_lblResult);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setRows(10);
		//		GridBagConstraints gbc_textArea = new GridBagConstraints();
		//		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		//		gbc_textArea.fill = GridBagConstraints.BOTH;
		//		gbc_textArea.gridx = 1;
		//		gbc_textArea.gridy = 2;
		//		panel_3.add(textArea, gbc_textArea);
				
				scrollPane = new JScrollPane(textArea);
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 2;
				panel_3.add(scrollPane, gbc_scrollPane);
		
		postInit();
	}
	
	private void postInit() {
	}

}
