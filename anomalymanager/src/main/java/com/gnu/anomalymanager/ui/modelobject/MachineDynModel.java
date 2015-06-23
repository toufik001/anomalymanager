package com.gnu.anomalymanager.ui.modelobject;

import com.gnu.anomalymanager.bo.Machine;
import com.gnu.anomalymanager.dao.impl.MachineDaoImpl;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
@SuppressWarnings("serial")
public class MachineDynModel extends ModelObject<Machine, Long> {

	public MachineDynModel() throws DaoException {
		jpaDao = new MachineDaoImpl();
		init();
	}
	
	@Override
	protected Object getObjectAt(int row, int column) {
		switch (column) {
			case 0:
				return this.datas.get(row).getMatMachine();
			case 1:
				return this.datas.get(row).getSerie();
			default:
				return null;
		}
	}

	@Override
	protected String[] getTitles() {
		return new String[]{"matMachine", "serie"};
	}

}
