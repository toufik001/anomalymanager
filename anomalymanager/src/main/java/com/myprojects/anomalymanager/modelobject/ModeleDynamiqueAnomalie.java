package com.myprojects.anomalymanager.modelobject;

import java.util.List;

import com.myprojects.anomalymanager.bo.Anomaly;
import com.myprojects.anomalymanager.dao.impl.AnomalieDAO;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

@SuppressWarnings("serial")
public class ModeleDynamiqueAnomalie extends ModelObject<Anomaly> {

	private final String entetes[] = { "N� Anomalie", "date Anomalie",
			"Anomalie", "Categorie Anomalie" };

	public ModeleDynamiqueAnomalie(List<Anomaly> anomalies) {
		super(anomalies);
		this.setEntete(entetes);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.getObjets().get(rowIndex).getNumAnomalie();
		case 1:
			return this.getObjets().get(rowIndex).getDateAnomalie();
		case 2:
			return this.getObjets().get(rowIndex).getAnomalie();
		case 3:
			return this.getObjets().get(rowIndex).getCategorieAnomalie();
		default:
			return null;
		}

	}

	public void add(Anomaly anomalie, long num) throws TechnicalException, ObjectNotFoundException {
		new AnomalieDAO().create(anomalie, num);
		this.getObjets().add(anomalie);
		fireTableRowsInserted(this.getObjets().size() - 1, this.getObjets().size() - 1);
	}

	public void remove(int rowIndex) throws TechnicalException {
		new AnomalieDAO().delete((Long) getValueAt(rowIndex, 0));
		this.getObjets().remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

}
