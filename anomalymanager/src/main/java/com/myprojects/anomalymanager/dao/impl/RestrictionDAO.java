package com.myprojects.anomalymanager.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myprojects.anomalymanager.bo.Restriction;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;


public class RestrictionDAO extends DAO<Restriction> {

	@Override
	public void create(Restriction restriction, long numMachine)
			throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("insert into restriction(restriction,numMachine) values(?,?)");
			prst.setString(1, restriction.getRestriction());
			prst.setLong(2, numMachine);
			prst.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	@Override
	public void delete(long num) throws TechnicalException {
		try {
			this.connection.prepareStatement(
					"delete from restriction where numRestriction=" + num)
					.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	@Override
	public Restriction find(long num) throws TechnicalException,
			ObjectNotFoundException {
		Restriction restr = null;
		try {
			ResultSet rest = this.connection.prepareStatement(
					"select numRestriction,restriction from restriction where numRestriction="
							+ num).executeQuery();
			if (rest.next()) {
				restr = new Restriction(rest.getInt("numRestriction"), rest
						.getString("restriction"));
			} else
				throw new ObjectNotFoundException();
		} catch (SQLException e) {
			throw new TechnicalException();
		}

		return restr;
	}

	@Override
	public Restriction update(Restriction obj) throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("update restriction set restriction=? where numRestriction=? ");
			prst.setString(1, obj.getRestriction());
			prst.setLong(2, obj.getNumRestriction());
			prst.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return null;
	}

	public ArrayList<Restriction> getAllByNum(long num)
			throws ObjectNotFoundException {
		ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
		try {
			ResultSet reslt = this.connection.prepareStatement(
					"select * from restriction where numMachine=" + num)
					.executeQuery();
			while (reslt.next()) {

				Restriction restriction = new Restriction(reslt
						.getInt("numRestriction"), reslt
						.getString("restriction"));
				restrictions.add(restriction);
			}
			if (restrictions.isEmpty())
				throw new ObjectNotFoundException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restrictions;
	}

	public static void main(String[] args) {
		RestrictionDAO res = new RestrictionDAO();

		ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
		try {
			restrictions = res.getAllByNum(3);
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Restriction restriction : restrictions) {
			System.out.println("num: " + restriction.getNumRestriction()
					+ "rest: " + restriction.getRestriction());
		}

		// System.out.println("num="+res.trouver(1).getNumRestriction()+"restriction: "+res.trouver(1).getRestriction());
	}

	@Override
	public long getNum() throws TechnicalException {
		try {
			ResultSet res = this.connection.prepareStatement(
					"select numRestriction from restriction").executeQuery();
			if (res.last())
				return res.getLong("numRestriction");
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return 0;
	}

	@Override
	public ArrayList<Restriction> getAll() throws TechnicalException,
			ObjectNotFoundException {
		try {
			ResultSet res = this.connection.prepareStatement(
					"select * from restriction").executeQuery();
			ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
			while (res.next()) {
				Restriction restriction = new Restriction(res
						.getLong("numRestriction"), res
						.getString("restriction"));
				restrictions.add(restriction);
			}
			if (restrictions == null) {
				throw new ObjectNotFoundException();
			}
			return restrictions;
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

}
