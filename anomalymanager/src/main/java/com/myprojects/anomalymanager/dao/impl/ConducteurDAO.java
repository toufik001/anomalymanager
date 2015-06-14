package com.myprojects.anomalymanager.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myprojects.anomalymanager.bo.Conductor;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

public class ConducteurDAO extends DAO<Conductor> {

	@Override
	public void create(Conductor obj, long num) throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("insert into conducteur(matConducteur,nom,prenom,affectation,numTrain) values(?,?,?,?,?)");
			prst.setString(1, obj.getMatConducteur());
			prst.setString(2, obj.getNom());
			prst.setString(3, obj.getPrenom());
			prst.setString(4, obj.getAffectation());
			prst.setLong(5, num);
			prst.executeQuery();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	@Override
	public void delete(long num) throws TechnicalException {
		try {
			this.connection.prepareStatement(
					"delete from conducteur where numConducteur=" + num)
					.executeUpdate();

		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	@Override
	public Conductor find(long num) throws TechnicalException,
			ObjectNotFoundException {
		Conductor conducteur = null;
		try {
			ResultSet prst = this.connection.prepareStatement(
					"select * from conducteur where numConducteur=" + num)
					.executeQuery();
			while (prst.next()) {
				conducteur = new Conductor(num, prst
						.getString("matConducteur"), prst.getString("nom"),
						prst.getString("prenom"),
						prst.getString("affectation"), new TrainDAO().find(prst
								.getLong("numTrain")));
			}
			if (conducteur == null)
				throw new ObjectNotFoundException();
		} catch (SQLException e) {
			throw new TechnicalException();
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException();
		}
		return conducteur;
	}

	public Conductor find(String matConducteur) throws TechnicalException,
			ObjectNotFoundException {
		Conductor conducteur = new Conductor();
		try {
			ResultSet prst = this.connection.prepareStatement(
					"select * from conducteur where numConducteur="
							+ matConducteur).executeQuery();
			while (prst.next()) {
				conducteur.setMatConducteur(matConducteur);
				conducteur.setNom(prst.getString("nom"));
				conducteur.setPrenom(prst.getString("prenom"));
				conducteur.setAffectation(prst.getString("affectation"));
				TrainDAO train = new TrainDAO();
				conducteur.setTrain(train.find(prst.getInt("numTrain")));
			}

		} catch (SQLException e) {
			throw new TechnicalException();
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException();
		}
		return conducteur;

	}

	@Override
	public Conductor update(Conductor obj) throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("update conducteur set nom=?,prenom=? ,affectation=?,numTrain=? where numConducteur=?");

			prst.setString(1, obj.getNom());
			prst.setString(2, obj.getPrenom());
			prst.setString(3, obj.getAffectation());
			prst.setLong(4, obj.getTrain().getNumTrain());
			prst.setLong(5, obj.getNumConducteur());
			prst.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return obj;
	}

	@Override
	// retourne tous les anomalies d'une machine
	public ArrayList<Conductor> getAllByNum(long num) {

		return null;
	}

	@Override
	public long getNum() throws TechnicalException {
		try {
			ResultSet prst = this.connection.prepareStatement(
					"select numConducteur from conducteur").executeQuery();
			if (prst.last())
				return prst.getLong("numConducteur");
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return 0;

	}

	@Override
	public ArrayList<Conductor> getAll() throws TechnicalException,
			ObjectNotFoundException {
		try {
			ResultSet res = this.connection.prepareStatement(
					"select * from conducteur").executeQuery();
			ArrayList<Conductor> conducteurs = new ArrayList<Conductor>();
			while (res.next()) {
				Conductor conducteur = new Conductor(res
						.getLong("numConducteur"), res
						.getString("matConducteur"), res.getString("nom"), res
						.getString("prenom"), res.getString("affectation"));
				conducteurs.add(conducteur);
			}
			if (conducteurs == null) {
				throw new ObjectNotFoundException();
			}
			return conducteurs;
		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}
	public static void main(String[] args) {
		
	}
}
