package com.myprojects.anomalymanager.bo;

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
	@Column
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
		this.id = new Long(restriction.getId());
		this.refRestriction = new String(restriction.getRefRestriction());
		this.description = new String(restriction.getDescription());
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
	 * @return the numRestriction
	 */
	public String getRefRestriction() {
		return refRestriction;
	}

	/**
	 * @param numRestriction the numRestriction to set
	 */
	public void setRefRestriction(String numRestriction) {
		this.refRestriction = numRestriction;
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
		this.description = restriction;
	}


}
