package org.biblio.p7.contract;

import org.biblio.p7.bean.Ouvrage;

import java.util.List;

public interface OuvrageDao {
     public List<Ouvrage> afficherOuvrage();

    public void ajouterOuvrage(Ouvrage ouvrage);

    public Ouvrage supprimerOuvrage(Integer iD);

    public void modifierOuvrage(Ouvrage ouvrage);

    public Ouvrage rechercherparOuvrage(String intituleOuvrage);

    public Ouvrage rechercherparId(Integer iD);

    public Ouvrage rechercheparISBN(String isbn);

    public List<Ouvrage> Listerlesouvragepargenre(Integer id);

    public List<Ouvrage> multichoix(Integer id, Integer autid);

}
