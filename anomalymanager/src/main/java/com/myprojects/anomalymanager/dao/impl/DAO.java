package com.myprojects.anomalymanager.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;

import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

public abstract class DAO<T> {
	// etablir une connexion avec la base
	public Connection connection = ManagerDB.getInstance();

	// permet de trouver un element par son numero
	public abstract T find(long num) throws TechnicalException, ObjectNotFoundException;

	// permet d'ajouter un element dans la base de donnees
	public abstract void create(T obj, long num) throws TechnicalException;

	// permet de faire la mise a jour d'un element
	public abstract T update(T obj) throws TechnicalException;

	// permet de supprimer un element de la base de donnees
	public abstract void delete(long num) throws TechnicalException;

	// permet de retourner id du dernier enregistrement
	public abstract long getNum() throws TechnicalException, ObjectNotFoundException;

	public abstract ArrayList<T> getAllByNum(long num) throws ObjectNotFoundException, TechnicalException;

	public abstract ArrayList<T> getAll() throws TechnicalException, ObjectNotFoundException;
}