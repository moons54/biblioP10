package org.biblio.p7.service;

import org.biblio.p7.bean.Coordonnees;
import org.biblio.p7.bean.Exception.Exception.NotFoundException;
import org.biblio.p7.bean.Lecteur;
import org.biblio.p7.managerimpl.ManagerFactoryImpl;

import java.util.ArrayList;
import java.util.List;

public class AuthentificationServiceImpl implements AuthentificationService {

    private ManagerFactoryImpl managerFactory;

    public ManagerFactoryImpl getManagerFactory() {
        return managerFactory;
    }

    public void setManagerFactory(ManagerFactoryImpl managerFactory) {
        this.managerFactory = managerFactory;
    }

    //premiere methode web liste des lecteurs

    @Override
    public List<Lecteur> rechercherlesLecteurs() {
        List<Lecteur> lecteurs= new ArrayList<Lecteur>();
        try {
            lecteurs=managerFactory.getLecteurManager().affichelecteur();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return lecteurs;
    }


    @Override
    public void ajouterLecteur(Lecteur lecteur){
        managerFactory.getLecteurManager().ajouteLecteur(lecteur);
    }

    @Override
    public void modifierLecteur(Lecteur lecteur) {
        managerFactory.getLecteurManager().modifieLecteur(lecteur);
    }

    @Override
    public Lecteur rechercher(Integer iD) {
        Lecteur lecteur= managerFactory.getLecteurManager().rechercher(iD);
        return lecteur;
    }

    @Override
    public Lecteur rechercherparNom(String nom) {
        return managerFactory.getLecteurManager().rechercherByNom(nom);
    }

    @Override
    public Lecteur controlerLecteur(String identifiant, String motDePasse) {

        Lecteur lecteur=new Lecteur();


        try {
           lecteur= managerFactory.getLecteurManager().controleLecteur(identifiant,motDePasse);

        }catch (NotFoundException e){
            e.printStackTrace();
        }
        return lecteur;
    }

    @Override
    public void supprimerLecteur(Integer id) {
        managerFactory.getLecteurManager().supprimeLecteur(id);
    }


    @Override
    public Coordonnees recherchercoordonnee(Integer iD) {

        Coordonnees coordonnees=managerFactory.getCoordonneesManager().afficheCoordonneByLecteur(iD);
        return coordonnees;
    }

    @Override
    public List<Coordonnees> coordonneesparlecteur(Integer iD) {

        List <Coordonnees> coordonnees=managerFactory.getCoordonneesManager().listeCoordonneByLecteur(iD);
        return coordonnees;
    }



    @Override
    public void ajouterCoordonnees(Coordonnees coordonnees) {
        managerFactory.getCoordonneesManager().ajouteCoordonnees(coordonnees);
    }

    @Override
    public void modifierCooronnees(Coordonnees coordonnees) {
        managerFactory.getCoordonneesManager().modifierCoordonnees(coordonnees);
    }

}
