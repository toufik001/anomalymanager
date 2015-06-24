package com.gnu.anomalymanager.dao.impl;


import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gnu.anomalymanager.bo.Reparation;
import com.gnu.anomalymanager.dao.ReparationDao;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
public class ReparationDaoImpl extends JpaDaoImpl<Reparation, Long> implements ReparationDao {

	public static void main(String[] args) {
		ReparationDaoImpl dao = new ReparationDaoImpl();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("anomalymanager");
	    EntityManager em = factory.createEntityManager();
	    dao.setEntityManager(em);
		try {
			dao.getEntityManager().getTransaction().begin();
			for (int i = 0; i < 100; i++) {
				System.out.println(dao.persist(new Reparation("refReparation"+i, new Date(), "description"+i)));
			}
			dao.getEntityManager().flush();
			dao.getEntityManager().getTransaction().commit();
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
