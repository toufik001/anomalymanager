package com.gnu.anomalymanager.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ANOMALYMANAGER_ANOMALY")
public class Anomaly implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, unique = true)
	private String refAnomaly;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column
	private String description;
	@Column
	private String category;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Reparation> repairs;

	public Anomaly() {
		this.date = new Date();
	}

	/**
	 * @param refAnomaly
	 * @param date
	 * @param description
	 * @param category
	 * @param repairs
	 */
	public Anomaly(String refAnomaly, Date date, String description, String category) {
		super();
		this.refAnomaly = refAnomaly;
		this.date = date;
		this.description = description;
		this.category = category;
	}

	/**
	 * copy construct
	 * 
	 * @param anomaly
	 */
	public Anomaly(Anomaly anomaly) {
		this.setId(anomaly.getId());
		this.setRefAnomaly(anomaly.getRefAnomaly());
		this.setDate(anomaly.getDate());
		this.setDescription(anomaly.getDescription());
		this.setCategory(anomaly.getCategory());
		if (anomaly.getRepairs() != null) this.setRepairs(anomaly.getRepairs());
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = new Long(id);
	}

	/**
	 * @return the refAnomaly
	 */
	public String getRefAnomaly() {
		return refAnomaly;
	}

	/**
	 * @param refAnomaly
	 *            the refAnomaly to set
	 */
	public void setRefAnomaly(String refAnomaly) {
		this.refAnomaly = new String(refAnomaly);
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = new Date(date.getTime());
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = new String(description);
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = new String(category);
	}

	/**
	 * @return the repairs
	 */
	public List<Reparation> getRepairs() {
		return repairs;
	}

	/**
	 * @param repairs
	 *            the repairs to set
	 */
	public void setRepairs(List<Reparation> repairs) {
		this.repairs = new ArrayList<Reparation>(repairs);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((refAnomaly == null) ? 0 : refAnomaly.hashCode());
		result = prime * result + ((repairs == null) ? 0 : repairs.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Anomaly other = (Anomaly) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
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
		if (refAnomaly == null) {
			if (other.refAnomaly != null)
				return false;
		} else if (!refAnomaly.equals(other.refAnomaly))
			return false;
		if (repairs == null) {
			if (other.repairs != null)
				return false;
		} else if (!repairs.equals(other.repairs))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Anomaly [id=" + id + ", refAnomaly=" + refAnomaly + ", date=" + date + ", description=" + description
				+ ", category=" + category + ", repairs=" + repairs + "]";
	}

}
