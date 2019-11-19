package org.biblio.p7.managerimpl;

import org.biblio.p7.bean.Coordonnees;
import org.biblio.p7.manager.CoordonneesManager;

import java.util.List;

public class CoordonneesManagerImpl extends AbstractManagerImpl implements CoordonneesManager {
    @Override
    public Coordonnees afficheCoordonneByLecteur(Integer iD) {
        return getDaoFactory().getCoordonneesDao().afficheCoordonneByLecteur(iD);
    }

    @Override
    public List<Coordonnees> listeCoordonneByLecteur(Integer iD) {
        return getDaoFactory().getCoordonneesDao().listeCoordonneByLecteur(iD);
    }

    @Override
    public void ajouteCoordonnees(Coordonnees coordonnees) {
        getDaoFactory().getCoordonneesDao().ajouteCoordonnees(coordonnees);
    }

    @Override
    public void modifierCoordonnees(Coordonnees coordonnees) {
        getDaoFactory().getCoordonneesDao().modifierCoordonnees(coordonnees);

    }

}
