package org.biblio.p7.bean;

import java.util.ArrayList;

public class Bibliotheque {
	private String intituleBibliotheque;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private int iD;
//	public Exemplaire unnamed_Exemplaire_;
//	public ArrayList<Exemplaire> exemplaire = new ArrayList<Exemplaire>();


	public Bibliotheque() {
	}

	public Bibliotheque(int iD) {
		this.iD = iD;
	}

	public String getIntituleBibliotheque() {
		return intituleBibliotheque;
	}

	public void setIntituleBibliotheque(String intituleBibliotheque) {
		this.intituleBibliotheque = intituleBibliotheque;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	@Override
	public String toString() {
		return "Bibliotheque{" +
				"intituleBibliotheque='" + intituleBibliotheque + '\'' +
				", adresse='" + adresse + '\'' +
				", codePostal='" + codePostal + '\'' +
				", ville='" + ville + '\'' +
				", telephone='" + telephone + '\'' +
				", iD=" + iD +
				'}';
	}
}