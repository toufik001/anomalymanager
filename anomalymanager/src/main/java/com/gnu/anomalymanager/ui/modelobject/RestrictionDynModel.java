package com.gnu.anomalymanager.ui.modelobject;

import com.gnu.anomalymanager.bo.Restriction;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
@SuppressWarnings("serial")
public class RestrictionDynModel extends ModelObject<Restriction> {

	public RestrictionDynModel() throws DaoException {
		init();
	}
	
	@Override
	protected Object getObjectAt(int row, int column) {
		switch (column) {
			case 0:
				return this.datas.get(row).getRefRestriction();
			case 1:
				return this.datas.get(row).getDescription();
			default:
				return null;
		}
	}

	@Override
	protected String[] getTitles() {
		return new String[]{"refRestriction", "description"};
	}

}
