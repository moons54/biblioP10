package org.biblio.p7.bean;

import java.util.Date;

public class Emprunt {
	private int iD;
	private Date dateDebut;
	private Date dateFin;
	private Date dateRetourEffectif;
	private Boolean renouvellement;
	private SituationDemprunt situationEmprunt;
	private Exemplaire exemplaire;
	private Lecteur lecteur;

	public Emprunt() {
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Date getDateRetourEffectif() {
		return dateRetourEffectif;
	}

	public void setDateRetourEffectif(Date dateRetourEffectif) {
		this.dateRetourEffectif = dateRetourEffectif;
	}

	public Emprunt(int iD) {
		this.iD = iD;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}


	public Boolean getRenouvellement() {
		return renouvellement;
	}

	public void setRenouvellement(Boolean renouvellement) {
		this.renouvellement = renouvellement;
	}

	public SituationDemprunt getSituationEmprunt() {
		return situationEmprunt;
	}

	public void setSituationEmprunt(SituationDemprunt situationEmprunt) {
		this.situationEmprunt = situationEmprunt;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public Lecteur getLecteur() {
		return lecteur;
	}

	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}



	@Override
	public String toString() {
		return "Emprunt{" +
				"iD=" + iD +
				", dateDebut=" + dateDebut +
				", dateFin=" + dateFin +
				", dateRetourEffectif=" + dateRetourEffectif +
				", renouvellement=" + renouvellement +
				", situationEmprunt=" + situationEmprunt +
				", exemplaire=" + exemplaire +
				", lecteur=" + lecteur +
				'}';
	}
}