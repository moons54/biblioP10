package org.biblio.p7.contract;


import org.biblio.p7.bean.EditionOuvrage;
import org.biblio.p7.bean.OuvrageGenre;

public interface DaoFactory {

    LecteurDao getLecteurDao();

    CoordonneesDao getCoordonneesDao();

    GenreDao getGenreDao();

    AuteurDao getAuteurDao();

    EditeurDao getEditeurDao();

    ExemplaireDao getExemplaireDao();

    EditionOuvrageDao getEditionOuvrageDao();

    OuvrageDao getOuvrageDao();

    OuvrageGenreDao getOuvrageGenreDao();

    BibliothequeDao getBibliothequeDao();

    EmpruntDao getEmpruntDao();
}
