package org.biblio.p7.contract;

import org.biblio.p7.bean.Reservation;

import java.util.List;

public interface ReservationDao {


    public List<Reservation> listerlesreservations();

    public void ajouterUneReservation(Reservation reservation);

    public Reservation supprimerReservation(Integer iD);

    public Reservation modifieReservation(Reservation reservation);

    public List <Reservation> listerlesreservationparlecteur(int iD);

    public List <Reservation> listerlesreservationparouvrage(int iD);





}
