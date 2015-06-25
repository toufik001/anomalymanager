package com.gnu.anomalymanager.ui.modelobject;


import com.gnu.anomalymanager.bo.Agent;
import com.gnu.anomalymanager.bo.Station;
import com.gnu.anomalymanager.dao.impl.AgentDaoImpl;
import com.gnu.anomalymanager.dao.impl.StationDaoImpl;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
public final class StationDynModel extends ModelObject<Station> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StationDynModel() throws DaoException {
		init();
	}

	@Override
	protected final Object getObjectAt(int row, int column) {
		switch (column) {
			case 0:
				return this.datas.get(row).getNameStation();
			default:
				return null;
		}
	}

	@Override
	protected String[] getTitles() {
		return new String[]{ "Nom Station"};
	}

}
