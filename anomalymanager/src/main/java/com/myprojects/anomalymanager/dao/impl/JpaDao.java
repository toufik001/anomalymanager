/**
 * 
 */
package com.myprojects.anomalymanager.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.myprojects.anomalymanager.dao.GenericDao;
import com.myprojects.anomalymanager.exception.DaoException;

/**
 * @author Baz Taoufik
 * @param <T> entity
 * @param <PK> primary Key
 *
 */
public class JpaDao<T,PK extends Serializable> implements GenericDao<T, PK> {
	
	protected Class<T> entityClass;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public JpaDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@Override
	public T persist(T entity) throws DaoException {
		try {
			entityManager.persist(entity);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		
		return entity;
	}

	@Override
	public void remove(T entity) throws DaoException {
		try {
			entityManager.remove(entity);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public T findById(PK id) throws DaoException, EntityNotFoundException {
		T entity = null;
		try {
			entity = entityManager.find(entityClass, id);
			if (entity == null) {
				throw new EntityNotFoundException();
			}
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return entity;
	}

	@Override
	public void update(T entity) throws DaoException {
		try {
			entityManager.merge(entity);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() throws DaoException {
		List<T> entities = null;
		try {
			entities = (List<T>) entityManager.createQuery("SELECT e FROM " + entityClass.getName() + "e");
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return entities;
	}

}
