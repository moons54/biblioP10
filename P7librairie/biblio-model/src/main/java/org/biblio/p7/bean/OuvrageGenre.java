package org.biblio.p7.bean;

public class OuvrageGenre {

    private Ouvrage ouvrage;
    private Genre genre;

    public OuvrageGenre() {
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "OuvrageGenre{" +
                "ouvrage=" + ouvrage +
                ", genre=" + genre +
                '}';
    }
}
