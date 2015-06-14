package com.myprojects.anomalymanager.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.myprojects.anomalymanager.bo.Reparation;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

public class ReparationDAO extends DAO<Reparation> {

	@Override
	public void create(Reparation reparation, long numAnomalie)
			throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("insert into reparation(numAnomalie,dateReparation,description) values(?,?,?)");
			SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
			String date = fd.format(reparation.getDateReparation());
			prst.setLong(1, numAnomalie);
			prst.setString(2, date);
			prst.setString(3, reparation.getDescription());

			prst.executeUpdate();

		} catch (SQLException e) {
			throw new TechnicalException();

		}

	}

	@Override
	public void delete(long num) throws TechnicalException {
		try {
			this.connection.prepareStatement(
					"delete from reparation where numReparation=" + num)
					.executeUpdate();

		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	@Override
	public Reparation find(long num) throws TechnicalException,
			ObjectNotFoundException {
		Reparation reparation = null;
		try {
			ResultSet prst = this.connection.prepareStatement(
					"select * from reparation where numReparation=" + num)
					.executeQuery();
			if (prst.next()) {
				reparation = new Reparation(num,
						prst.getDate("dateReparation"), prst
								.getString("description"));
			} else
				throw new ObjectNotFoundException();

		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return reparation;
	}

	@Override
	public Reparation update(Reparation obj) throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("update reparation set dateReparation=?,description=? where numReparation=?");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(obj.getDateReparation());
			prst.setString(1, date);
			prst.setString(2, obj.getDescription());
			prst.setLong(3, obj.getNumReparation());
			prst.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return obj;
	}

	@Override
	// retourne tous les anomalies d'une machine
	public ArrayList<Reparation> getAllByNum(long numAnomalie)
			throws TechnicalException, ObjectNotFoundException {
		ArrayList<Reparation> reparations = null;
		try {
			ResultSet res = this.connection
					.prepareStatement(
							"select * from reparation where numAnomalie="
									+ numAnomalie).executeQuery();
			while (res.next()) {
				reparations = new ArrayList<Reparation>();
				Reparation reparation = new Reparation(res
						.getLong("numReparation"), res
						.getDate("dateReparation"), res
						.getString("description"));
				reparations.add(reparation);
			}
			if (reparations == null)
				throw new ObjectNotFoundException();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return reparations;
	}

	@Override
	public long getNum() throws TechnicalException {
		try {
			ResultSet res = this.connection.prepareStatement(
					"select numReparation from reparation").executeQuery();
			if (res.last())
				return res.getLong("numReparation");
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return 0;

	}

	public static void main(String[] args) {
		ReparationDAO rep = new ReparationDAO();
		Date date = new Date();
		Reparation reparation = new Reparation(1, date, "coucoucoucou");
		try {
			rep.update(reparation);
			rep.create(reparation, 3);
			System.out.println(rep.getNum());

			System.out.println("num: " + reparation.getNumReparation()
					+ " date: " + reparation.getDateReparation()
					+ " description: " + reparation.getDescription());
		} catch (TechnicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Reparation> getAll() throws TechnicalException,
			ObjectNotFoundException {
		try {
			ResultSet res = this.connection.prepareStatement(
					"select * from reparation").executeQuery();
			ArrayList<Reparation> reparations = new ArrayList<Reparation>();
			while (res.next()) {
				Reparation reparation = new Reparation(res
						.getLong("numReparation"), res
						.getDate("dateReparation"), res
						.getString("description"));
				reparations.add(reparation);
			}
			if (reparations == null) {
				throw new ObjectNotFoundException();
			}
			return reparations;
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

}
