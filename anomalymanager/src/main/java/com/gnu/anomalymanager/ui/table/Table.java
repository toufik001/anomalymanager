/**
 * 
 */
package com.gnu.anomalymanager.ui.table;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.modelobject.ModelObject;
import com.gnu.anomalymanager.ui.Bouton;

/**
 * @author Baz Taoufik
 *
 */
public abstract class Table extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Variables declaration - do not modify
	private Bouton addButton = new Bouton("Ajouter");
	private Bouton editButton = new Bouton("Modifier");
	private Bouton deleteButton = new Bouton("Supprimer");
	private javax.swing.JScrollPane jScrollPane2;

	private javax.swing.JTable table;

	// End of variables declaration

	@SuppressWarnings("rawtypes")
	public Table(ModelObject modelObject) throws DaoException {
		super();
		this.setMinimumSize(new Dimension(1100, 600));
		this.setTitle("Anomalies");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		java.awt.GridBagConstraints gridBagConstraints;

		jScrollPane2 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridBagLayout());

		addButton.addActionListener(new addAction());
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 12;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 10);
		getContentPane().add(addButton, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
		getContentPane().add(deleteButton, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
		getContentPane().add(editButton, gridBagConstraints);

		table.setModel(modelObject);
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

	public class addAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {

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
//			if (e.getClickCount() == 2) {
//				// System.out.println("cocococo");
//				Point p = e.getPoint();
//				int row = table.rowAtPoint(p);
//				int column = table.convertColumnIndexToModel(table
//						.columnAtPoint(p));
//				System.out.println(table.getModel().getValueAt(row, 0));
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
