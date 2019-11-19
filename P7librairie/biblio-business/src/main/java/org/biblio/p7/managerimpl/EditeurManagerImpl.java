package org.biblio.p7.managerimpl;

import org.biblio.p7.bean.Editeur;
import org.biblio.p7.manager.EditeurManager;

import java.util.List;

public class EditeurManagerImpl extends AbstractManagerImpl implements EditeurManager {
    @Override
    public List<Editeur> afficherEditeur() {
        return getDaoFactory().getEditeurDao().afficherEditeur();
    }

    @Override
    public void ajouterEditeur(Editeur editeur) {
        getDaoFactory().getEditeurDao().ajouterEditeur(editeur);
    }

    @Override
    public Editeur supprimerEditeur(Integer iD) {

        return getDaoFactory().getEditeurDao().supprimerEditeur(iD);
    }

    @Override
    public void modifierEditeur(Editeur editeur) {
        getDaoFactory().getEditeurDao().modifierEditeur(editeur);
    }

    @Override
    public Editeur rechercherEditeurparId(Integer iD) {
        return getDaoFactory().getEditeurDao().rechercherEditeurparId(iD);
    }
}
