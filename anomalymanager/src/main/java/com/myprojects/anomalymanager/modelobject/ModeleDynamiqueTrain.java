package com.myprojects.anomalymanager.modelobject;



import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.myprojects.anomalymanager.bo.Train;
import com.myprojects.anomalymanager.dao.impl.TrainDaoImpl;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

@SuppressWarnings("serial")
public class ModeleDynamiqueTrain extends ModelObject<Train> {
	private List<Train> trains = new ArrayList<Train>();
	private final String entetes[] = { "N� Train", "Date Depart",
			"Date Arrive", "Gare Depart", "Gare Arrive", "N� Conducteur",
			"Machine" };

	public ModeleDynamiqueTrain(List<Train> trains) {
		super();

		for (Train train : trains) {
			this.trains.add(train);
		}
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return trains.size();
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return trains.get(rowIndex).getNumTrain();
		case 1:
			return trains.get(rowIndex).getDateDepart();
		case 2:
			return trains.get(rowIndex).getDateArrive();
		case 3:
			return trains.get(rowIndex).getGareDepart();
		case 4:
			return trains.get(rowIndex).getGareArrive();
		case 5:
			return trains.get(rowIndex).getConducteur().getNumConducteur();
		case 6:
			return trains.get(rowIndex).getMachine().getNumMachine();
		default:
			return null;
		}

	}

	public void add(Train train, long num) throws TechnicalException,
			ObjectNotFoundException {
		new TrainDaoImpl().create(train, num);
		trains.add(train);
		fireTableRowsInserted(trains.size() - 1, trains.size() - 1);
	}

	public void remove(int rowIndex) throws TechnicalException {
		new TrainDaoImpl().delete((Long) getValueAt(rowIndex, 0));
		trains.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

}
