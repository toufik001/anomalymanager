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
	
	/**
	 * copy construct 
	 * 
	 * @param train
	 */
	public Train(Train train) {
		this.setId(train.getId());
		this.setMatTrain(train.getMatTrain());
		this.setMachine(train.getMachine());
		this.setConducteur(train.getConducteur());
		this.setLine(train.getLine());
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
	 * @return the matTrain
	 */
	public String getMatTrain() {
		return matTrain;
	}

	/**
	 * @param matTrain the matTrain to set
	 */
	public void setMatTrain(String matTrain) {
		this.matTrain = new String(matTrain);
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
		this.machine = new Machine(machine);
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
		this.conducteur = new Conductor(conducteur);
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
		this.line = new Line(line);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conducteur == null) ? 0 : conducteur.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((line == null) ? 0 : line.hashCode());
		result = prime * result + ((machine == null) ? 0 : machine.hashCode());
		result = prime * result + ((matTrain == null) ? 0 : matTrain.hashCode());
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
		Train other = (Train) obj;
		if (conducteur == null) {
			if (other.conducteur != null)
				return false;
		} else if (!conducteur.equals(other.conducteur))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (line == null) {
			if (other.line != null)
				return false;
		} else if (!line.equals(other.line))
			return false;
		if (machine == null) {
			if (other.machine != null)
				return false;
		} else if (!machine.equals(other.machine))
			return false;
		if (matTrain == null) {
			if (other.matTrain != null)
				return false;
		} else if (!matTrain.equals(other.matTrain))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Train [id=" + id + ", matTrain=" + matTrain + ", machine=" + machine + ", conducteur=" + conducteur
				+ ", line=" + line + "]";
	}
	
	
}
