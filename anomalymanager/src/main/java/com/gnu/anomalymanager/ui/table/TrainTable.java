package com.gnu.anomalymanager.ui.table;

import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.ui.modelobject.ModelObject;
import com.gnu.anomalymanager.ui.modelobject.TrainDynModel;

/**
 * 
 * @author Baz Taoufik
 *
 */
@SuppressWarnings("serial")
public class TrainTable extends Table {

	public TrainTable(ModelObject modelObject) throws DaoException {
		super(modelObject);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		try {
			new TrainTable(new TrainDynModel());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
