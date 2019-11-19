package org.biblio.p7.service;

import org.biblio.p7.bean.Emprunt;
import org.biblio.p7.bean.SituationDemprunt;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName  = "PretService")
public interface PretService {

    @WebMethod
    public List<Emprunt> afficherlesemprunts();

    @WebMethod
    public void ajouterunemprunt(Emprunt emprunt);

    @WebMethod
    public Emprunt supprimerEmprunt(@WebParam(name = "iD") Integer iD);

    @WebMethod
    public Emprunt modifierEmprunt(Emprunt emprunt);

    @WebMethod
    public Emprunt rechercherEmpruntparId(@WebParam(name = "iD") Integer iD);

    @WebMethod
    public List<Emprunt> afficherlesempruntsparsituation(@WebParam(name = "iD")Integer iD);

    @WebMethod
    public List<Emprunt> afficherlesempruntsenretard();

    @WebMethod
    public List<Emprunt> afficherlesempruntsparLecteur(@WebParam(name = "iD")Integer iD);

    @WebMethod
    public List<Emprunt> afficherleslivresdisponible();

    @WebMethod
    public List<Emprunt> afficherlesempruntbyexmemplaire(@WebParam(name = "iD")Integer iD);

    @WebMethod
    public Emprunt rechercherEmpruntparexp(@WebParam(name = "iD") Integer iD);

    @WebMethod
    public List<Emprunt> rechercherEmpruntparisbn(@WebParam(name = "isbn") String isbn);

    @WebMethod
    public List<Emprunt> afficherlesempruntsparLecteurencours(@WebParam(name = "id") Integer iD);

    @WebMethod
    public Emprunt addemprunt(Emprunt emprunt);

    @WebMethod
    public SituationDemprunt recherchersituationdemprunt(@WebParam(name = "id") int id);

    @WebMethod
    public Emprunt changestatutemprunt(Emprunt emprunt);

    @WebMethod
    public List<Emprunt> afficherlesempruntsenretarparLecteur(@WebParam(name = "id") Integer iD);

    @WebMethod
    public List<Emprunt> regrouperlesempruntsenretard();
}
