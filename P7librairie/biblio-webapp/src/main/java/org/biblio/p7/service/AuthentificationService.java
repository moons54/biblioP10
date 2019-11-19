package org.biblio.p7.service;

import org.biblio.p7.bean.Coordonnees;
import org.biblio.p7.bean.Lecteur;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName  = "AuthentificationService")
public interface AuthentificationService {

   @WebMethod
   public List<Lecteur> rechercherlesLecteurs();

   @WebMethod
   public void ajouterLecteur(Lecteur lecteur);

   @WebMethod
   public void modifierLecteur(Lecteur lecteur);

   @WebMethod
   public Lecteur rechercher(@WebParam(name="iD")Integer iD);

   @WebMethod
   public Lecteur rechercherparNom(@WebParam(name="nom")String nom);


   @WebMethod
   public Lecteur controlerLecteur(@WebParam(name = "identifiant")String identifiant,@WebParam(name = "motDepasse") String motDePasse);

   @WebMethod
   public void supprimerLecteur(@WebParam(name = "iD") Integer id);

   @WebMethod
   public Coordonnees recherchercoordonnee(@WebParam(name="iD")Integer iD);

   @WebMethod
   public List<Coordonnees> coordonneesparlecteur(Integer iD);

   @WebMethod
   public void ajouterCoordonnees(Coordonnees coordonnees);

   @WebMethod
   public void modifierCooronnees(Coordonnees coordonnees);

}
