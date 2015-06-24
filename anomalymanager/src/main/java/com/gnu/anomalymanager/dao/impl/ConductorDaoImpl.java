package com.gnu.anomalymanager.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gnu.anomalymanager.bo.Anomaly;
import com.gnu.anomalymanager.bo.Conductor;
import com.gnu.anomalymanager.dao.ConductorDao;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
public class ConductorDaoImpl extends JpaDaoImpl<Conductor, Long> implements ConductorDao {

	public static void main(String[] args) {
		ConductorDaoImpl dao = new ConductorDaoImpl();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("anomalymanager");
	    EntityManager em = factory.createEntityManager();
	    dao.setEntityManager(em);
		List<Anomaly> anomalies = null;
		try {
			dao.getEntityManager().getTransaction().begin();
			for (int i = 0; i < 100; i++) {
				System.out.println(dao.persist(new Conductor("matConducteur"+i, "name"+i, "affectation"+i)));
			}
			dao.getEntityManager().flush();
			dao.getEntityManager().getTransaction().commit();
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
