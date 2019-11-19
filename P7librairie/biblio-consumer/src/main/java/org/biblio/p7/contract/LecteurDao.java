package org.biblio.p7.contract;

import org.biblio.p7.bean.Lecteur;

import java.util.List;

public interface LecteurDao {

     List<Lecteur> affichelecteur();

    public void ajouteLecteur(Lecteur lecteur);

    public Lecteur supprimeLecteur(Integer iD);

    public void modifieLecteur(Lecteur lecteur);

    public Lecteur rechercher(Integer iD);

    public Lecteur rechercherByLecteur(String nom);


    public Lecteur controleLecteur(String identifiant, String motdepasse);




    }
