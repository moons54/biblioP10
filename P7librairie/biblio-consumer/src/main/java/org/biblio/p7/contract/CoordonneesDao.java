package org.biblio.p7.contract;

import org.biblio.p7.bean.Coordonnees;

import java.util.List;

public interface CoordonneesDao  {

    public Coordonnees afficheCoordonneByLecteur(Integer iD);

    public List<Coordonnees> listeCoordonneByLecteur(Integer iD);

    public void ajouteCoordonnees(Coordonnees coordonnees);

    public void modifierCoordonnees(Coordonnees coordonnees);


}
