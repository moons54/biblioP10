package org.biblio.p7.manager;

import org.biblio.p7.bean.EditionOuvrage;

import java.util.List;

public interface EditionOuvrageManager {


    public List<EditionOuvrage> afficherEditionOuvrage();

    public void ajouterEditionOuvrage(EditionOuvrage editionOuvrage);

    public EditionOuvrage supprimerEditionOuvrage(int id);

    public void modifierEditionOuvrage(EditionOuvrage editionOuvrage);
}
