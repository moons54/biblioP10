package org.biblio.p7.contract;


import org.biblio.p7.bean.Genre;

import java.util.List;

public interface GenreDao {

    public List<Genre> afficherGenre();

    public Genre rechercherGenre(Integer id);

    public List<Genre> RechercherOuvrageparGenre(Integer id);


    public void ajouterGenre(Genre genre);

    public Genre supprimerGenre(Integer iD);

    public void modifierGenre(Genre genre);

    public Genre rechercherparId(Integer iD);




}
