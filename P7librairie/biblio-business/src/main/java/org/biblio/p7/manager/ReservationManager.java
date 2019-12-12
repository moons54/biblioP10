package org.biblio.p7.manager;

import org.biblio.p7.bean.Ouvrage;
import org.biblio.p7.bean.Reservation;

import java.util.List;

public interface ReservationManager {

    public List<Reservation> Listerlesreservation();

    public void ajouterunereservation(Reservation reservation);

    public Reservation modierunereservation(Reservation reservation);

    public Reservation supprimerunereservation(int iD);

    public List<Reservation> listerlesreservationparlecteur(int iD);

    public List<Reservation> listerlesreservationparouvrage(int iD);

    public Reservation addreservation(Reservation reservation);


    public boolean controlereservation(Reservation reservation);


}
