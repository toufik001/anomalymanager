package com.gnu.anomalymanager.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Authentification1 extends JPanel {
	private JLabel user = new JLabel("matricule: ");
	private JLabel passwrd = new JLabel("mot de passe: ");
	private JTextField userTextField = new JTextField();
	private JPasswordField passwrdTextField = new JPasswordField();
	private Bouton connect = new Bouton("connecter");

	public Authentification1() {

		setLayout(new GridBagLayout());
		
		passwrdTextField.setSize(100, 20);

		add(user);

		add(userTextField);
		add(passwrd);
		add(passwrdTextField);
		add(connect);
		userTextField.setPreferredSize(new Dimension(150, 17));
		System.out.println(userTextField.getSize() + "   "
				+ passwrdTextField.getSize() + " " + this.getSize());
		this.setBackground(Color.WHITE);
		connect.addActionListener(new ActionConnect());
		System.out.println(connect.getPreferredSize());
		passwrdTextField.addKeyListener(new ActionConnect());
		this.setVisible(true);
	}

	public class ActionConnect implements ActionListener, KeyListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(userTextField.getText());
			System.out.println(passwrdTextField.getPassword());

		}

		@Override
		public void keyPressed(KeyEvent event) {
			// TODO Auto-generated method stub
			System.out.println(event.getKeyCode());
			if (event.getKeyCode() == 10)
				this.actionPerformed(null);

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}
