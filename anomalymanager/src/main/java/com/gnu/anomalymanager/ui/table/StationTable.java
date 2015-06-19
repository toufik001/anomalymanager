package com.gnu.anomalymanager.ui.table;

import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.modelobject.ModelObject;

@SuppressWarnings("serial")
public class StationTable extends Table {

	@SuppressWarnings("rawtypes")
	public StationTable(ModelObject modelObject) throws DaoException {
		super(modelObject);
	}

}
