package org.biblio.p7.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ouvrage {
    private int iD;
    private String intituleOuvrage;

    private String description;
    private String photo;
    private String isbn;
    private Auteur auteur;
private List<Genre> genres;
private List<Editeur> editeurs;

    public Ouvrage() {
    }

    public Ouvrage(int iD) {
        this.iD = iD;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getIntituleOuvrage() {
        return intituleOuvrage;
    }

    public void setIntituleOuvrage(String intituleOuvrage) {
        this.intituleOuvrage = intituleOuvrage;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

  /* public List<OuvrageGenre> getOuvrageGenres() {
        return ouvrageGenres;
    }

    public void setOuvrageGenres(List<OuvrageGenre> ouvrageGenres) {
        this.ouvrageGenres = ouvrageGenres;
    }*/

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Editeur> getEditeurs() {
        return editeurs;
    }

    public void setEditeurs(List<Editeur> editeurs) {
        this.editeurs = editeurs;
    }
/*
    public List<EditionOuvrage> getEditionOuvrages() {
        return editionOuvrages;
    }

    public void setEditionOuvrages(List<EditionOuvrage> editionOuvrages) {
        this.editionOuvrages = editionOuvrages;
    }*/


    @Override
    public String toString() {
        return "Ouvrage{" +
                "iD=" + iD +
                ", intituleOuvrage='" + intituleOuvrage + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", auteur=" + auteur +
                ", genres=" + genres +
                '}';
    }
}