package org.biblio.p7.contract;

import org.biblio.p7.bean.Editeur;

import java.util.List;

public interface EditeurDao {

    public List<Editeur> afficherEditeur();

    public void ajouterEditeur(Editeur editeur);

    public Editeur supprimerEditeur(Integer iD);

    public void modifierEditeur(Editeur editeur);

    public Editeur rechercherEditeurparId(Integer iD);
}
