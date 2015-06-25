package com.gnu.anomalymanager.ui.modelobject;

import com.gnu.anomalymanager.bo.Conductor;
import com.gnu.anomalymanager.bo.Line;
import com.gnu.anomalymanager.bo.Machine;
import com.gnu.anomalymanager.bo.Train;
import com.gnu.anomalymanager.dao.impl.TrainDaoImpl;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
@SuppressWarnings("serial")
public class TrainDynModel extends ModelObject<Train> {

	public TrainDynModel() throws DaoException {
		init();
	}
	@Override
	protected Object getObjectAt(int row, int column) {
		switch (column) {
			case 0:
				return this.datas.get(row).getMatTrain();
			case 1:
				Machine m = this.datas.get(row).getMachine();
				return m != null? m.getMatMachine() : null;
			case 2:
				Conductor c = this.datas.get(row).getConducteur();
				return c != null? c.getMatConducteur() : null;
			case 3:
				Line l = this.datas.get(row).getLine();
				return l != null? l.getRefLine() : null;
			default:
				return null;
		}
	}

	@Override
	protected String[] getTitles() {
		return new String[]{"matTrain", "machine", "conducteur", "line"};
	}


}
