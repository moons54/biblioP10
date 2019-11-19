package org.biblio.p7.contract;


import org.biblio.p7.bean.OuvrageGenre;

import java.util.List;

public interface OuvrageGenreDao {
    public List<OuvrageGenre> afficherGenreOuvrage(Integer id);

    public void ajouterGenreOuvrage(OuvrageGenre ouvrageGenre);

    public OuvrageGenre supprimeGenreOuvrage(Integer iD);

    public void modifierGenreOuvrage(OuvrageGenre ouvrageGenre);

    public List<OuvrageGenre> affichelisteouvrageGenre();

    public OuvrageGenre rechercherGenreOuvrage(Integer id);

    public List<OuvrageGenre> listerlesouvragepargenre(Integer id);

}
