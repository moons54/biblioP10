package org.biblio.p7.managerimpl;

import org.biblio.p7.bean.Exemplaire;
import org.biblio.p7.bean.Reservation;
import org.biblio.p7.manager.ReservationManager;

import java.util.List;

public class ReservationManagerImpl extends AbstractManagerImpl implements ReservationManager {
    @Override
    public List<Reservation> Listerlesreservation() {
        return getDaoFactory().getReservationDao().listerlesreservations();
    }

    @Override
    public void ajouterunereservation(Reservation reservation) {
    getDaoFactory().getReservationDao().ajouterUneReservation(reservation);
    }

    @Override
    public Reservation modierunereservation(Reservation reservation) {
        return getDaoFactory().getReservationDao().modifieReservation(reservation);
    }

    @Override
    public Reservation supprimerunereservation(int iD) {
        return getDaoFactory().getReservationDao().supprimerReservation(iD);
    }

    @Override
    public List<Reservation> listerlesreservationparlecteur(int iD) {
        return getDaoFactory().getReservationDao().listerlesreservationparlecteur(iD);
    }

    @Override
    public List<Reservation> listerlesreservationparouvrage(int iD) {
        return getDaoFactory().getReservationDao().listerlesreservationparouvrage(iD);
    }

    @Override
    public Reservation addreservation(Reservation reservation) {

       /* List<Reservation> maliste=getDaoFactory().getReservationDao().listerlesreservationparouvrage(reservation.getOuvrage().getiD());
        List<Exemplaire> exemplaireList=getDaoFactory().getExemplaireDao().afficherExemplaire();
        for (Exemplaire exemplaire:exemplaireList){
            if(exemplaire.getOuvrage()!=reservation.getOuvrage()){
                exemplaireList.remove(exemplaire);
            }
        }
        System.out.println("affiche la taille de ma liste d'exemplaire"+ exemplaireList.size());


        if (maliste.size()<3){


        }*/
        return getDaoFactory().getReservationDao().addreservation(reservation);
    }

    @Override
    public boolean controlereservation(Reservation reservation) {

     //   List<Reservation> maliste=getDaoFactory().getReservationDao().listerlesreservationparouvrage(2);
        List<Exemplaire> exemplaireList=getDaoFactory().getExemplaireDao().afficherExemplaire();
        for (Exemplaire exemplaire:exemplaireList){
            if(exemplaire.getOuvrage()!=reservation.getOuvrage()){
                exemplaireList.remove(exemplaire);
            }
        }
        System.out.println("affiche la taille de ma liste d'exemplaire"+ exemplaireList.size());

        return false;
    }
}
