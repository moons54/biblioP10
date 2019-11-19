package org.biblio.p7.manager;

import org.biblio.p7.bean.Ouvrage;
import org.biblio.p7.bean.OuvrageGenre;

import java.util.List;

public interface OuvrageManager {
    public List<Ouvrage> afficherExemplaire();

    public List<OuvrageGenre> Listerlesouvragepargenre(Integer Id);

    public void ajouterOuvrage(Ouvrage ouvrage);

    public Ouvrage supprimerOuvrage(Integer iD);

    public void modifierOuvrage(Ouvrage ouvrage);

    public Ouvrage rechercherparOuvrage(String intituleOuvrage);

    public Ouvrage rechercherparId(Integer iD);

    public Ouvrage rechercheparISBN(String isbn);

    public List<OuvrageGenre> multicritpargenre(Integer id);

    public List<Ouvrage> multichoix(Integer id,Integer nauid);
}
