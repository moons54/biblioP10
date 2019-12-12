package org.biblio.p7.service;

import org.biblio.p7.bean.Reservation;
import org.biblio.p7.managerimpl.ManagerFactoryImpl;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    private ManagerFactoryImpl managerFactory;


    public ManagerFactoryImpl getManagerFactory() {
        return managerFactory;
    }

    public void setManagerFactory(ManagerFactoryImpl managerFactory) {
        this.managerFactory = managerFactory;
    }

    @Override
    public List<Reservation> Listerlesreservation() {
        return getManagerFactory().getReservationManager().Listerlesreservation();
    }

    @Override
    public void ajouterunereservation(Reservation reservation) {
getManagerFactory().getReservationManager().ajouterunereservation(reservation);
    }

    @Override
    public Reservation modifierunereservation(Reservation reservation) {
        return getManagerFactory().getReservationManager().modierunereservation(reservation);
    }

    @Override
    public Reservation supprimerunereservation(int iD) {
        return getManagerFactory().getReservationManager().supprimerunereservation(iD);
    }

    @Override
    public List<Reservation> listerlesreservationparlecteur(int iD) {
        return getManagerFactory().getReservationManager().listerlesreservationparlecteur(iD);
    }

    @Override
    public List<Reservation> listerlesreservationparouvrage(int iD) {
        return getManagerFactory().getReservationManager().listerlesreservationparlecteur(iD);
    }


    //CORRECTED TICKET 1 Ajout de la methode ajout d'une reservation
    @Override
    public Reservation addreservation(Reservation reservation) {
        return getManagerFactory().getReservationManager().addreservation(reservation);
    }


    @Override
    public boolean controlereservation(Reservation reservation) {
        return getManagerFactory().getReservationManager().controlereservation(reservation);
    }
}
