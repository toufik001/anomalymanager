package com.myprojects.anomalymanager.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Baz Taoufik
 *
 */

@Entity
@Table(name="ANOMALYMANAGER_MACHINE")
public class Machine implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String matMachine;
	@Column
	private String serie;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Anomaly> anomalies = new ArrayList<Anomaly>();
	
	private List<Restriction> restrictions = new ArrayList<Restriction>();

	public Machine() {
	}
	
	public Machine(String serie) {
		super();
		this.serie = serie;
	}

	public Machine(long numMachine, String serie) {
		super();
		this.numMachine = numMachine;
		this.serie = serie;
	}

	public Machine(long numMachine, String serie,
			ArrayList<Anomaly> anomalies, ArrayList<Restriction> restrictions) {
		super();
		this.numMachine = numMachine;
		this.serie = serie;
		this.anomalies = anomalies;
		this.restrictions = restrictions;
	}

	public long getNumMachine() {
		return numMachine;
	}

	public void setNumMachine(long numMachine) {
		this.numMachine = numMachine;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public ArrayList<Anomaly> getAnomalies() {
		return anomalies;
	}

	public void setAnomalies(ArrayList<Anomaly> anomalies) {
		this.anomalies = anomalies;
	}

	public ArrayList<Restriction> getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(ArrayList<Restriction> restrictions) {
		this.restrictions = restrictions;
	}

}
