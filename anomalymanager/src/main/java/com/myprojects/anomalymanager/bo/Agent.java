package com.myprojects.anomalymanager.bo;

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
@Table(name="ANOMALYMANAGER_AGENT")
public class Agent {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true,nullable=false)
	private String matAgent;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String poste;
	@Column
	private String affectation;

	public Agent() {
	}

	/**
	 * @param matAgent
	 * @param password
	 * @param nom
	 * @param poste
	 * @param affectation
	 */
	public Agent(String matAgent, String password, String name, String poste, String affectation) {
		super();
		this.matAgent = new String(matAgent);
		this.password = new String(password);
		this.name = new String(name);
		this.poste = new String(poste);
		this.affectation = new String(affectation);
	}

	/**
	 * copy construct
	 * 
	 * @param agent
	 */
	public Agent(Agent agent) {
		this.setId(agent.getId());
		this.setMatAgent(agent.getMatAgent());
		this.setPassword(agent.getPassword());
		this.setName(agent.getName());
		this.setPoste(agent.getPoste());
		this.setAffectation(agent.getAffectation());
	}
	/**
	 * @return the matAgent
	 */
	public String getMatAgent() {
		return matAgent;
	}

	/**
	 * @param matAgent the matAgent to set
	 */
	public void setMatAgent(String matAgent) {
		this.matAgent = new String(matAgent);
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = new String(password);
	}

	/**
	 * @return the nom
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setName(String nom) {
		this.name = new String(nom);
	}

	/**
	 * @return the poste
	 */
	public String getPoste() {
		return poste;
	}

	/**
	 * @param poste the poste to set
	 */
	public void setPoste(String poste) {
		this.poste = new String(poste);
	}

	/**
	 * @return the affectation
	 */
	public String getAffectation() {
		return affectation;
	}

	/**
	 * @param affectation the affectation to set
	 */
	public void setAffectation(String affectation) {
		this.affectation = new String(affectation);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affectation == null) ? 0 : affectation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matAgent == null) ? 0 : matAgent.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((poste == null) ? 0 : poste.hashCode());
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
		Agent other = (Agent) obj;
		if (affectation == null) {
			if (other.affectation != null)
				return false;
		} else if (!affectation.equals(other.affectation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matAgent == null) {
			if (other.matAgent != null)
				return false;
		} else if (!matAgent.equals(other.matAgent))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (poste == null) {
			if (other.poste != null)
				return false;
		} else if (!poste.equals(other.poste))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agent [id=" + id + ", matAgent=" + matAgent + ", password=" + password + ", name=" + name + ", poste="
				+ poste + ", affectation=" + affectation + "]";
	}


}
