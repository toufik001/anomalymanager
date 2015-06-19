package com.gnu.anomalymanager.ui.table;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.modelobject.RestrictionDynModel;
import com.gnu.anomalymanager.ui.AjouterRestrictions;
import com.gnu.anomalymanager.ui.Bouton;

@SuppressWarnings("serial")
public class TableauRestriction extends JFrame {
	// Variables declaration - do not modify
	private Bouton ajouter = new Bouton("Ajouter");
	private javax.swing.JScrollPane jScrollPane2;
	private Bouton modifier = new Bouton("Modifier");
	private Bouton supprimer = new Bouton("Supprimer");
	private javax.swing.JTable table;

	// End of variables declaration

	public TableauRestriction() throws DaoException {
		super();
		this.setMinimumSize(new Dimension(1100, 600));
		this.setTitle("Restrictions");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		java.awt.GridBagConstraints gridBagConstraints;

		jScrollPane2 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridBagLayout());

		ajouter.addActionListener(new addAction());
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 12;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 10);
		getContentPane().add(ajouter, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
		getContentPane().add(supprimer, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
		getContentPane().add(modifier, gridBagConstraints);

		table.setModel(new RestrictionDynModel());
		jScrollPane2.setViewportView(table);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
		gridBagConstraints.gridheight = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
		getContentPane().add(jScrollPane2, gridBagConstraints);

		setVisible(true);
	}

	public static void main(String[] args) {
			try {
				new TableauRestriction();
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public class addAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new AjouterRestrictions();
		}
	}

	public class removeAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
//			int[] selection = table.getSelectedRows();
//			for (int i = selection.length - 1; i >= 0; i--) {
//				try {
//					((MachineDynModel) table.getModel())
//							.remove(selection[i]);
//				} catch (TechnicalException e1) {
//					e1.printStackTrace();
//				}
//			}
		}

	}

	public class addAnomalie implements MouseListener {

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			if (e.getClickCount() == 2) {
				// System.out.println("cocococo");
				Point p = e.getPoint();
				int row = table.rowAtPoint(p);
				int column = table.convertColumnIndexToModel(table
						.columnAtPoint(p));
				System.out.println(table.getModel().getValueAt(row, 0));
			}
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
