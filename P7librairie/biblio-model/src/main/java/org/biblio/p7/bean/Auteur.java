package org.biblio.p7.bean;

import java.util.ArrayList;

public class Auteur {
	private int iD;
	private String intituleAuteur;
	private String descriptionAuteur;
	private String lienweb;
	//public ArrayList<Ouvrage> ouvrage = new ArrayList<Ouvrage>();


	public Auteur() {
	}


	public Auteur(int iD) {
		this.iD = iD;
	}


	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getIntituleAuteur() {
		return intituleAuteur;
	}

	public void setIntituleAuteur(String intituleAuteur) {
		this.intituleAuteur = intituleAuteur;
	}

	public String getDescriptionAuteur() {
		return descriptionAuteur;
	}

	public void setDescriptionAuteur(String descriptionAuteur) {
		this.descriptionAuteur = descriptionAuteur;
	}

	public String getLienweb() {
		return lienweb;
	}

	public void setLienweb(String lienweb) {
		this.lienweb = lienweb;
	}

	@Override
	public String toString() {
		return "Auteur{" +
				"iD=" + iD +
				", intituleAuteur='" + intituleAuteur + '\'' +
				", descriptionAuteur='" + descriptionAuteur + '\'' +
				", lienweb='" + lienweb + '\'' +
				'}';
	}
}