package com.myprojects.anomalymanager.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.myprojects.anomalymanager.bo.Train;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

public class TrainDAO extends DAO<Train> {

	@Override
	public void create(Train obj, long numConducteur) throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("insert into train(dateDepart,dateArrive,gareDepart,gareArrive,numConducteur,numMachine) values(?,?,?,?,?,?)");
			SimpleDateFormat fd = new SimpleDateFormat();
			String dateDepart = fd.format(obj.getDateDepart());
			String dateArrive = fd.format(obj.getDateArrive());
			prst.setString(1, dateDepart);
			prst.setString(2, dateArrive);
			prst.setString(3, obj.getGareDepart());
			prst.setString(4, obj.getGareArrive());
			prst.setLong(3, numConducteur);
			prst.setLong(4, obj.getMachine().getNumMachine());
			prst.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	@Override
	public void delete(long num) throws TechnicalException {
		try {
			this.connection.prepareStatement(
					"delete from train where numTrain=" + num).executeUpdate();

		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	@Override
	public Train find(long num) throws TechnicalException,
			ObjectNotFoundException {
		Train train = null;
		try {
			ResultSet prst = this.connection.prepareStatement(
					"select * from train where numTrain=" + num).executeQuery();
			while (prst.next()) {
				train = new Train(num, prst.getDate("dateDepart"), prst
						.getDate("dateArrive"), prst.getString("gareDepart"),
						prst.getString("gareArrive"), new ConducteurDAO()
								.find(prst.getLong("numConducteur")),
						new MachineDAO().find(prst.getLong("numMachine")));
			}
			if (train == null)
				throw new ObjectNotFoundException();
		} catch (SQLException e) {
			throw new TechnicalException();
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException();
		}
		return train;
	}

	@Override
	public ArrayList<Train> getAllByNum(long num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Train update(Train obj) throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("update train set dateDepart=?,dateArrive=?,gareDepart=? ,gareArrive=?,numConducteur=?,numMachine=? where numTrain=?");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateDepart = df.format(obj.getDateDepart());
			String dateArrive = df.format(obj.getDateArrive());

			prst.setString(1, dateDepart);
			prst.setString(2, dateArrive);
			prst.setString(3, obj.getGareDepart());
			prst.setString(4, obj.getGareArrive());
			prst.setLong(5, obj.getConducteur().getNumConducteur());
			prst.setLong(6, obj.getMachine().getNumMachine());
			prst.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return obj;
	}

	@Override
	public long getNum() throws TechnicalException {
		try {
			ResultSet prst = this.connection.prepareStatement(
					"select numTrain from train").executeQuery();
			if (prst.last())
				return prst.getLong("numTrain");
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return 0;

	}

	public static void main(String[] args) throws TechnicalException {
		TrainDAO dao = new TrainDAO();
		dao.create(new Train(), 1);
	}

	@Override
	public ArrayList<Train> getAll() throws TechnicalException,
			ObjectNotFoundException {
		try {
			ResultSet res = this.connection.prepareStatement(
					"select * from train").executeQuery();
			ArrayList<Train> trains = new ArrayList<Train>();
			while (res.next()) {
				Train train = new Train(res.getLong("numTrain"), res
						.getDate("dateDepart"), res.getDate("dateArrive"), res
						.getString("gareDepart"), res.getString("gareArrive"));
				trains.add(train);
			}
			if (trains == null) {
				throw new ObjectNotFoundException();
			}
			return trains;
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

}
