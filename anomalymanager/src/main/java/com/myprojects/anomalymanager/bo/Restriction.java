package com.myprojects.anomalymanager.bo;

public class Restriction {
	private long numRestriction;
	private String restriction;

	public Restriction() {
	}

	public Restriction(long numRestriction, String restriction) {
		super();
		this.numRestriction = numRestriction;
		this.restriction = restriction;
	}

	public long getNumRestriction() {
		return numRestriction;
	}

	public void setNumRestriction(long numRestriction) {
		this.numRestriction = numRestriction;
	}

	public String getRestriction() {
		return restriction;
	}

	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}

}
