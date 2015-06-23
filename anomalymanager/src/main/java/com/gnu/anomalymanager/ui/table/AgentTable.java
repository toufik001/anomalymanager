package com.gnu.anomalymanager.ui.table;


import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.ui.modelobject.ModelObject;

/**
 * 
 * @author Baz Taoufik
 *
 */
@SuppressWarnings("serial")
public class AgentTable extends Table {

	@SuppressWarnings("rawtypes")
	public AgentTable(ModelObject modelObject) throws DaoException {
		super(modelObject);
	}
	
}
