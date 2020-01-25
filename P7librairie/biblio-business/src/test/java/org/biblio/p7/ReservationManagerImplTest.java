package org.biblio.p7;

import javafx.beans.binding.When;
import org.biblio.p7.bean.Lecteur;
import org.biblio.p7.bean.Ouvrage;
import org.biblio.p7.bean.Reservation;
import org.biblio.p7.managerimpl.ManagerFactoryImpl;
import org.biblio.p7.managerimpl.ReservationManagerImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReservationManagerImplTest {

    private static ReservationManagerImpl reservationManager=mock(ReservationManagerImpl.class);

    @Mock
    Lecteur lecteur;

    @Mock
    Ouvrage ouvrage;


    @Test
    public void ListerlesreservationTest(){
       List<Reservation> reservationList=new ArrayList<>();

        Reservation reservation = new Reservation(1, new Date(), true, new Date(), ouvrage, lecteur);
        Reservation reservation2 = new Reservation(4, new Date(), true, new Date(), ouvrage, lecteur);
        reservationList.add(reservation);
        reservationList.add(reservation2);
        Assert.assertEquals(1,reservationList.get(0).getiD());
    }


    @Test
    public void addreservationTest(){
        Reservation reservation = new Reservation(1, new Date(), true, new Date(), ouvrage, lecteur);
        reservationManager.ajouterunereservation(reservation);
        Assert.assertEquals(reservation.getiD(),reservationManager.listerlesreservationparlecteur(reservation.getiD()));
    }



}
