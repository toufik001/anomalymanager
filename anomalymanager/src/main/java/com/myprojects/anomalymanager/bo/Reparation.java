package com.myprojects.anomalymanager.bo;

import java.util.Date;

public class Reparation {
	private long numReparation;
	private Date dateReparation;
	private String description;

	public Reparation() {
	}

	public Reparation(long numReparation, Date dateReparation,
			String description) {
		super();
		this.numReparation = numReparation;
		this.dateReparation = dateReparation;
		this.description = description;
	}

	public long getNumReparation() {
		return numReparation;
	}

	public void setNumReparation(long numReparation) {
		this.numReparation = numReparation;
	}

	public Date getDateReparation() {
		return dateReparation;
	}

	public void setDateReparation(Date dateReparation) {
		this.dateReparation = dateReparation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
