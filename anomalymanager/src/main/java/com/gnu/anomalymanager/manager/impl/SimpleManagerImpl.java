/**
 * 
 */
package com.gnu.anomalymanager.manager.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;

import com.gnu.anomalymanager.dao.JpaDao;
import com.gnu.anomalymanager.exception.DaoException;
import com.gnu.anomalymanager.manager.SimpleManager;

/**
 * @author Baz Taoufik
 *
 */
@Transactional
public class SimpleManagerImpl<T, ID extends Serializable> implements SimpleManager<T, ID> {

	protected JpaDao<T, ID> jpaDao;

	@Override
	public T save(T obj) throws DaoException {
		return jpaDao.persist(obj);
	}

	@Override
	public void delete(T obj) throws DaoException {
		jpaDao.remove(obj);
		
	}

	@Override
	public T findById(ID id) throws EntityNotFoundException, DaoException {
		return jpaDao.findById(id);
	}

	@Override
	public List<T> getAll() throws DaoException {
		return jpaDao.getAll();
	}

	@Override
	public void update(T obj) throws DaoException {
		jpaDao.update(obj);
	}

	/**
	 * @return the jpaDao
	 */
	public JpaDao<T, ID> getJpaDao() {
		return jpaDao;
	}
	
	

}
