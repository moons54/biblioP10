package org.biblio.p7.service;

import org.biblio.p7.bean.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "OuvrageService")
public interface OuvrageService {

    @WebMethod
    public List<Genre> afficherGenre();


    @WebMethod
    public void ajouterGenre(Genre genre);

    @WebMethod
    public void supprimerGenre(@WebParam(name = "iD") Integer id);

    @WebMethod
    public void modifierGenre(Genre genre);


    @WebMethod
    public List<Auteur> afficherAuteur();


    @WebMethod
    public void ajouterAuteur(Auteur auteur);

    @WebMethod
    public void supprimerAuteur(@WebParam(name = "iD") Integer id);

    @WebMethod
    public void modifierAuteur(Auteur auteur);

    @WebMethod
    public List<Editeur> afficherEditeur();


    @WebMethod
    public void ajouterEditeur(Editeur editeur);

    @WebMethod
    public void supprimerEditeur(@WebParam(name = "iD") Integer id);

    @WebMethod
    public void modifierEditeur(Editeur editeur);

    @WebMethod
    public List<Exemplaire> afficherExemplaire();


    @WebMethod
    public void ajouterExemplaire(Exemplaire exemplaire);

    @WebMethod
    public void supprimerExemplaire(@WebParam(name = "iD") Integer id);

    @WebMethod
    public void modifierExemplaire(Exemplaire exemplaire);

    @WebMethod
    public List<EditionOuvrage> afficherVersion();


    @WebMethod
    public void ajouterVersion(EditionOuvrage editionOuvrage);

    @WebMethod
    public void supprimerVersion(@WebParam(name = "iD") Integer id);

    @WebMethod
    public void modifierVersion(EditionOuvrage editionOuvrage);

    @WebMethod
    public List<Ouvrage> ListerlesOuvrages();

    @WebMethod
    public List<OuvrageGenre> ListerlesOuvrageparGenre(@WebParam(name = "iD") Integer id);

    @WebMethod
    public void ajouterOuvrage(Ouvrage ouvrage);

    @WebMethod
    public void supprimerOuvrage(@WebParam(name = "iD") Integer id);

    @WebMethod
    public void ModifierOuvrage(Ouvrage ouvrage);

    @WebMethod
    public Ouvrage rechercherparOuvrage(@WebParam(name = "intituleOuvrage") String intituleOuvrage);

    @WebMethod
    public Ouvrage rechercherparISBN(@WebParam(name = "isbn") String isbn);


    @WebMethod
    public List<Exemplaire> ListerlesExemplairesparintitule(@WebParam(name ="ouvrageid" ) Integer ouvrageid);

    @WebMethod
    public List<OuvrageGenre> multicriterouvgenre(@WebParam(name = "id") Integer id);

    @WebMethod
    public List<Ouvrage> multichoix(@WebParam(name = "id") Integer id,@WebParam(name = "nauid")Integer nauid);

    @WebMethod
    public Bibliotheque affichebiblio(@WebParam(name = "id") int id);

    @WebMethod
    public List<Bibliotheque> listerlesbibliotheques();

    @WebMethod
    public Exemplaire afficherexemplairebyID(@WebParam(name = "id") Integer id);

    @WebMethod
    public Exemplaire changestatusexemplaire(Exemplaire exemplaire);
}