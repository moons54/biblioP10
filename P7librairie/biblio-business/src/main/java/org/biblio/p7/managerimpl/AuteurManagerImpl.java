package org.biblio.p7.managerimpl;

import org.biblio.p7.bean.Auteur;
import org.biblio.p7.manager.AuteurManager;

import java.util.List;

public class AuteurManagerImpl extends AbstractManagerImpl implements AuteurManager {
    @Override
    public List<Auteur> afficherAuteur() {
        return getDaoFactory().getAuteurDao().afficherAuteur();
    }

    @Override
    public void ajouterAuteur(Auteur auteur) {
getDaoFactory().getAuteurDao().ajouterAuteur(auteur);
    }

    @Override
    public Auteur supprimerAuteur(Integer iD) {
        return getDaoFactory().getAuteurDao().supprimerAuteur(iD);
    }

    @Override
    public void modifierAuteur(Auteur auteur) {
getDaoFactory().getAuteurDao().modifierAuteur(auteur);
    }

    @Override
    public Auteur rechercherparId(Integer iD) {
        return getDaoFactory().getAuteurDao().rechercherparId(iD);
    }
}
