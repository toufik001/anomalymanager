package com.gnu.anomalymanager.ui.table;


import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.manager.AgentManager;
import com.gnu.anomalymanager.ui.modelobject.ModelObject;

/**
 * 
 * @author Baz Taoufik
 *
 */
@SuppressWarnings("serial")
public class AgentTable extends Table {

	private AgentManager agentManager;
	
	@SuppressWarnings("rawtypes")
	public AgentTable(ModelObject modelObject) throws DaoException {
		super(modelObject);
	}

	/**
	 * @param agentManager the agentManager to set
	 */
	public void setAgentManager(AgentManager agentManager) {
		this.agentManager = agentManager;
	}
	
	
}
