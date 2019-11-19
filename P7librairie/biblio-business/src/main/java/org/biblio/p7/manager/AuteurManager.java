package org.biblio.p7.manager;

import org.biblio.p7.bean.Auteur;

import java.util.List;

public interface AuteurManager {

    public List<Auteur> afficherAuteur();

    public void ajouterAuteur(Auteur auteur);

    public Auteur supprimerAuteur(Integer iD);

    public void modifierAuteur(Auteur auteur);

    public Auteur rechercherparId(Integer iD);
}
