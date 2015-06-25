package com.gnu.anomalymanager.ui.table;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.manager.AnomalyManager;
import com.gnu.anomalymanager.ui.modelobject.AgentDynModel;
import com.gnu.anomalymanager.ui.modelobject.AnomalyDynModel;

@SuppressWarnings("serial")
@Component
public class AnomalyTable extends Table {

	@Autowired
	private AnomalyManager anomalyManager;
	
	public AnomalyTable() {
		try {
			this.modelObject = new AnomalyDynModel();
			this.modelObject.setDatas(anomalyManager.getAll());
			init();
			this.setVisible(true);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	/**
	 * @param anomalyManager the anomalyManager to set
	 */
	public void setAnomalyManager(AnomalyManager anomalyManager) {
		this.anomalyManager = anomalyManager;
	}
	
}
