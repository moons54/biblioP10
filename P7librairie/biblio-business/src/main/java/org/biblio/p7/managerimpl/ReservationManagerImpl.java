package org.biblio.p7.managerimpl;

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


}
