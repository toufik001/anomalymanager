package com.gnu.anomalymanager.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gnu.anomalymanager.bo.Anomaly;
import com.gnu.anomalymanager.dao.AnomalyDao;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
public class AnomalyDaoImpl extends JpaDaoImpl<Anomaly, Long> implements AnomalyDao {

	public static void main(String[] args) {
			AnomalyDaoImpl dao = new AnomalyDaoImpl();
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("anomalymanager");
		    EntityManager em = factory.createEntityManager();
		    dao.setEntityManager(em);
			List<Anomaly> anomalies = null;
			try {
				dao.getEntityManager().getTransaction().begin();
				for (int i = 0; i < 100; i++) {
					System.out.println(dao.persist(new Anomaly("refAnomaly"+i*100, new Date(), "description" + i*100, "category"+100*i)));
				}
				dao.getEntityManager().flush();
				dao.getEntityManager().getTransaction().commit();
				
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
