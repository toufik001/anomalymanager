/**
 * 
 */
package com.gnu.anomalymanager.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author Baz Taoufik
 *
 */

@Entity
@Table(name="ANOMALYMANAGER_LINE")
public class Line implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false, unique=true)
	private String refLine;
	@Column(nullable=false, unique=true)
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(nullable=false, unique=true)
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Station> stations;
	
	public Line() {
	}

	/**
	 * @param refLine
	 * @param startDate
	 * @param endDate
	 */
	public Line(String refLine, Date startDate, Date endDate) {
		if (!startDate.before(endDate)) {
			throw new IllegalArgumentException();
		}
		this.refLine = new String(refLine);
		this.startDate = new Date(startDate.getTime());
		this.endDate = new Date(endDate.getTime());
	}
	
	/**
	 * copy construct 
	 * 
	 * @param line
	 */
	public Line(Line line) {
		this.setId(line.getId());
		this.setRefLine(line.getRefLine());
		this.setStartDate(line.getStartDate());
		this.setEndDate(line.getEndDate());
		this.setStations(line.getStations());
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
	 * @return the refLine
	 */
	public String getRefLine() {
		return refLine;
	}

	/**
	 * @param refLine the refLine to set
	 */
	public void setRefLine(String refLine) {
		this.refLine = new String(refLine);
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = new Date(startDate.getTime());
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = new Date(endDate.getTime());
	}

	/**
	 * @return the stations
	 */
	public List<Station> getStations() {
		return stations;
	}

	/**
	 * @param stations the stations to set
	 */
	public void setStations(List<Station> stations) {
		this.stations = new LinkedList<Station>(stations);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((refLine == null) ? 0 : refLine.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Line other = (Line) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (refLine == null) {
			if (other.refLine != null)
				return false;
		} else if (!refLine.equals(other.refLine))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Line [id=" + id + ", refLine=" + refLine + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", stations=" + stations + "]";
	}
	
	
}
