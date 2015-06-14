package com.myprojects.anomalymanager.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myprojects.anomalymanager.bo.Machine;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

public class MachineDAO extends DAO<Machine> {

	@Override
	public void create(Machine obj, long num) throws TechnicalException {

		try {
			PreparedStatement pst = this.connection
					.prepareStatement("insert into machine(serie) value(?)");
			pst.setString(1, obj.getSerie());
			pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage() + e.getErrorCode());
			e.printStackTrace();
		}

	}

	@Override
	public void delete(long num) throws TechnicalException {
		try {
			this.connection.prepareStatement(
					"delete from machine where numMachine=" + num)
					.executeUpdate();

		} catch (SQLException e) {

		}
	}

	@Override
	public Machine find(long numMachine) throws TechnicalException,
			ObjectNotFoundException {

		try {
			PreparedStatement pst = this.connection
					.prepareStatement("select * from machine where numMachine=?");
			pst.setLong(1, numMachine);
			ResultSet reslt = pst.executeQuery();
			Machine machine = null;
			if (reslt.next()) {
				System.out.println("cocucoc");
				RestrictionDAO rest = new RestrictionDAO();
				AnomalieDAO anom = new AnomalieDAO();
				machine = new Machine(reslt.getLong("NumMachine"), reslt
						.getString("serie"));
				machine.setAnomalies(anom.getAllByNum(numMachine));
				machine.setRestrictions(rest.getAllByNum(numMachine));
			}
			return machine;
		} catch (SQLException e) {
			throw new TechnicalException();
		}

	}

	@Override
	public Machine update(Machine obj) throws TechnicalException {
		try {
			PreparedStatement pst = this.connection
					.prepareStatement("update machine set serie=? where numMachine=?");
			pst.setString(1, obj.getSerie());
			pst.setLong(2, obj.getNumMachine());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return obj;
	}

	@Override
	public ArrayList<Machine> getAllByNum(long num) {

		return null;
	}

	@Override
	public long getNum() throws TechnicalException {

		try {
			ResultSet res = this.connection.prepareStatement(
					"select numMachine from machine").executeQuery();
			if (res.last())
				return res.getLong("numMachine");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return 0;
	}

	public static void main(String[] args) {
		MachineDAO dao = new MachineDAO();
		Machine machine = new Machine("dnhjuhfdkj");
		Machine machine1 = new Machine("sdhksjdhfkjsh");
		try {
			System.out.println(dao.find("DKL676").getSerie());
		} catch (TechnicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Machine> getAll() throws TechnicalException,
			ObjectNotFoundException {
		try {
			ResultSet res = this.connection.prepareStatement(
					"select * from machine").executeQuery();
			ArrayList<Machine> machines = new ArrayList<Machine>();
			while (res.next()) {
				Machine machine = new Machine(res.getLong("numMachine"), res
						.getString("serie"));
				machines.add(machine);
			}
			if (machines == null) {
				throw new ObjectNotFoundException();
			}
			return machines;
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	public Machine find(String serie) throws TechnicalException {
		try {
			PreparedStatement pst = this.connection
					.prepareStatement("select * from machine where serie=?");
			pst.setString(1, serie);
			ResultSet reslt = pst.executeQuery();
			Machine machine = null;
			if (reslt.next()) {

				machine = new Machine(reslt.getLong("NumMachine"), reslt
						.getString("serie"));
			}
			return machine;
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

}
