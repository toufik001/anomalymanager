package com.myprojects.anomalymanager.modelobject;

import java.util.List;

import com.myprojects.anomalymanager.bo.Reparation;
import com.myprojects.anomalymanager.dao.impl.MachineDaoImpl;
import com.myprojects.anomalymanager.dao.impl.ReparationDaoImpl;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

@SuppressWarnings("serial")
public class ModeleDynamiqueReparation extends ModelObject<Reparation> {

	private final String entetes[] = { "N� Machine", "date reparation",
			"description" };

	public ModeleDynamiqueReparation(List<Reparation> reparations) {
		super(reparations);
		this.setEntete(entetes);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.getObjets().get(rowIndex).getNumReparation();
		case 1:
			return this.getObjets().get(rowIndex).getDateReparation();
		case 2:
			return this.getObjets().get(rowIndex).getDescription();
		default:
			return null;
		}

	}

	public void add(Reparation reparation, long num) throws TechnicalException,
			ObjectNotFoundException {
		ReparationDaoImpl dao = new ReparationDaoImpl();
		dao.create(reparation, num);
		this.getObjets().add(reparation);
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
