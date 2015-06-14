/**
 * 
 */
package com.myprojects.anomalymanager.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	private Date startDate;
	@Column(nullable=false, unique=true)
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
		setId(line.getId());
		setRefLine(line.getRefLine());
		setStartDate(line.getStartDate());
		setEndDate(line.getEndDate());
		setStations(line.getStations());
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
	
	
}
