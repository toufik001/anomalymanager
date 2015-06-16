package com.myprojects.anomalymanager.modelobject;

import java.awt.Component;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.myprojects.anomalymanager.bo.Machine;
import com.myprojects.anomalymanager.dao.impl.MachineDaoImpl;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

@SuppressWarnings("serial")
public class ModeleDynamiqueMachine extends ModelObject<Machine> {

	private final String entetes[] = { "N� Machine", "Serie", "Restrictions",
			"Anomalies" };

	public ModeleDynamiqueMachine(List<Machine> machines) {
		super(machines);
		this.setEntete(entetes);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.getObjets().get(rowIndex).getNumMachine();
		case 1:
			return this.getObjets().get(rowIndex).getSerie();
		case 2:
			return new JButton("Restrictions");
		case 3:
			return new JButton("Anomalies");
		default:
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public Class getColumnClass(int col) {

		return this.getValueAt(0, col).getClass();
	}

	// Retourne vrai si la cellule est �ditable : celle-ci sera donc �ditable
	public boolean isCellEditable(int row, int col) {
		// On appelle la m�thode getValueAt qui retourne la valeur d'une cellule
		// et on effectue un traitement sp�cifique si c'est un JButton
		if (getValueAt(0, col) instanceof JButton)
			return false;
		return true ;
	}

	public void add(Machine machine, long num) throws TechnicalException,
			ObjectNotFoundException {
		MachineDaoImpl dao = new MachineDaoImpl();
		dao.create(machine, num);
		this.getObjets().add(
				new Machine(new MachineDaoImpl().getNum(), machine.getSerie()));
		fireTableRowsInserted(this.getObjets().size() - 1, this.getObjets()
				.size() - 1);
	}

	public void remove(int rowIndex) throws TechnicalException {
		MachineDaoImpl dao = new MachineDaoImpl();
		dao.delete((Long) getValueAt(rowIndex, 0));
		this.getObjets().remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

}
