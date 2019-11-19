package org.biblio.p7.consumer.impl;

import org.biblio.p7.bean.EditionOuvrage;
import org.biblio.p7.contract.*;



public class DaoFactoryImpl implements DaoFactory {


   private LecteurDao lecteurDao;
   private CoordonneesDao coordonneesDao;
   private GenreDao genreDao;
   private AuteurDao auteurDao;
   private EditeurDao editeurDao;
   private ExemplaireDao exemplaireDao;
   private EditionOuvrageDao editionOuvrageDao;
   private OuvrageDao ouvrageDao;
   private OuvrageGenreDao ouvrageGenreDao;
   private BibliothequeDao bibliothequeDao;
   private EmpruntDao empruntDao;


    public LecteurDao getLecteurDao() {
        return lecteurDao;
    }


    public CoordonneesDao getCoordonneesDao() {
        return coordonneesDao;
    }

    public void setLecteurDao(LecteurDao lecteurDao) {
        this.lecteurDao = lecteurDao;
    }

    public void setCoordonneesDao(CoordonneesDao coordonneesDao) {
        this.coordonneesDao = coordonneesDao;
    }


    public GenreDao getGenreDao() {
        return genreDao;
    }

    public void setGenreDao(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    public AuteurDao getAuteurDao() {
        return auteurDao;
    }

    public void setAuteurDao(AuteurDao auteurDao) {
        this.auteurDao = auteurDao;
    }


    public EditeurDao getEditeurDao() {
        return editeurDao;
    }

    public void setEditeurDao(EditeurDao editeurDao) {
        this.editeurDao = editeurDao;
    }


    public ExemplaireDao getExemplaireDao() {
        return exemplaireDao;
    }

    public void setExemplaireDao(ExemplaireDao exemplaireDao) {
        this.exemplaireDao = exemplaireDao;
    }


    public EditionOuvrageDao getEditionOuvrageDao() {
        return editionOuvrageDao;
    }

    public void setEditionOuvrageDao(EditionOuvrageDao editionOuvrageDao) {
        this.editionOuvrageDao = editionOuvrageDao;
    }


    public OuvrageDao getOuvrageDao() {
        return ouvrageDao;
    }

    public void setOuvrageDao(OuvrageDao ouvrageDao) {
        this.ouvrageDao = ouvrageDao;
    }

    public OuvrageGenreDao getOuvrageGenreDao() {
        return ouvrageGenreDao;
    }

    public void setOuvrageGenreDao(OuvrageGenreDao ouvrageGenreDao) {
        this.ouvrageGenreDao = ouvrageGenreDao;
    }

    public BibliothequeDao getBibliothequeDao() {
        return bibliothequeDao;
    }

    public void setBibliothequeDao(BibliothequeDao bibliothequeDao) {
        this.bibliothequeDao = bibliothequeDao;
    }


    public EmpruntDao getEmpruntDao() {
        return empruntDao;
    }

    public void setEmpruntDao(EmpruntDao empruntDao) {
        this.empruntDao = empruntDao;
    }
}
