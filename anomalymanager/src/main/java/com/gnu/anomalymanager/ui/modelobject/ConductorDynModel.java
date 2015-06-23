package com.gnu.anomalymanager.ui.modelobject;

import com.gnu.anomalymanager.bo.Conductor;

/**
 * 
 * @author Baz Taoufik
 *
 */
public class ConductorDynModel extends ModelObject<Conductor, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Object getObjectAt(int row, int column) {
		switch (column) {
			case 0:
				return this.datas.get(row).getMatConducteur();
			case 1:
				return this.datas.get(row).getName();
			case 2:
				return this.datas.get(row).getAffectation();
			default:
				return null;
		}
	}

	@Override
	protected String[] getTitles() {
		return new String[]{"matConducteur", "name", "affectation"};
	}


}
