package org.biblio.p7.service;

import org.biblio.p7.bean.Emprunt;
import org.biblio.p7.bean.SituationDemprunt;
import org.biblio.p7.managerimpl.ManagerFactoryImpl;

import java.util.List;

public class PretServiceImpl implements  PretService {
    private ManagerFactoryImpl managerFactory;

    public ManagerFactoryImpl getManagerFactory() {
        return managerFactory;
    }

    public void setManagerFactory(ManagerFactoryImpl managerFactory) {
        this.managerFactory = managerFactory;
    }

    @Override
    public List<Emprunt> afficherlesemprunts() {

        return managerFactory.getEmpruntManager().afficherlesemprunts();
    }

    @Override
    public void ajouterunemprunt(Emprunt emprunt) {
managerFactory.getEmpruntManager().ajouterunemprunt(emprunt);
    }

    @Override
    public Emprunt supprimerEmprunt(Integer iD) {
        return getManagerFactory().getEmpruntManager().supprimerEmprunt(iD);
    }

    @Override
    public Emprunt modifierEmprunt(Emprunt emprunt) {
       return getManagerFactory().getEmpruntManager().modifierEmprunt(emprunt);
    }

    @Override
    public Emprunt rechercherEmpruntparId(Integer iD) {
        return null;
    }

    @Override
    public List<Emprunt> afficherlesempruntsparsituation(Integer iD) {
        return getManagerFactory().getEmpruntManager().afficherlesempruntsparsituation(iD);
    }

    @Override
    public List<Emprunt> afficherlesempruntsenretard() {
        return getManagerFactory().getEmpruntManager().afficherlesempruntsenretard();
    }

    @Override
    public List<Emprunt> afficherlesempruntsparLecteur(Integer iD) {
        return getManagerFactory().getEmpruntManager().afficherlesempruntsparLecteur(iD);
    }

    @Override
    public List<Emprunt> afficherleslivresdisponible() {
        return getManagerFactory().getEmpruntManager().afficherleslivresdisponible();
    }

    @Override
    public List<Emprunt> afficherlesempruntbyexmemplaire(Integer iD) {
        return getManagerFactory().getEmpruntManager().afficherlesempruntbyexmemplaire(iD);
    }


    public Emprunt rechercherEmpruntparexp(Integer iD){
        return getManagerFactory().getEmpruntManager().rechercherEmpruntparexp(iD);
    }

    public List<Emprunt> rechercherEmpruntparisbn(String isbn){
        return  getManagerFactory().getEmpruntManager().rechercherEmpruntparisbn(isbn);
    }

    public List<Emprunt> afficherlesempruntsparLecteurencours(Integer iD){
        return getManagerFactory().getEmpruntManager().afficherlesempruntsparLecteurencours(iD);
    }

    public SituationDemprunt recherchersituationdemprunt(int id){
        return getManagerFactory().getEmpruntManager().recherchersituationdemprunt(id);
    }

    public Emprunt addemprunt(Emprunt emprunt){
        return getManagerFactory().getEmpruntManager().addemprunt(emprunt);
    }

    public Emprunt changestatutemprunt(Emprunt emprunt){
        return getManagerFactory().getEmpruntManager().changestatutemprunt(emprunt);
    };

    @Override
    public List<Emprunt> afficherlesempruntsenretarparLecteur(Integer iD) {
        return getManagerFactory().getEmpruntManager().afficherlesempruntsenretarparLecteur(iD);
    }

    @Override
    public List<Emprunt> regrouperlesempruntsenretard(){
        return getManagerFactory().getEmpruntManager().regrouperlesempruntsenretard();
    }
}
