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
@Table(name="ANOMALYMANAGER_STATION")
public class Station implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false, unique=true)
	private String nameStation;
	
	public Station() {
	}
	
	/**
	 * @param nameStation
	 */
	public Station(String nameStation) {
		this.nameStation = nameStation;
	}
	
	public Station(Station station) {
		this.setId(station.getId());
		this.setNameStation(station.getNameStation());
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
	 * @return the nameStation
	 */
	public String getNameStation() {
		return nameStation;
	}
	/**
	 * @param nameStation the nameStation to set
	 */
	public void setNameStation(String nameStation) {
		this.nameStation = new String(nameStation);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameStation == null) ? 0 : nameStation.hashCode());
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
		Station other = (Station) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nameStation == null) {
			if (other.nameStation != null)
				return false;
		} else if (!nameStation.equals(other.nameStation))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Station [id=" + id + ", nameStation=" + nameStation + "]";
	}
	

}
