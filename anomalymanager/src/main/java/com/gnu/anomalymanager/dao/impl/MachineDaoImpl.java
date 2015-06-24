package com.gnu.anomalymanager.dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gnu.anomalymanager.bo.Machine;
import com.gnu.anomalymanager.dao.MachineDao;
import com.gnu.anomalymanager.exception.DaoException;

/**
 * 
 * @author Baz Taoufik
 *
 */
public class MachineDaoImpl extends JpaDaoImpl<Machine, Long> implements MachineDao {
	public static void main(String[] args) {
		MachineDaoImpl dao = new MachineDaoImpl();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("anomalymanager");
	    EntityManager em = factory.createEntityManager();
	    dao.setEntityManager(em);
		
		try {
			dao.getEntityManager().getTransaction().begin();
			for (int i = 0; i < 100; i++) {
				System.out.println(dao.persist(new Machine("matMachine"+i, "serie"+i)));
			}
			dao.getEntityManager().flush();
			dao.getEntityManager().getTransaction().commit();
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
