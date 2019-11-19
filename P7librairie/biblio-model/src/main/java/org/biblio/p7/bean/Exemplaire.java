package org.biblio.p7.bean;

import java.util.ArrayList;

public class Exemplaire {
	private int iD;
	private String referenceInterne;
	private Ouvrage ouvrage;
	private String status;
	//public ArrayList<Emprunt> unnamed_Emprunt_ = new ArrayList<Emprunt>();

	private Bibliotheque bibliotheque;
	//public Ouvrage unnamed_Ouvrage_;
	//public ArrayList<Bibliotheque> unnamed_Bibliotheque_ = new ArrayList<Bibliotheque>();
	//public ArrayList<Emprunt> emprunt = new ArrayList<Emprunt>();


	public Exemplaire() {
	}

	public Exemplaire(int iD) {
		this.iD = iD;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getReferenceInterne() {
		return referenceInterne;
	}

	public void setReferenceInterne(String referenceInterne) {
		this.referenceInterne = referenceInterne;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}

	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;


	}


	@Override
	public String toString() {
		return "Exemplaire{" +
				"iD=" + iD +
				", referenceInterne='" + referenceInterne + '\'' +
				", ouvrage=" + ouvrage +
				", status='" + status + '\'' +
				", bibliotheque=" + bibliotheque +
				'}';
	}
}