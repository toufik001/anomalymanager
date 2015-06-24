/**
 * 
 */
package com.gnu.anomalymanager.manager;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.gnu.anomalymanager.exception.DaoException;

/**
 * @author Baz Taoufik
 *
 */
public interface SimpleManager<T, ID extends Serializable> {

	public T save(T obj) throws DaoException;
	
	public void delete(T obj) throws DaoException;
	
	public T findById(ID id) throws EntityNotFoundException, DaoException;
	
	public List<T> getAll() throws DaoException;
	
	public void update(T obj) throws DaoException;
}
