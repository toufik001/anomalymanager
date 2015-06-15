package com.myprojects.anomalymanager.bo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Baz Taoufik
 *
 */

@Entity
@Table(name="ANOMALYMANAGER_CONDUCTOR")
public class Conductor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, unique = true)
	private String matConducteur;
	@Column
	private String name;
	@Column
	private String affectation;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Train train;

	public Conductor() {
	}

	/**
	 * @param matConducteur
	 * @param name
	 * @param affectation
	 * @param train
	 */
	public Conductor(String matConducteur, String name, String affectation) {
		this.matConducteur = matConducteur;
		this.name = name;
		this.affectation = affectation;
	}

	/**
	 * copy construct
	 * 
	 * @param conductor
	 */
	public Conductor(Conductor conductor) {
		this.setId(conductor.getId());
		this.setMatConducteur(conductor.getMatConducteur());
		this.setName(conductor.getName());
		this.setAffectation(conductor.getAffectation());
		this.setTrain(conductor.getTrain());
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
	 * @return the matConducteur
	 */
	public String getMatConducteur() {
		return matConducteur;
	}

	/**
	 * @param matConducteur the matConducteur to set
	 */
	public void setMatConducteur(String matConducteur) {
		this.matConducteur = new String(matConducteur);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = new String(name);
	}

	/**
	 * @return the affectation
	 */
	public String getAffectation() {
		return affectation;
	}

	/**
	 * @param affectation the affectation to set
	 */
	public void setAffectation(String affectation) {
		this.affectation = new String(affectation);
	}

	/**
	 * @return the train
	 */
	public Train getTrain() {
		return train;
	}

	/**
	 * @param train the train to set
	 */
	public void setTrain(Train train) {
		this.train = new Train(train);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affectation == null) ? 0 : affectation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matConducteur == null) ? 0 : matConducteur.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Conductor other = (Conductor) obj;
		if (affectation == null) {
			if (other.affectation != null)
				return false;
		} else if (!affectation.equals(other.affectation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matConducteur == null) {
			if (other.matConducteur != null)
				return false;
		} else if (!matConducteur.equals(other.matConducteur))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conductor [id=" + id + ", matConducteur=" + matConducteur + ", name=" + name + ", affectation="
				+ affectation + ", train=" + train + "]";
	}

	

}
