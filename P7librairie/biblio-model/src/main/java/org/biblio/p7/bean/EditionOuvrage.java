package org.biblio.p7.bean;

import java.util.Date;

public class EditionOuvrage {
	private Date anneeEditions;

	private Ouvrage ouvrage;
	private Editeur editeur;


	public void setOuvrage(Ouvrage aOuvrage) {
		this.ouvrage = aOuvrage;
	}

	public Ouvrage getOuvrage() {
		return this.ouvrage;
	}

	public void setEditeur(Editeur aEditeur) {
		this.editeur = aEditeur;
	}

	public Editeur getEditeur() {
		return this.editeur;
	}

	public EditionOuvrage() {
	}


	  public Date getAnneeEditions() {
	  return anneeEditions;
	  }

	  public void setAnneeEditions(Date anneeEditions) {
	  this.anneeEditions = anneeEditions;
	  }


	@Override
	public String toString() {
		return "EditionOuvrage{" +
				"anneeEditions=" + anneeEditions +
				", ouvrage=" + ouvrage +
				", editeur=" + editeur +
				'}';
	}
}