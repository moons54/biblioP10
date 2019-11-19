package org.biblio.p7.managerimpl;

import org.biblio.p7.bean.EditionOuvrage;
import org.biblio.p7.manager.EditionOuvrageManager;

import java.util.List;

public class EditionOuvrageManagerImpl extends AbstractManagerImpl implements EditionOuvrageManager {
    @Override
    public List<EditionOuvrage> afficherEditionOuvrage() {
        return getDaoFactory().getEditionOuvrageDao().afficherEditionOuvrage();
    }

    @Override
    public void ajouterEditionOuvrage(EditionOuvrage editionOuvrage) {
        getDaoFactory().getEditionOuvrageDao().ajouterEditionOuvrage(editionOuvrage);

    }

    @Override
    public EditionOuvrage supprimerEditionOuvrage(int id) {
        return getDaoFactory().getEditionOuvrageDao().supprimerEditionOuvrage(id);
    }

    @Override
    public void modifierEditionOuvrage(EditionOuvrage editionOuvrage) {
getDaoFactory().getEditionOuvrageDao().modifierEditionOuvrage(editionOuvrage);
    }
}
