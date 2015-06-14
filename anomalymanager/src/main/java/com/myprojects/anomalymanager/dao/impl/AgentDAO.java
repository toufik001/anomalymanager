package com.myprojects.anomalymanager.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myprojects.anomalymanager.bo.Agent;
import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;


public class AgentDAO extends DAO<Agent> {

	@Override
	public void create(Agent obj, long num) throws TechnicalException {
		try {
			PreparedStatement pst = this.connection
					.prepareStatement("insert into agent(matAgent,passwrd,nom,prenom,poste,affectation) value(?,?,?,?,?,?)");
			pst.setString(1, obj.getMatAgent());
			pst.setString(2, obj.getPassword());
			pst.setString(3, obj.getName());
			pst.setString(4, obj.getPrenom());
			pst.setString(5, obj.getPoste());
			pst.setString(6, obj.getAffectation());
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new TechnicalException();
		}
	}

	@Override
	public void delete(long num) throws TechnicalException {
		try {
			this.connection.prepareStatement(
					"delete from agent where numAgent=" + num).executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException();
		}

	}

	public Agent find(String mat) throws ObjectNotFoundException,
			TechnicalException {
		Agent agent = null;
		try {
			ResultSet prst = this.connection.prepareStatement(
					"select * from agent where numAgent=" + mat).executeQuery();

			if (prst.next()) {
				agent = new Agent(mat, prst
						.getString("passwrd"), prst.getString("nom"), prst
						.getString("prenom"), prst.getString("poste"), prst
						.getString("affectation"));
			} else
				throw new ObjectNotFoundException();

		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return agent;

	}

	@Override
	public ArrayList<Agent> getAllByNum(long num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent update(Agent obj) throws TechnicalException {
		try {
			PreparedStatement prst = this.connection
					.prepareStatement("update agent set matAgent=?,passwrd=?,nom=?,prenom=? ,poste=?, affectation=? "
							+ "where numAgent=?");

			prst.setString(1, obj.getMatAgent());
			prst.setString(2, obj.getPassword());
			prst.setString(3, obj.getName());
			prst.setString(4, obj.getPrenom());
			prst.setString(5, obj.getPoste());
			prst.setString(6, obj.getAffectation());
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
					"select numAgent from Agent").executeQuery();
			if (prst.last())
				return prst.getLong("numAgent");
		} catch (SQLException e) {
			throw new TechnicalException();
		}
		return 0;
	}

	@Override
	public ArrayList<Agent> getAll() throws TechnicalException,
			ObjectNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public Agent getByMat(String mat) throws TechnicalException {
		Agent agent = null;
		try {
			PreparedStatement statement = this.connection
					.prepareStatement("select * from Agent where matAgent=?");
			statement.setString(1, mat);
			ResultSet rst = statement.executeQuery();
			while (rst.next()) {
				agent = new Agent(mat, rst.getString("passwrd"), rst
						.getString("nom"), rst.getString("prenom"), rst
						.getString("poste"), rst.getString("affectation"));
			}
			if (agent == null)
				// insertion d'une exception pour declarer une erreur dans le
				// mot de passe ou user
				System.out.println("dssjfkjsfkjhskjd");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return agent;
	}

	@Override
	public Agent find(long num) throws TechnicalException, ObjectNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
