package org.biblio.p7.contract;

import org.biblio.p7.bean.Auteur;

import java.util.List;

public interface AuteurDao {


    public List<Auteur> afficherAuteur();

    public void ajouterAuteur(Auteur auteur);

    public Auteur supprimerAuteur(Integer iD);

    public void modifierAuteur(Auteur auteur);

    public Auteur rechercherparId(Integer iD);


}
