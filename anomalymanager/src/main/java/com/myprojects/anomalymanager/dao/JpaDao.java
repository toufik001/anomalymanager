package com.myprojects.anomalymanager.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.myprojects.anomalymanager.exception.DaoException;


public interface JpaDao<T, PK extends Serializable> {

	/**
	 * 
	 * @param entity
	 * @return entity
	 * @throws DaoException
	 */
	public T persist(T entity) throws DaoException;
	
	/**
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void remove(T entity) throws DaoException;
	
	/**
	 * 
	 * @param id
	 * @return entity
	 * @throws DaoException
	 * @throws EntityNotFoundException
	 */
	public T findById(PK id) throws DaoException, EntityNotFoundException;
	
	/**
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void update(T entity) throws DaoException;
	
	/**
	 * 
	 * @return list of entities
	 * @throws DaoException
	 */
	public List<T> getAll() throws DaoException;

}
