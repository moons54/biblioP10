package org.biblio.p7.bean;

import javax.xml.bind.annotation.XmlType;

//@Named


@XmlType(name = "Coordonnees")
public class Coordonnees {
	private int iD;
	private String rue;
	private String codePostal;
	private String ville;
	private String telephone;
	private String email;
	 private Lecteur lecteur;




	public Coordonnees(int iD) {
		this.iD = iD;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Lecteur getLecteur() {
		return lecteur;
	}

	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}
	public Coordonnees() {
	}

	@Override
	public String toString() {
		return "Coordonnees{" +
				"iD=" + iD +
				", rue='" + rue + '\'' +
				", codePostal='" + codePostal + '\'' +
				", ville='" + ville + '\'' +
				", telephone='" + telephone + '\'' +
				", email='" + email + '\'' +
				", lecteur=" + lecteur +
				'}';
	}
}