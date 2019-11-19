package org.biblio.p7.manager;

import org.biblio.p7.bean.Genre;

import java.util.List;

public interface GenreManager {

    public List<Genre> afficherGenre();

    public void ajouterGenre(Genre genre);

    public Genre supprimerGenre(Integer iD);

    public void modifierGenre(Genre genre);

    public Genre rechercherparId(Integer iD);



}
