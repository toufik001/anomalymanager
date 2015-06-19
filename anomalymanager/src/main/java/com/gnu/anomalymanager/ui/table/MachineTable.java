package com.gnu.anomalymanager.ui.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.gnu.anomalymanager.bo.Machine;
import com.gnu.anomalymanager.dao.impl.MachineDaoImpl;
import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.modelobject.MachineDynModel;
import com.gnu.anomalymanager.ui.Bouton;
import com.gnu.anomalymanager.ui.TableComponent;


@SuppressWarnings("serial")
public class MachineTable extends JFrame {
	private Bouton rechercheBouton = new Bouton("chercher");
	private Bouton ajouter = new Bouton("Ajouter");
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable table = new JTable();
	private Bouton modifier = new Bouton("Modifier");
	private javax.swing.JLabel recherche = new JLabel("recherche: ");
	private javax.swing.JTextField rechercheField = new JTextField();
	private Bouton supprimer = new Bouton("Supprimer");
	private Bouton boutonAnomalies = new Bouton("Afficher les Anomalies");
	private Bouton boutonRestrictions = new Bouton("Afficher les Restrictions");

	public MachineTable() throws DaoException {
		super();
		this.setSize(new Dimension(1100, 600));
		this.setTitle("Machines");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		java.awt.GridBagConstraints gbc;

		jScrollPane1 = new javax.swing.JScrollPane();

		setTitle("Les Machines");
		getContentPane().setLayout(new java.awt.GridBagLayout());

		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 10;
		gbc.fill = java.awt.GridBagConstraints.BOTH;
		gbc.anchor = java.awt.GridBagConstraints.NORTH;
		gbc.insets = new java.awt.Insets(10, 10, 0, 0);
		getContentPane().add(recherche, gbc);

		rechercheField.addKeyListener(new rechercheAction());
		rechercheField.setMinimumSize(new java.awt.Dimension(20, 20));
		rechercheField.setPreferredSize(new java.awt.Dimension(200, 20));
		gbc = new java.awt.GridBagConstraints();
		gbc.fill = java.awt.GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.insets = new java.awt.Insets(10, 0, 0, 0);
		getContentPane().add(rechercheField, gbc);

		jScrollPane1.setAutoscrolls(true);
		jScrollPane1.setCursor(new java.awt.Cursor(
				java.awt.Cursor.DEFAULT_CURSOR));
		jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 333));

		table = new JTable(new MachineDynModel());
		
		table.setDefaultRenderer(JComponent.class, new TableComponent());
		table.setGridColor(new java.awt.Color(255, 102, 51));
		table.setRequestFocusEnabled(false);
		jScrollPane1.setViewportView(table);

		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 3;
		gbc.fill = java.awt.GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new java.awt.Insets(5, 5, 0, 5);
		getContentPane().add(jScrollPane1, gbc);

		ajouter.addActionListener(new AddAction());
		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc.insets = new java.awt.Insets(5, 0, 5, 5);
		getContentPane().add(ajouter, gbc);

		supprimer.addActionListener(new removeAction());
		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc.insets = new java.awt.Insets(0, 0, 5, 5);
		getContentPane().add(supprimer, gbc);

		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridheight = java.awt.GridBagConstraints.REMAINDER;
		gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc.anchor = java.awt.GridBagConstraints.NORTH;
		gbc.insets = new java.awt.Insets(0, 0, 0, 5);
		getContentPane().add(modifier, gbc);

		rechercheBouton.addActionListener(new rechercheAction());
		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = java.awt.GridBagConstraints.WEST;
		gbc.insets = new java.awt.Insets(10, 5, 0, 5);
		getContentPane().add(rechercheBouton, gbc);

		gbc = new java.awt.GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new java.awt.Insets(5, 5, 10, 5);
		getContentPane().add(boutonAnomalies, gbc);

		gbc = new java.awt.GridBagConstraints();
		gbc.gridy = 4;
		gbc.anchor = java.awt.GridBagConstraints.BELOW_BASELINE_LEADING;
		gbc.insets = new java.awt.Insets(5, 0, 10, 0);
		getContentPane().add(boutonRestrictions, gbc);

		this.setVisible(true);
	}

	public class rechercheAction extends AbstractAction implements KeyListener {
		private JOptionPane jop2 = new JOptionPane();

		@Override
		public void actionPerformed(ActionEvent arg0) {
			searchAction();
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				searchAction();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@SuppressWarnings("static-access")
		public void searchAction() {
			table.clearSelection();
			int row = table.getRowCount();
			int i = 0, index = 0;
			if (!rechercheField.getText().isEmpty()) {

				while (i < row) {
					if (table.getValueAt(i, 1).equals(rechercheField.getText()))
						index = i;
					i++;
				}
				if (index != 0)
					table.addRowSelectionInterval(index, index);
				else
					jop2.showMessageDialog(null,
							"la machine que vous cherchez est introuvable",
							"Information", JOptionPane.WARNING_MESSAGE);
			} else {
				jop2.showMessageDialog(null,
						"vous devez saisir une serie pour la recherche",
						"Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public static void main(String args[]) {

			try {
				new MachineTable();
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

	public class AddAction extends AbstractAction {
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
//			JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
//			String serie = jop.showInputDialog(null,
//					"entrer la s�rie de la machine: ", "Ajout d'une Machine",
//					JOptionPane.QUESTION_MESSAGE);
//			if (!serie.isEmpty()) {
//				try {
//					((MachineDynModel) table.getModel()).add(
//							new Machine(serie), 0);
//				} catch (TechnicalException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ObjectNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			jop2.showMessageDialog(null, "la serie que vous avez ajout� est  "
//					+ serie, "Identit�", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public class removeAction extends AbstractAction {

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
//			int[] selection = table.getSelectedRows();
//			JOptionPane jop = new JOptionPane();
//			int option;
//			if (selection.length != 0) {
//				option = jop.showConfirmDialog(null,
//						"Voulez-vous vraiment supprimer la Machine ?",
//						"Suppression", JOptionPane.YES_NO_OPTION,
//						JOptionPane.QUESTION_MESSAGE);
//				if (option == JOptionPane.YES_OPTION) {
//					for (int i = selection.length - 1; i >= 0; i--) {
//						try {
//							((MachineDynModel) table.getModel())
//									.remove(selection[i]);
//						} catch (TechnicalException e1) {
//							e1.printStackTrace();
//						}
//					}
//				}
//			} else
//				JOptionPane.showMessageDialog(null,
//						"vous-devez selectionner une machine", "Information",
//						JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public class addRestriction implements MouseListener {

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
//			if (e.getClickCount() == 2) {
//				Point p = e.getPoint();
//				int row = table.rowAtPoint(p);
//
//				ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
//				Long numero = (Long) table.getModel().getValueAt(row, 0);
//
//				try {
//
//					restrictions.toString();
//					restrictions = new RestrictionDaoImpl().getAllByNum(numero);
//					new TableauRestriction(restrictions);
//
//				} catch (ObjectNotFoundException e1) {
//					JOptionPane.showMessageDialog(null, e1.getMessage(),
//							"Information", JOptionPane.INFORMATION_MESSAGE);
//				}
//
//			}
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
