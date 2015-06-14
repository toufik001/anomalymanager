package com.myprojects.anomalymanager.modelobject;


import java.util.List;

import com.myprojects.anomalymanager.bo.Restriction;
import com.myprojects.anomalymanager.dao.impl.RestrictionDAO;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

@SuppressWarnings("serial")
public class ModeleDynamiqueRestriction extends ModelObject<Restriction> {

	private final String entetes[] = { "N� Restriction", "restriction" };

	public ModeleDynamiqueRestriction(List<Restriction> restrictions) {
		super(restrictions);
		this.setEntete(entetes);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.getObjets().get(rowIndex).getNumRestriction();
		case 1:
			return this.getObjets().get(rowIndex).getDescription();

		default:
			return null;
		}

	}

	public void add(Restriction restriction, long num)
			throws TechnicalException, ObjectNotFoundException {
		RestrictionDAO dao = new RestrictionDAO();
		dao.create(restriction, num);
		this.getObjets().add(restriction);
		fireTableRowsInserted(this.getObjets().size() - 1, this.getObjets()
				.size() - 1);
	}

	public void remove(int rowIndex) throws TechnicalException {
		RestrictionDAO dao = new RestrictionDAO();
		dao.delete((Long) getValueAt(rowIndex, 0));
		this.getObjets().remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
}
