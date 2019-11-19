package org.biblio.p7.managerimpl;

import org.biblio.p7.bean.Emprunt;
import org.biblio.p7.bean.Exemplaire;
import org.biblio.p7.bean.SituationDemprunt;
import org.biblio.p7.manager.EmpruntManager;

import java.util.Date;
import java.util.List;

public class EmpruntManagerImpl extends AbstractManagerImpl implements EmpruntManager {
    @Override
    public List<Emprunt> afficherlesemprunts() {
        return getDaoFactory().getEmpruntDao().afficherlesemprunts();
    }

    @Override
    public void ajouterunemprunt(Emprunt emprunt) {
        emprunt.setDateDebut(new Date());
        emprunt.setDateFin(new Date());
        emprunt.setDateRetourEffectif(new Date());
        emprunt.setRenouvellement(true);

        Exemplaire exemplaire;
        exemplaire =getDaoFactory().getExemplaireDao().rechercherExemplaire(emprunt.getiD());
        exemplaire.setStatus("1");
        getDaoFactory().getExemplaireDao().modifierExemplaire(exemplaire);

        getDaoFactory().getEmpruntDao().ajouterunemprunt(emprunt);



    }

    @Override
    public Emprunt supprimerEmprunt(Integer iD) {
        return getDaoFactory().getEmpruntDao().supprimerEmprunt(iD);
    }

    @Override
    public Emprunt modifierEmprunt(Emprunt emprunt) {

        return getDaoFactory().getEmpruntDao().modifierEmprunt(emprunt);
    }

    @Override
    public Emprunt rechercherEmpruntparId(Integer iD) {
        return getDaoFactory().getEmpruntDao().rechercherEmpruntparId(iD);
    }

    @Override
    public List<Emprunt> afficherlesempruntsparsituation(Integer iD) {
        return getDaoFactory().getEmpruntDao().afficherlesempruntsparsituation(iD);
    }

    @Override
    public List<Emprunt> afficherlesempruntsenretard() {
        return getDaoFactory().getEmpruntDao().afficherlesempruntsenretard();
    }

    @Override
    public List<Emprunt> afficherlesempruntsparLecteur(Integer iD) {
        return getDaoFactory().getEmpruntDao().afficherlesempruntsparLecteur(iD);
    }

    @Override
    public List<Emprunt> afficherleslivresdisponible() {
        return getDaoFactory().getEmpruntDao().afficherleslivresdisponible();
    }

    @Override
    public List<Emprunt> afficherlesempruntbyexmemplaire(Integer iD) {
        return getDaoFactory().getEmpruntDao().afficherlesempruntbyexmemplaire(iD);
    }

    @Override
    public Emprunt rechercherEmpruntparexp(Integer iD){
        return  getDaoFactory().getEmpruntDao().rechercherEmpruntparexp(iD);
    }

    @Override
    public List<Emprunt> rechercherEmpruntparisbn(String isbn){
        return getDaoFactory().getEmpruntDao().rechercherEmpruntparisbn(isbn);
    }
    @Override
    public List<Emprunt> afficherlesempruntsparLecteurencours(Integer iD){
        return getDaoFactory().getEmpruntDao().afficherlesempruntsparLecteurencours(iD);
    }

    public Emprunt addemprunt(Emprunt emprunt){
       /* Exemplaire exemplaire;
        exemplaire =getDaoFactory().getExemplaireDao().rechercherExemplaire(emprunt.getiD());
        exemplaire.setStatus("1");
        getDaoFactory().getExemplaireDao().modifierExemplaire(exemplaire);*/

       getDaoFactory().getExemplaireDao().changestatusexemplaire(emprunt.getExemplaire());

        return getDaoFactory().getEmpruntDao().addemprunt(emprunt);
    }

    public SituationDemprunt recherchersituationdemprunt(int id){
        return getDaoFactory().getEmpruntDao().recherchersituationdemprunt(id);
    };

    @Override
    public Emprunt changestatutemprunt(Emprunt emprunt){
        return  getDaoFactory().getEmpruntDao().changestatutemprunt(emprunt);
    }

    @Override
    public List<Emprunt> afficherlesempruntsenretarparLecteur(Integer iD){
        return getDaoFactory().getEmpruntDao().afficherlesempruntsenretarparLecteur(iD);
    }

    @Override
    public List<Emprunt> regrouperlesempruntsenretard(){
        return getDaoFactory().getEmpruntDao().regrouperlesempruntsenretard();
    }
}
