package com.gnu.anomalymanager.bo;

import java.io.Serializable;

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
@Table(name="ANOMALYMANAGER_RESTRICTION")
public class Restriction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false, unique=true)
	private String refRestriction;
	@Column
	private String description;

	public Restriction() {
	}

	/**
	 * @param refRestriction
	 * @param restriction
	 */
	public Restriction(String refRestriction, String restriction) {
		super();
		this.refRestriction = refRestriction;
		this.description = restriction;
	}

	public Restriction(Restriction restriction) {
		this.setId(restriction.getId());;
		this.setRefRestriction(restriction.getRefRestriction());
		this.setDescription(restriction.getDescription());
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
	 * @return the numRestriction
	 */
	public String getRefRestriction() {
		return refRestriction;
	}

	/**
	 * @param numRestriction the numRestriction to set
	 */
	public void setRefRestriction(String numRestriction) {
		this.refRestriction = new String(numRestriction);
	}

	/**
	 * @return the restriction
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param restriction the restriction to set
	 */
	public void setDescription(String restriction) {
		this.description = new String(restriction);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((refRestriction == null) ? 0 : refRestriction.hashCode());
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
		Restriction other = (Restriction) obj;
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
		if (refRestriction == null) {
			if (other.refRestriction != null)
				return false;
		} else if (!refRestriction.equals(other.refRestriction))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Restriction [id=" + id + ", refRestriction=" + refRestriction + ", description=" + description + "]";
	}


}
