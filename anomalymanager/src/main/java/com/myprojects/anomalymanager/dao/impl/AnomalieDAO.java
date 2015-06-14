package com.myprojects.anomalymanager.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.myprojects.anomalymanager.bo.Anomaly;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

public class AnomalieDAO extends DAO<Anomaly> {

	@Override
	public void create(Anomaly obj, long num) throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("insert into anomalie(numMachine,dateAnomalie,anomalie,categorie) values(?,?,?,?)");
			SimpleDateFormat fd = new SimpleDateFormat();
			String dateString = fd.format(obj.getDateAnomalie());
			prst.setLong(1, num);
			prst.setString(2, dateString);
			prst.setString(3, obj.getAnomalie());
			prst.setString(4, obj.getCategorieAnomalie());
			prst.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	@Override
	public void delete(long num) throws TechnicalException {
		try {
			this.connection.prepareStatement(
					"delete from anomalie where numAnomalie=" + num)
					.executeUpdate();

		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	@Override
	public Anomaly find(long num) throws ObjectNotFoundException,
			TechnicalException {
		Anomaly anomalie = null;
		try {
			ResultSet prst = this.connection.prepareStatement(
					"select * from anomalie where numAnomalie=" + num)
					.executeQuery();
			if (prst.next()) {
				anomalie = new Anomaly(num, prst.getDate("dateAnomalie"), prst
						.getString("anomalie"), prst.getString("categorie"),
						new ReparationDAO().getAllByNum(num));

			} else
				throw new ObjectNotFoundException();

		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return anomalie;
	}

	@Override
	public Anomaly update(Anomaly obj) throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("update anomalie set  dateAnomalie=?,anomalie=? ,categorie=? where numAnomalie=?");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(obj.getDateAnomalie());
			prst.setString(1, date);
			prst.setString(2, obj.getAnomalie());
			prst.setString(3, obj.getCategorieAnomalie());
			prst.setLong(4, obj.getNumAnomalie());
			prst.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return obj;
	}

	@Override
	// retourne tous les anomalies d'une machine
	public ArrayList<Anomaly> getAllByNum(long numMachine)
			throws TechnicalException, ObjectNotFoundException {
		ArrayList<Anomaly> anomalies = null;
		try {
			ResultSet res = this.connection.prepareStatement(
					"select * from anomalie where numMachine=" + numMachine)
					.executeQuery();
			while (res.next()) {
				anomalies = new ArrayList<Anomaly>();
				ReparationDAO repar = new ReparationDAO();
				Anomaly anomalie = new Anomaly(res.getLong("numAnomalie"),
						res.getDate("dateAnomalie"), res.getString("anomalie"),
						res.getString("categorie"), repar.getAllByNum(res
								.getLong("numAnomalie")));
				anomalies.add(anomalie);
			}
			if (anomalies == null)
				throw new ObjectNotFoundException();
		} catch (SQLException e) {
			throw new TechnicalException();
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException();
		}
		return anomalies;
	}

	@Override
	public long getNum() throws TechnicalException, ObjectNotFoundException {
		try {
			ResultSet prst = this.connection.prepareStatement(
					"select numAnomalie from Anomalie").executeQuery();
			if (prst.last())
				return prst.getLong("numAnomalie");
			else
				throw new ObjectNotFoundException();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	public ArrayList<Anomaly> getAll() throws TechnicalException,
			ObjectNotFoundException {
		// ArrayList<Anomalie> anomalies = null;
		try {
			ResultSet res = this.connection.prepareStatement(
					"select * from anomalie").executeQuery();
			ArrayList<Anomaly> anomalies = new ArrayList<Anomaly>();
			while (res.next()) {
				Anomaly anomalie = new Anomaly(res.getLong("numAnomalie"),
						res.getDate("dateAnomalie"), res.getString("anomalie"),
						res.getString("categorie"));
				anomalies.add(anomalie);
			}
			if (anomalies == null) {
				throw new ObjectNotFoundException();
			}
			return anomalies;
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	// 8-3
	public static void main(String[] args) {
		// Date date = new Date();
		AnomalieDAO anom = new AnomalieDAO();
		ArrayList<Anomaly> anomalies = new ArrayList<Anomaly>();
		try {
			anomalies = anom.getAll();
			System.out.println(anomalies.size());
			for (Anomaly anomalie : anomalies) {
				System.out.println(anomalie.toString());
			}
		} catch (TechnicalException e) {
			// TODO Auto-generated catch block
			System.out.println("hhhhhhhh");
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("kkkkkkkkkkkkkk");
		}
	}

}
