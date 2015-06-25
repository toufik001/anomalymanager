package com.gnu.anomalymanager.ui.table;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.manager.AgentManager;
import com.gnu.anomalymanager.ui.modelobject.AgentDynModel;

/**
 * 
 * @author Baz Taoufik
 *
 */
@SuppressWarnings("serial")
@Component
public class AgentTable extends Table {
	
	@Autowired
	private AgentManager agentManager;
	
	public AgentTable() {
		try {
			this.modelObject = new AgentDynModel();
			this.modelObject.setDatas(agentManager.getAll());
			init();
			this.setVisible(true);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param agentManager the agentManager to set
	 */
	public void setAgentManager(AgentManager agentManager) {
		this.agentManager = agentManager;
	}
	
}
