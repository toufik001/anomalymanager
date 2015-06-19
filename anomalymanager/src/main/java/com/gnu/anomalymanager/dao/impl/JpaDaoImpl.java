/**
 * 
 */
package com.gnu.anomalymanager.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.gnu.anomalymanager.dao.JpaDao;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * @author Baz Taoufik
 * @param <T> entity
 * @param <PK> primary Key
 *
 */
public class JpaDaoImpl<T,PK extends Serializable> implements JpaDao<T, PK> {
	
	protected Class<T> entityClass;
	
	@PersistenceContext(unitName="anomalymanager")
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public JpaDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("anomalymanager");
	    EntityManager em = factory.createEntityManager();
	    setEntityManager(em);
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

	@Override
	public List<T> getAll() throws DaoException {
		List<T> entities = null;
		try {
			entities = entityManager.createQuery("SELECT an FROM " + entityClass.getName() + " an ", entityClass).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
		return entities;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
