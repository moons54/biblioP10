package org.biblio.p7.manager;

import org.biblio.p7.bean.Editeur;

import java.util.List;

public interface EditeurManager {

    public List<Editeur> afficherEditeur();

    public void ajouterEditeur(Editeur editeur);

    public Editeur supprimerEditeur(Integer iD);

    public void modifierEditeur(Editeur editeur);

    public Editeur rechercherEditeurparId(Integer iD);


}
