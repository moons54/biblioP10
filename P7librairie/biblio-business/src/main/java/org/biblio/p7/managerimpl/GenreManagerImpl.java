package org.biblio.p7.managerimpl;

import org.biblio.p7.bean.Genre;
import org.biblio.p7.consumer.impl.AbstractDaoimpl;
import org.biblio.p7.manager.GenreManager;

import java.util.List;

public class GenreManagerImpl extends AbstractManagerImpl implements GenreManager {
    @Override
    public List<Genre> afficherGenre() {
        return getDaoFactory().getGenreDao().afficherGenre();
    }

    @Override
    public void ajouterGenre(Genre genre) {
        getDaoFactory().getGenreDao().ajouterGenre(genre);
    }

    @Override
    public Genre supprimerGenre(Integer iD) {
        return getDaoFactory().getGenreDao().supprimerGenre(iD);
    }

    @Override
    public void modifierGenre(Genre genre) {
        getDaoFactory().getGenreDao().modifierGenre(genre);
    }

    @Override
    public Genre rechercherparId(Integer iD) {
        return getDaoFactory().getGenreDao().rechercherparId(iD);
    }


}
