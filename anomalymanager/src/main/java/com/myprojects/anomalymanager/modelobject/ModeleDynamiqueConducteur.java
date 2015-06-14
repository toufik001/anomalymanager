package com.myprojects.anomalymanager.modelobject;


import java.util.ArrayList;
import java.util.List;

import com.myprojects.anomalymanager.bo.Conductor;
import com.myprojects.anomalymanager.dao.impl.ConducteurDAO;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

@SuppressWarnings("serial")
public class ModeleDynamiqueConducteur extends ModelObject<Conductor> {
	private List<Conductor> conducteurs = new ArrayList<Conductor>();
	private final String entetes[] = { "N� Conducteur", "Matricule", "Nom",
			"Prenom", "Affectation" };

	public ModeleDynamiqueConducteur(List<Conductor> conducteurs) {
		super();

		for (Conductor conducteur : conducteurs) {
			this.conducteurs.add(conducteur);
		}
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return conducteurs.size();
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return conducteurs.get(rowIndex).getNumConducteur();
		case 1:
			return conducteurs.get(rowIndex).getMatConducteur();
		case 2:
			return conducteurs.get(rowIndex).getNom();
		case 3:
			return conducteurs.get(rowIndex).getPrenom();
		case 4:
			return conducteurs.get(rowIndex).getAffectation();
		default:
			return null;
		}

	}

	public void addConducteur(Conductor conducteur, long num)
			throws TechnicalException, ObjectNotFoundException {
		new ConducteurDAO().create(conducteur, num);
		conducteurs.add(conducteur);
		fireTableRowsInserted(conducteurs.size() - 1, conducteurs.size() - 1);
	}

	public void removeConducteur(int rowIndex) throws TechnicalException {
		new ConducteurDAO().delete((Long) getValueAt(rowIndex, 0));
		conducteurs.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

}
