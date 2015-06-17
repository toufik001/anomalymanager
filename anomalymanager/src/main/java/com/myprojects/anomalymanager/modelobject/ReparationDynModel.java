package com.myprojects.anomalymanager.modelobject;

import com.myprojects.anomalymanager.bo.Reparation;
import com.myprojects.anomalymanager.dao.impl.ReparationDaoImpl;
import com.myprojects.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
@SuppressWarnings("serial")
public class ReparationDynModel extends ModelObject<Reparation, Long> {

	public ReparationDynModel() throws DaoException {
		jpaDao = new ReparationDaoImpl();
		init();
	}
	
	@Override
	protected Object getObjectAt(int row, int column) {
		switch (column) {
			case 0:
				return this.datas.get(row).getRefReparation();
			case 1:
				return this.datas.get(row).getDateReparation();
			case 2:
				return this.datas.get(row).getDescription();
			default:
				return null;
		}
	}

	@Override
	protected String[] getTitles() {
		return new String[]{"refReparation", "dateReparation", "description"};
	}

}
