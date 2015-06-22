package com.gnu.anomalymanager.manager.impl;

import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.manager.SimpleManager;

/**
 * 
 * @author Baz Taoufik
 *
 * @param <T>
 */
public abstract class SimpleManagerImpl<T> implements SimpleManager<T> {
	
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
	public abstract void remove(T objToRemove) throws DaoException;

	/**
	 * 
	 * @param objToUpdate
	 * @throws DaoException
	 */
	public abstract void update(T objToUpdate) throws DaoException;

	/**
	 * 
	 * @throws DaoException
	 */
	public abstract void refresh() throws DaoException;
	
}
