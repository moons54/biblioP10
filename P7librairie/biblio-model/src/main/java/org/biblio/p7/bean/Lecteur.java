package org.biblio.p7.bean;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.List;

@XmlType(name = "Lecteur")
public class Lecteur {
	private int id;
	private String identifiant;
	private String nom;
	private String prenom;
	private String motDePasse;
	private Date dateInscription;
	private Date dateDeNaissance;
	private String num_cni;


	public Lecteur() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}


	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNum_cni() {
		return num_cni;
	}

	public void setNum_cni(String num_cni) {
		this.num_cni = num_cni;
	}

	@Override
	public String toString() {
		return "Lecteur{" +
				"id=" + id +
				", identifiant='" + identifiant + '\'' +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", motDePasse='" + motDePasse + '\'' +
				", dateInscription=" + dateInscription +
				", dateDeNaissance=" + dateDeNaissance +
				", num_cni='" + num_cni + '\'' +
				'}';
	}
}