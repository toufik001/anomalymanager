package com.gnu.anomalymanager.ui.table;

import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.manager.ConductorManager;
import com.gnu.anomalymanager.ui.modelobject.AgentDynModel;
import com.gnu.anomalymanager.ui.modelobject.ConductorDynModel;
import com.gnu.anomalymanager.ui.modelobject.ModelObject;


@SuppressWarnings("serial")
public class ConductorTable extends Table {

	private ConductorManager conductorManager;
	
	public ConductorTable() {
		try {
			this.modelObject = new ConductorDynModel();
			this.modelObject.setDatas(conductorManager.getAll());
			init();
			this.setVisible(true);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
