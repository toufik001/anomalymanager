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
	@Column(unique=true,nullable=false)
	private String matMachine;
	@Column(unique=true,nullable=false)
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
		this.setId(machine.getId());
		this.setMatMachine(machine.getMatMachine());
		this.setSerie(machine.getSerie());
		this.setAnomalies(machine.getAnomalies());
		this.setRestrictions(machine.getRestrictions());
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
		this.id = new Long(id);
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
		this.matMachine = new String(matMachine);
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
		this.serie = new String(serie);
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
		if (anomalies != null) this.anomalies = new ArrayList<Anomaly>(anomalies);
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
		if(restrictions != null) this.restrictions = new ArrayList<Restriction>(restrictions);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matMachine == null) ? 0 : matMachine.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Machine other = (Machine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matMachine == null) {
			if (other.matMachine != null)
				return false;
		} else if (!matMachine.equals(other.matMachine))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Machine [id=" + id + ", matMachine=" + matMachine + ", serie=" + serie + ", anomalies=" + anomalies
				+ ", restrictions=" + restrictions + "]";
	}


}
