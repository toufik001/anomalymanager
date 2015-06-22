package com.gnu.anomalymanager.manager.impl;

import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.manager.SimpleManager;

/**
 * 
 * @author Baz Taoufik
 *
 * @param <T>
 */
public class SimpleManagerImpl<T> implements SimpleManager<T> {
	
	/**
	 * 
	 * @param objToAdd
	 * @throws DaoException
	 */
	public void add(T objToAdd) throws DaoException {
		
	}

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
