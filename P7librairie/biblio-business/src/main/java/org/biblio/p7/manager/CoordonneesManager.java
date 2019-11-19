package org.biblio.p7.manager;

import org.biblio.p7.bean.Coordonnees;

import java.util.List;

public interface CoordonneesManager {
    public Coordonnees afficheCoordonneByLecteur(Integer iD);

    public List<Coordonnees> listeCoordonneByLecteur(Integer iD);

    public void ajouteCoordonnees(Coordonnees coordonnees);

    public void modifierCoordonnees(Coordonnees coordonnees);
}
