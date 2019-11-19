package org.biblio.p7.service;

import org.biblio.p7.bean.*;
import org.biblio.p7.managerimpl.ManagerFactoryImpl;

import java.util.ArrayList;
import java.util.List;

public class OuvrageServiceImpl implements OuvrageService {


    private ManagerFactoryImpl managerFactory;

    public ManagerFactoryImpl getManagerFactory() {
        return managerFactory;
    }

    public void setManagerFactory(ManagerFactoryImpl managerFactory) {
        this.managerFactory = managerFactory;
    }


    @Override
    public List<Genre> afficherGenre() {
        List<Genre> genreList=new ArrayList<>();
        genreList=managerFactory.getGenreManager().afficherGenre();
        return genreList;
    }

    @Override
    public void ajouterGenre(Genre genre) {
        managerFactory.getGenreManager().ajouterGenre(genre);
    }

    @Override
    public void supprimerGenre(Integer id) {
        managerFactory.getGenreManager().supprimerGenre(id);
    }

    @Override
    public void modifierGenre(Genre genre) {managerFactory.getGenreManager().modifierGenre(genre);

    }

    @Override
    public List<Auteur> afficherAuteur() {
        List<Auteur> auteurList=new ArrayList<>();
        auteurList=managerFactory.getAuteurManager().afficherAuteur();
        return auteurList;
    }

    @Override
    public void ajouterAuteur(Auteur auteur) {
        managerFactory.getAuteurManager().ajouterAuteur(auteur);

    }

    @Override
    public void supprimerAuteur(Integer id) {
        managerFactory.getAuteurManager().supprimerAuteur(id);
    }

    @Override
    public void modifierAuteur(Auteur auteur) {
        managerFactory.getAuteurManager().modifierAuteur(auteur);

    }

    @Override
    public List<Editeur> afficherEditeur() {
        List<Editeur> editeurList=new ArrayList<>();
        editeurList=managerFactory.getEditeurManager().afficherEditeur();
        return editeurList;
    }

    @Override
    public void ajouterEditeur(Editeur editeur) {
        managerFactory.getEditeurManager().ajouterEditeur(editeur);
    }

    @Override
    public void supprimerEditeur(Integer id) {
        managerFactory.getEditeurManager().supprimerEditeur(id);
    }

    @Override
    public void modifierEditeur(Editeur editeur) {
        managerFactory.getEditeurManager().modifierEditeur(editeur);
    }

    @Override
    public List<Exemplaire> afficherExemplaire() {
        List<Exemplaire> exemplaireList=new ArrayList<>();
        exemplaireList=managerFactory.getExemplaireManager().afficherExemplaire();
        return exemplaireList;
    }

    @Override
    public void ajouterExemplaire(Exemplaire exemplaire) {
        managerFactory.getExemplaireManager().ajouterExemplaire(exemplaire);
    }

    @Override
    public void supprimerExemplaire(Integer id) {
        managerFactory.getExemplaireManager().supprimerExemplaire(id);
    }

    @Override
    public void modifierExemplaire(Exemplaire exemplaire) {
        managerFactory.getExemplaireManager().modifierExemplaire(exemplaire);
    }

    @Override
    public List<EditionOuvrage> afficherVersion() {
        List<EditionOuvrage> editionOuvrageList=new ArrayList<EditionOuvrage>();
        editionOuvrageList=managerFactory.getEditionOuvrageManager().afficherEditionOuvrage();
        return editionOuvrageList;

    }

    @Override
    public void ajouterVersion(EditionOuvrage editionOuvrage) {
managerFactory.getEditionOuvrageManager().ajouterEditionOuvrage(editionOuvrage);
    }

    @Override
    public void supprimerVersion(Integer id) {
managerFactory.getEditionOuvrageManager().supprimerEditionOuvrage(id);
    }

    @Override
    public void modifierVersion(EditionOuvrage editionOuvrage) {
        managerFactory.getEditionOuvrageManager().modifierEditionOuvrage(editionOuvrage);

    }

    @Override
    public List<Ouvrage> ListerlesOuvrages() {
        return //managerFactory.getOuvrageManager().
                managerFactory.getOuvrageManager().afficherExemplaire();
    }

    @Override
    public List<OuvrageGenre> ListerlesOuvrageparGenre(Integer id) {
        return managerFactory.getOuvrageManager().Listerlesouvragepargenre(id);
    }
    @Override
    public List<Exemplaire> ListerlesExemplairesparintitule(Integer ouvrageid) {
        return managerFactory.getExemplaireManager().afficherlistExemplaire(ouvrageid);
    }

    @Override
    public void ajouterOuvrage(Ouvrage ouvrage) {
managerFactory.getOuvrageManager().ajouterOuvrage(ouvrage);
    }

    @Override
    public void supprimerOuvrage(Integer id) {
managerFactory.getOuvrageManager().supprimerOuvrage(id);
    }

    @Override
    public void ModifierOuvrage(Ouvrage ouvrage) {

    }

    @Override
    public Ouvrage rechercherparOuvrage(String intituleOuvrage) {
        return managerFactory.getOuvrageManager().rechercherparOuvrage(intituleOuvrage);
    }

    @Override
    public Ouvrage rechercherparISBN(String isbn) {
        return managerFactory.getOuvrageManager().rechercheparISBN(isbn);
    }


    @Override
    public List<OuvrageGenre> multicriterouvgenre(Integer id){
        return managerFactory.getOuvrageManager().multicritpargenre(id);
}

    @Override
    public List<Ouvrage> multichoix(Integer id,Integer nauid){
        return managerFactory.getOuvrageManager().multichoix(id,nauid);
    }

    @Override
    public Bibliotheque affichebiblio(int id){
        return  managerFactory.getExemplaireManager().affichebiblio(id);
    }

    @Override
    public List<Bibliotheque> listerlesbibliotheques(){
        return managerFactory.getExemplaireManager().listerlesbibliotheques();
    }

    public Exemplaire afficherexemplairebyID(Integer id){
        return managerFactory.getExemplaireManager().afficherexemplairebyID(id);
    }
    @Override
    public Exemplaire changestatusexemplaire(Exemplaire exemplaire){
         return managerFactory.getExemplaireManager().changestatusexemplaire(exemplaire);
    };
}
