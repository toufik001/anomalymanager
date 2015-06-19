package com.gnu.anomalymanager.modelobject;


import com.gnu.anomalymanager.bo.Anomaly;
import com.gnu.anomalymanager.dao.impl.AnomalyDaoImpl;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
public final class AnomalyDynModel extends ModelObject<Anomaly, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnomalyDynModel() throws DaoException {
		jpaDao = new AnomalyDaoImpl();
		init();
	}

	@Override
	protected final Object getObjectAt(int row, int column) {
		switch (column) {
			case 0:
				return this.datas.get(row).getRefAnomaly();
			case 1:
				return this.datas.get(row).getDate();
			case 2:
				return this.datas.get(row).getDescription();
			case 3:
				return this.datas.get(row).getCategory();
			default:
				return null;
		}
	}

	@Override
	protected String[] getTitles() {
		return new String[]{ "Ref", "Date", "Description", "Categorie" };
	}

}
