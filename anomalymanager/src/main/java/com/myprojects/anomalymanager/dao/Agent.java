package com.myprojects.anomalymanager.dao;


public class Agent {
	
	
	public static String matAgent;
	public static String password;
	private static String nom;
	private static String prenom;
	public static String poste;
	private static String affectation;
	private static long numAgent;

	public Agent() {
	}

	public Agent(String pMatAgent, String pPassword, String pNom,
			String pPrenom, String pPoste, String pAffectation) {
		super();
		matAgent = pMatAgent;
		password = pPassword;
		nom = pNom;
		prenom = pPrenom;
		poste = pPoste;
		affectation = pAffectation;
	}

	public Agent(String pMatAgent, String pPassword, String pNom,
			String pPrenom, String pPoste, String pAffectation, long pNumAgent) {
		super();
		matAgent = pMatAgent;
		password = pPassword;
		nom = pNom;
		prenom = pPrenom;
		poste = pPoste;
		affectation = pAffectation;
	}

	public String getMatAgent() {
		return matAgent;
	}

	public void setMatAgent(String matAgent) {
		Agent.matAgent = matAgent;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Agent.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		Agent.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		Agent.prenom = prenom;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		Agent.poste = poste;
	}

	public String getAffectation() {
		return affectation;
	}

	public void setAffectation(String affectation) {
		Agent.affectation = affectation;
	}

	public long getNumAgent() {
		return numAgent;
	}

	public void setNumAgent(long numAgent) {
		Agent.numAgent = numAgent;
	}

	public String toString() {
		String string = "nom: " + getNom() + " prenom: " + getPrenom()
				+ " matricule: " + getMatAgent() + " affectation: "
				+ getAffectation() + " post: " + getPoste() + " passwrd: "
				+ getPassword();
		return string;
	}

}
