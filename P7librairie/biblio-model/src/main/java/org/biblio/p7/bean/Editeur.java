package org.biblio.p7.bean;

import java.util.ArrayList;

public class Editeur {
    private int iD;
    private String intituleEditeur;
    private String lienweb;
//	private Integer ouvrageID;
//	public ArrayList<Edition_ouvrage> unnamed_Edition_ouvrage_ = new ArrayList<Edition_ouvrage>();


    public Editeur() {
    }

    public Editeur(int iD) {
        this.iD = iD;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getIntituleEditeur() {
        return intituleEditeur;
    }

    public void setIntituleEditeur(String intituleEditeur) {
        this.intituleEditeur = intituleEditeur;
    }

    public String getLienweb() {
        return lienweb;
    }

    public void setLienweb(String lienweb) {
        this.lienweb = lienweb;
    }

/*	public Integer getOuvrageID() {
		return ouvrageID;
	}

	public void setOuvrageID(Integer ouvrageID) {
		this.ouvrageID = ouvrageID;
	}*/

    @Override
    public String toString() {
        return "Editeur{" +
                "iD=" + iD +
                ", intituleEditeur='" + intituleEditeur + '\'' +
                ", lienweb='" + lienweb + '\'' +
                //		", ouvrageID=" + ouvrageID +
                '}';
    }
}