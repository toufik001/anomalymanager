package com.gnu.anomalymanager.modelobject;

import com.gnu.anomalymanager.bo.Line;
import com.gnu.anomalymanager.dao.impl.LineDaoImpl;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
public final class LineDynModel extends ModelObject<Line, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LineDynModel() throws DaoException {
		jpaDao = new LineDaoImpl();
		init();
	}

	@Override
	protected final Object getObjectAt(int row, int column) {
		switch (column) {
			case 0:
				return this.datas.get(row).getRefLine();
			case 1:
				return this.datas.get(row).getStartDate();
			case 2:
				return this.datas.get(row).getEndDate();
			default:
				return null;
		}
	}

	@Override
	protected String[] getTitles() {
		return new String[]{ "RefLine", "StartDate", "EndDate"};
	}

}
