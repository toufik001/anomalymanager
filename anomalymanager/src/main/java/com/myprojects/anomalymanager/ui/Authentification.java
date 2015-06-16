package com.myprojects.anomalymanager.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Authentification extends JFrame {
	// Variables declaration - do not modify
	private Bouton connexion = new Bouton("connexion : ");
	private javax.swing.JLabel matAgent = new JLabel("matAgent : ");
	private javax.swing.JLabel passwrd = new JLabel("mot de passe : ");
	private javax.swing.JPasswordField passwordField = new JPasswordField();
	private javax.swing.JTextField matAgentField = new JTextField();
	private MonPanel panel = new MonPanel();

	// End of variables declaration

	public Authentification() {
		this.setSize(500, 400);
		this.setTitle("Authentification");
		this
				.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		panel.setLayout(new java.awt.GridBagLayout());

		java.awt.GridBagConstraints gbc;
		matAgent.setText("matAgent : ");
		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc.anchor = java.awt.GridBagConstraints.PAGE_START;
		gbc.insets = new java.awt.Insets(20, 20, 10, 10);
		panel.add(matAgent, gbc);

		passwrd.setText("mot de passe : ");
		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc.insets = new java.awt.Insets(0, 20, 10, 10);
		panel.add(passwrd, gbc);

		matAgentField.setMinimumSize(new java.awt.Dimension(150, 20));
		matAgentField.setPreferredSize(new java.awt.Dimension(150, 20));
		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc.insets = new java.awt.Insets(20, 0, 10, 20);
		panel.add(matAgentField, gbc);

		passwordField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
					connexionActionPerformed();

			}
		});
		gbc = new java.awt.GridBagConstraints();
		gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc.insets = new java.awt.Insets(0, 0, 10, 20);
		panel.add(passwordField, gbc);

		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				connexionActionPerformed();

			}
		});
		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc.insets = new java.awt.Insets(0, 0, 20, 20);
		panel.add(connexion, gbc);

		this.getContentPane().add(panel);
		this.setVisible(true);
	}

	public void connexionActionPerformed() {
		AgentDaoImpl dao = new AgentDaoImpl();
		try {
			GenericDao agent = dao.getByMat(matAgentField.getText());
			String passwrd = new String(passwordField.getPassword());
			if (GenericDao.password.equals(passwrd)) {
				if (agent.getPoste().equals("maintenance")) {
					new TableauAnomalie(new AnomalyDaoImpl().getAll());
					this.dispose();
				}

				else if (agent.getPoste().equals("superviseur")) {
					new TableauMachine(new MachineDaoImpl().getAll())
							.setVisible(true);
					this.dispose();

				} else if (agent.getPoste().equals("saisie")) {
					new TableauMachine(new MachineDaoImpl().getAll());
					this.dispose();
				}
			} else
				System.out.println("ca marche pas!!!");
		} catch (TechnicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new Authentification();
	}

}
