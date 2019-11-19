package org.biblio.p7.manager;


import org.biblio.p7.bean.Exception.Exception.NotFoundException;
import org.biblio.p7.bean.Lecteur;

import java.util.List;

public interface LecteurManager {


    public List<Lecteur> affichelecteur() throws NotFoundException;

    public void ajouteLecteur(Lecteur lecteur);

    public Lecteur supprimeLecteur(Integer iD);

    public void modifieLecteur(Lecteur lecteur);

    public Lecteur rechercher(Integer iD);

    public Lecteur rechercherByNom(String nom);

    public Lecteur controleLecteur(String identifiant,String motdepasse) throws NotFoundException;

}
