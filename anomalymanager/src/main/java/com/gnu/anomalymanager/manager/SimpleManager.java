package com.gnu.anomalymanager.manager;

import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 * @param <T>
 */
public interface SimpleManager<T> {
	
	/**
	 * 
	 * @param objToAdd
	 * @throws DaoException
	 */
	public void add(T objToAdd) throws DaoException;

	/**
	 * 
	 * @param objToRemove
	 * @throws DaoException
	 */
	public void remove(T objToRemove) throws DaoException;

	/**
	 * 
	 * @param objToUpdate
	 * @throws DaoException
	 */
	public void update(T objToUpdate) throws DaoException;

	/**
	 * 
	 * @throws DaoException
	 */
	public void refresh() throws DaoException;
	
}
