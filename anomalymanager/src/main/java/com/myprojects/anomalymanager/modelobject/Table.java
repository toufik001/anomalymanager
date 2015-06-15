package com.myprojects.anomalymanager.modelobject;

import javax.swing.JTable;


@SuppressWarnings("serial")
public class Table<T> extends JTable {
	private ModelObject<T> modele = new ModelObject<T>();

	public Table() {
		super();
	}

	public Table(ModelObject<T> model) {
		this.modele = model;
		this.setModel(model);
		// this.add(new JScrollPane(table));

	}

	public ModelObject<T> getModele() {
		return modele;
	}

	public void setModele(ModelObject<T> modele) {
		this.modele = modele;
	}

}
