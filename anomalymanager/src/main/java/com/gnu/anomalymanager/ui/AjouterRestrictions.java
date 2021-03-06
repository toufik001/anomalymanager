/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnu.anomalymanager.ui;

import javax.swing.JFrame;

/**
 * 
 * @author toufik
 */
public class AjouterRestrictions extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates new form AjouterRestrictions
	 */
	public AjouterRestrictions() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gbc;

		restrictionTesxt = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		restriction = new javax.swing.JTextArea();
		annuler = new javax.swing.JButton();
		ok = new javax.swing.JButton();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Ajouter Restriction");
		setPreferredSize(new java.awt.Dimension(600, 300));
		getContentPane().setLayout(new java.awt.GridBagLayout());

		restrictionTesxt.setText("Restriction: ");
		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = java.awt.GridBagConstraints.NORTH;
		gbc.insets = new java.awt.Insets(10, 10, 0, 0);
		getContentPane().add(restrictionTesxt, gbc);

		restriction.setColumns(20);
		restriction.setRows(5);
		jScrollPane2.setViewportView(restriction);

		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gbc.fill = java.awt.GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new java.awt.Insets(10, 5, 10, 10);
		getContentPane().add(jScrollPane2, gbc);

		annuler.setText("Annuler");
		gbc = new java.awt.GridBagConstraints();
		gbc.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gbc.anchor = java.awt.GridBagConstraints.EAST;
		gbc.insets = new java.awt.Insets(0, 0, 10, 10);
		getContentPane().add(annuler, gbc);

		ok.setText("OK");
		ok.setPreferredSize(annuler.getPreferredSize());
		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = java.awt.GridBagConstraints.RELATIVE;
		gbc.anchor = java.awt.GridBagConstraints.EAST;
		gbc.insets = new java.awt.Insets(0, 0, 10, 90);
		getContentPane().add(ok, gbc);

		this.setLocationRelativeTo(this);
		this.setVisible(true);
		pack();
	}// </editor-fold>

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		new AjouterRestrictions().setVisible(true);
	}

	// Variables declaration - do not modify
	private javax.swing.JButton annuler;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton ok;
	private javax.swing.JTextArea restriction;
	private javax.swing.JLabel restrictionTesxt;
	// End of variables declaration
}
