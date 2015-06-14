package com.myprojects.anomalymanager.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Baz Taoufik
 *
 */

@Entity
@Table(name="ANOMALYMANAGER_TRAIN")
public class Train implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String matTrain;
	@OneToOne
	private Machine machine;
	@OneToOne
	private Conductor conducteur;
	@OneToOne
	private Line line;
	
	public Train() {
	}

	/**
	 * @param matTrain
	 * @param machine
	 * @param conducteur
	 * @param line
	 */
	public Train(String matTrain, Machine machine, Conductor conducteur, Line line) {
		super();
		this.matTrain = matTrain;
		this.machine = machine;
		this.conducteur = conducteur;
		this.line = line;
	}
	
	public Train(Train train) {
		this.id = train.getId();
		this.matTrain = train.getMatTrain();
		this.machine = new Machine(train.getMachine());
		this.conducteur = new Conductor(train.getConducteur());
		this.line = new Line(train.getLine());
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
	 * @return the matTrain
	 */
	public String getMatTrain() {
		return matTrain;
	}

	/**
	 * @param matTrain the matTrain to set
	 */
	public void setMatTrain(String matTrain) {
		this.matTrain = matTrain;
	}

	/**
	 * @return the machine
	 */
	public Machine getMachine() {
		return machine;
	}

	/**
	 * @param machine the machine to set
	 */
	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	/**
	 * @return the conducteur
	 */
	public Conductor getConducteur() {
		return conducteur;
	}

	/**
	 * @param conducteur the conducteur to set
	 */
	public void setConducteur(Conductor conducteur) {
		this.conducteur = conducteur;
	}

	/**
	 * @return the line
	 */
	public Line getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(Line line) {
		this.line = line;
	}
	
	
}
