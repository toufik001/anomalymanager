package com.myprojects.anomalymanager.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Baz Taoufik
 *
 */

@Entity
@Table(name="ANOMALYMANAGER_REPARATION")
public class Reparation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false, unique=true)
	private String refReparation;
	@Column(nullable=false)
	private Date dateReparation;
	@Column
	private String description;

	public Reparation() {
		
	}

	/**
	 * @param refReparation
	 * @param dateReparation
	 * @param description
	 */
	public Reparation(String refReparation, Date dateReparation, String description) {
		this.refReparation = refReparation;
		this.dateReparation = dateReparation;
		this.description = description;
	}
	
	/**
	 * copy constructor
	 * 
	 * @param reparation
	 */
	public Reparation(Reparation reparation) {
		this.setId(reparation.getId());
		this.setDateReparation(reparation.getDateReparation());
		this.setRefReparation(reparation.getRefReparation());
		this.setDescription(reparation.getDescription());
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
	 * @return the refReparation
	 */
	public String getRefReparation() {
		return refReparation;
	}

	/**
	 * @param refReparation the refReparation to set
	 */
	public void setRefReparation(String refReparation) {
		this.refReparation = new String(refReparation);
	}

	/**
	 * @return the dateReparation
	 */
	public Date getDateReparation() {
		return dateReparation;
	}

	/**
	 * @param dateReparation the dateReparation to set
	 */
	public void setDateReparation(Date dateReparation) {
		this.dateReparation = new Date(dateReparation.getTime());
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = new String(description);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateReparation == null) ? 0 : dateReparation.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((refReparation == null) ? 0 : refReparation.hashCode());
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
		Reparation other = (Reparation) obj;
		if (dateReparation == null) {
			if (other.dateReparation != null)
				return false;
		} else if (!dateReparation.equals(other.dateReparation))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (refReparation == null) {
			if (other.refReparation != null)
				return false;
		} else if (!refReparation.equals(other.refReparation))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reparation [id=" + id + ", refReparation=" + refReparation + ", dateReparation=" + dateReparation
				+ ", description=" + description + "]";
	}

}
