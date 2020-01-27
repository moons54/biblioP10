package org.biblio.p7;

import org.biblio.p7.bean.*;
import org.biblio.p7.managerimpl.ReservationManagerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationManagerImplTest {

    ReservationManagerImpl reservationManager;
    @Mock
    Lecteur lecteur;

    @Mock
    Ouvrage ouvrage;

    @Mock
    Auteur auteur;

    @Mock
    List<Editeur> editeur;

    @Mock
    List<Genre> genre;

    @Mock
    Reservation reservationMock;

    @Before
    public void initialize(){
        reservationManager = new ReservationManagerFake();

    }

    @Test
    public void ListerlesreservationTest() {
       List<Reservation> reservationList = new ArrayList<>();
        Reservation reservation = new Reservation(1, new Date(), true, new Date(), ouvrage, lecteur);
        Reservation reservation2 = new Reservation(4, new Date(), true, new Date(), ouvrage, lecteur);
        reservationList.add(reservation);
        reservationList.add(reservation2);
        Assert.assertEquals(reservationList.size(), reservationManager.Listerlesreservation().size());
    }


    @Test
    public void addreservationTest() {
        Reservation reservation = new Reservation(1, new Date(), true, new Date(), ouvrage, lecteur);
        Assert.assertNotNull(reservation.toString() , reservationManager.addreservation(reservation));
    }

    @Test
    public void listerlesreservationparprioriteTest_retournerlareservationclassepardatededemande(){


      List <Reservation> reservationListTest = reservationManager.listerLesReservationParPriorite(2);

      Assert.assertEquals(4,reservationListTest.get(0).getiD());

    }

    @Test
    public void listerlesreservationparprioriteTest_retourneunereservation() {


        List <Reservation> reservationListTest = reservationManager.listerLesReservationParPriorite(2);

        Assert.assertEquals(1,reservationListTest.size());

    }



    public class ReservationManagerFake extends ReservationManagerImpl {



        @Override
    public List<Reservation> Listerlesreservation() {
        List<Reservation> reservationListTest = new ArrayList<>();
        Reservation reservation = new Reservation(1, new Date(), true, new Date(), ouvrage, lecteur);
        Reservation reservation2 = new Reservation(4, new Date(), true, new Date(), ouvrage, lecteur);
        reservationListTest.add(reservation);
        reservationListTest.add(reservation2);
    return reservationListTest;
    }


        @Override
        public Reservation addreservation(Reservation reservation) {

            return reservation;
        }

        @Override
        public List<Reservation> listerLesReservationParPriorite(int iD) {
            List<Reservation> reservationListTest = new ArrayList<>();

            Ouvrage ouvrage1 = new Ouvrage();
            ouvrage1.setiD(2);
            ouvrage1.setAuteur(auteur);
            ouvrage1.setDescription("test");
            ouvrage1.setEditeurs(editeur);
            ouvrage1.setGenres(genre);
            ouvrage1.setIntituleOuvrage("nom test");
            ouvrage1.setPhoto("maphoto1");


            Reservation reservation = new Reservation(4, new Date(), true, new Date(), ouvrage1, lecteur);

            Reservation reservation2 = new Reservation(1, new Date(), true, new Date(), ouvrage1, lecteur);
            reservationListTest.add(reservation);
            reservationListTest.add(reservation2);
            Collections.sort(reservationListTest,Reservation.comparatorDatedemande);

            List<Reservation> reservationList1 = reservationListTest.stream()
                    .limit(1)
                    .collect(Collectors.toList());
            return reservationList1;
        }
    }


}
