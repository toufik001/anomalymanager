package com.gnu.anomalymanager.ui.modelobject;


import com.gnu.anomalymanager.bo.Agent;
import com.gnu.anomalymanager.dao.impl.AgentDaoImpl;
import com.gnu.anomalymanager.dao.impl.AnomalyDaoImpl;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
public final class AgentDynModel extends ModelObject<Agent, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgentDynModel() throws DaoException {
		jpaDao = new AgentDaoImpl();
		init();
	}

	@Override
	protected final Object getObjectAt(int row, int column) {
		switch (column) {
			case 0:
				return this.datas.get(row).getMatAgent();
			case 1:
				return this.datas.get(row).getName();
			case 2:
				return this.datas.get(row).getPoste();
			case 3:
				return this.datas.get(row).getAffectation();
			default:
				return null;
		}
	}

	@Override
	protected String[] getTitles() {
		return new String[]{ "MatAgent", "Name", "Poste", "Affectation" };
	}

}
