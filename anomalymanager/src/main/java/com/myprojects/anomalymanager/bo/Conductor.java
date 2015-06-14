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
	@Column
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
		super();
		this.matConducteur = matConducteur;
		this.name = name;
		this.affectation = affectation;
	}

	public Conductor(Conductor conductor) {
		super();
		this.id = conductor.getId();
		this.matConducteur = conductor.getMatConducteur();
		this.name = conductor.getName();
		this.affectation = conductor.getAffectation();
		this.train = new Train(conductor.getTrain());
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
	 * @return the matConducteur
	 */
	public String getMatConducteur() {
		return matConducteur;
	}

	/**
	 * @param matConducteur the matConducteur to set
	 */
	public void setMatConducteur(String matConducteur) {
		this.matConducteur = matConducteur;
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
		this.name = name;
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
		this.affectation = affectation;
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
		this.train = train;
	}

	

}
