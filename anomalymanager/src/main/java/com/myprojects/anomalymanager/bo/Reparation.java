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
		super();
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
		setId(reparation.getId());
		setDateReparation(reparation.getDateReparation());
		setRefReparation(reparation.getRefReparation());
		setDescription(reparation.getDescription());
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

}
