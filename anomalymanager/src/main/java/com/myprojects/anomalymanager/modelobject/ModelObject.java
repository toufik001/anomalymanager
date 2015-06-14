package com.myprojects.anomalymanager.modelobject;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.myprojects.anomalymanager.exception.ObjectNotFoundException;
import com.myprojects.anomalymanager.exception.TechnicalException;

@SuppressWarnings("serial")
public class ModelObject<T> extends AbstractTableModel{
	private List<T> objets = new ArrayList<T>();
	private String entete[];

	public ModelObject() {
		super();
	}

	public ModelObject(List<T> objets) {
		super();
		this.objets.addAll(objets);
	}

	public List<T> getObjets() {
		return objets;
	}

	public void setObjets(List<T> objets) {
		this.objets = objets;
	}

	@Override
	public int getColumnCount() {

		return this.getEntete().length;
	}

	@Override
	public int getRowCount() {

		return this.getObjets().size();
	}

	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEntete(String[] entete) {
		this.entete = entete;
	}

	public String[] getEntete() {
		return entete;
	}

	public void add(T obj, long num) throws TechnicalException, ObjectNotFoundException {

	}

	public void remove(int rowIndex) throws TechnicalException {

	}

}
