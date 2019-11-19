package org.biblio.p7.managerimpl;


import org.biblio.p7.manager.*;

public class ManagerFactoryImpl implements ManagerFactory {




    private LecteurManager lecteurManager;
    private CoordonneesManager coordonneesManager;
    private GenreManager genreManager;
    private AuteurManager auteurManager;
    private EditeurManager editeurManager;
    private ExemplaireManager exemplaireManager;
    private EditionOuvrageManager editionOuvrageManager;
    private OuvrageManager ouvrageManager;
    private EmpruntManager empruntManager;


    public LecteurManager getLecteurManager() {
        return lecteurManager;
    }


    public CoordonneesManager getCoordonneesManager() {
        return coordonneesManager;
    }

    public void setLecteurManager(LecteurManager lecteurManager) {
        this.lecteurManager = lecteurManager;
    }

    public void setCoordonneesManager(CoordonneesManager coordonneesManager) {
        this.coordonneesManager = coordonneesManager;
    }


    public GenreManager getGenreManager() {
        return genreManager;
    }

    public void setGenreManager(GenreManager genreManager) {
        this.genreManager = genreManager;
    }

    @Override
    public AuteurManager getAuteurManager() {
        return auteurManager;
    }

    public void setAuteurManager(AuteurManager auteurManager) {
        this.auteurManager = auteurManager;
    }


    public EditeurManager getEditeurManager() {
        return editeurManager;
    }

    public ExemplaireManager getExemplaireManager() {
        return exemplaireManager;
    }

    public void setExemplaireManager(ExemplaireManager exemplaireManager) {
        this.exemplaireManager = exemplaireManager;
    }

    public void setEditeurManager(EditeurManager editeurManager) {
        this.editeurManager = editeurManager;


    }


    public EditionOuvrageManager getEditionOuvrageManager() {
        return editionOuvrageManager;
    }

    public void setEditionOuvrageManager(EditionOuvrageManager editionOuvrageManager) {
        this.editionOuvrageManager = editionOuvrageManager;
    }

    @Override
    public OuvrageManager getOuvrageManager() {
        return ouvrageManager;
    }

    @Override
    public EmpruntManager getEmpruntManager() {
        return empruntManager;
    }

    public void setEmpruntManager(EmpruntManager empruntManager) {
        this.empruntManager = empruntManager;
    }

    public void setOuvrageManager(OuvrageManager ouvrageManager) {
        this.ouvrageManager = ouvrageManager;
    }
}
