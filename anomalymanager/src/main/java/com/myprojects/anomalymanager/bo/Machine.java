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
	@OneToMany(cascade=CascadeType.ALL)
	private List<Restriction> restrictions = new ArrayList<Restriction>();

	public Machine() {
	}

	/**
	 * @param matMachine
	 * @param serie
	 */
	public Machine(String matMachine, String serie) {
		this.matMachine = matMachine;
		this.serie = serie;
	}
	
	public Machine(Machine machine) {
		this.id = new Long(machine.getId());
		this.matMachine = new String(machine.getMatMachine());
		this.serie = new String(machine.getSerie());
		this.anomalies = machine.getAnomalies();
		this.restrictions = machine.getRestrictions();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the matMachine
	 */
	public String getMatMachine() {
		return matMachine;
	}

	/**
	 * @param matMachine the matMachine to set
	 */
	public void setMatMachine(String matMachine) {
		this.matMachine = matMachine;
	}

	/**
	 * @return the serie
	 */
	public String getSerie() {
		return serie;
	}

	/**
	 * @param serie the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

	/**
	 * @return the anomalies
	 */
	public List<Anomaly> getAnomalies() {
		return anomalies;
	}

	/**
	 * @param anomalies the anomalies to set
	 */
	public void setAnomalies(List<Anomaly> anomalies) {
		this.anomalies = anomalies;
	}

	/**
	 * @return the restrictions
	 */
	public List<Restriction> getRestrictions() {
		return restrictions;
	}

	/**
	 * @param restrictions the restrictions to set
	 */
	public void setRestrictions(List<Restriction> restrictions) {
		this.restrictions = restrictions;
	}


}
