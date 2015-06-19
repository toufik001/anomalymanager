package com.gnu.anomalymanager.modelobject;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

import com.gnu.anomalymanager.dao.JpaDao;
import com.gnu.anomalymanager.dao.impl.JpaDaoImpl;
import com.gnu.anomalymanager.exception.DaoException;


/**
 * 
 * @author Baz Taoufik
 *
 */
public abstract class ModelObject<T extends Serializable,PK extends Serializable> extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	protected JpaDao<T, PK> jpaDao;

	/**
	 * 
	 */
	protected List<T> datas;
	
	/**
	 * 
	 */
	protected String[] header;

	@Override
	public int getColumnCount() {
		if (header != null) {
			return header.length;
		}
		return 0;
	}

	@Override
	public int getRowCount() {
		if (datas != null) {
			return datas.size();
		}
		return 0;
	}

	@Override
	public final Object getValueAt(int row, int column) {
		return isEmptyRow(row)? null : getObjectAt(row, column);
	}

	/**
	 * 
	 * @param row
	 * @return boolean true if row is empty 
	 */
	private boolean isEmptyRow(int row) {
		if (datas != null) {
			return this.datas.get(row) != null ? false : true;
		}
		return true;
	}

	/**
	 * return name of column
	 */
	public String getColumnName(int columnIndex){
		return header[columnIndex];
	}
	
	/**
	 * 
	 * @param objToAdd
	 * @throws DaoException
	 */
	public void add(T objToAdd) throws DaoException {
		jpaDao.persist(objToAdd);
		refresh();
	}

	/**
	 * 
	 * @param objToRemove
	 * @throws DaoException
	 */
	public void remove(T objToRemove) throws DaoException {
		jpaDao.remove(objToRemove);
		refresh();
	}

	/**
	 * 
	 * @param objToUpdate
	 * @throws DaoException
	 */
	public void update(T objToUpdate) throws DaoException {
		jpaDao.update(objToUpdate);
		refresh();
	}

	/**
	 * 
	 * @throws DaoException
	 */
	public void refresh() throws DaoException {
		datas = jpaDao.getAll();
		fireTableDataChanged();
	}
	
	/**
	 * 
	 * @throws DaoException
	 */
	protected void init() throws DaoException {
		datas = jpaDao.getAll();
		header = getTitles();
	}
	
	/**
	 * 
	 * @param row
	 * @param column
	 * @return Object field 
	 */
	protected abstract Object getObjectAt(int row, int column);
	
	/**
	 * 
	 * @return String[] titles
	 */
	protected abstract String[] getTitles();
	

}