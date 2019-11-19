package org.biblio.p7.contract;

import org.biblio.p7.bean.EditionOuvrage;
import org.biblio.p7.consumer.impl.AbstractDaoimpl;

import java.util.List;

public interface EditionOuvrageDao  {

    public List<EditionOuvrage> afficherEditionOuvrage();

    public List<EditionOuvrage> afficherEditionOuvrageparouvrage(int id);

    public void ajouterEditionOuvrage(EditionOuvrage editionOuvrage);

    public EditionOuvrage supprimerEditionOuvrage(Integer iD);

    public void modifierEditionOuvrage(EditionOuvrage editionOuvrage);
}
