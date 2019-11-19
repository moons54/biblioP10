package org.biblio.p7.contract;

import org.biblio.p7.bean.Bibliotheque;

import java.util.List;

public interface BibliothequeDao {

    public List<Bibliotheque> afficherBibliotheque();

    public void ajouterbibliotheque(Bibliotheque bibliotheque);

    public Bibliotheque supprimerBibliotheque(Integer iD);

    public void modifierBibliotheque(Bibliotheque bibliotheque);

    public Bibliotheque rechercherBibliothequeparId(Integer iD);
}
