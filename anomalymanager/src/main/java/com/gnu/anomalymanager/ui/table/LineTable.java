package com.gnu.anomalymanager.ui.table;


import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.manager.LineManager;
import com.gnu.anomalymanager.ui.modelobject.LineDynModel;

/**
 * 
 * @author Baz Taoufik
 *
 */
@SuppressWarnings("serial")
public class LineTable extends Table {
	
	private LineManager lineManager;
	
	public LineTable() {
		try {
			this.modelObject = new LineDynModel();
			this.modelObject.setDatas(lineManager.getAll());
			init();
			this.setVisible(true);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
