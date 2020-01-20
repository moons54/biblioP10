package org.biblio.p7;


import org.biblio.p7.bean.Lecteur;
import org.biblio.p7.bean.Ouvrage;
import org.biblio.p7.bean.Reservation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReservationTest {



    List<Reservation> reservationList=new ArrayList<>();

    @Mock
    Reservation reservationMock;

    @Mock
    Reservation reservationMock2;

    @Mock
    Ouvrage ouvrageMock;

    @Mock
    Lecteur lecteurMock;

    @Before
    public void ReservationTest_JeudeDonnee(){
        Reservation reservationTest1=new Reservation(1,new Date(),true,new Date(),ouvrageMock,lecteurMock);
    }

    @Test
    public void ReservationTest_constructeur(){
        Reservation reservationTest=new Reservation(1,new Date(),true,new Date(),ouvrageMock,lecteurMock);

        Assert.assertNotNull("retourne un objet"+reservationTest);
    }

    @Test
    public void ReservationTest_controledesSetter(){
        Reservation reservationTest3=new Reservation();
        reservationTest3.setiD(6);
        reservationTest3.setDateNotification(new Date());
        reservationTest3.setNotification(true);
        reservationTest3.setLecteur(lecteurMock);
        reservationTest3.setOuvrage(ouvrageMock);
        Assert.assertNotNull(reservationTest3);


    }


    @Test
    public void comparatorDatedemandeTest_controledesdate(){

        Reservation reservationTest3=new Reservation();
        reservationTest3.setiD(6);
        reservationTest3.setDateNotification(new Date());
        reservationTest3.setNotification(true);
        reservationTest3.setLecteur(lecteurMock);
        reservationTest3.setOuvrage(ouvrageMock);

        Reservation reservationTest4=new Reservation();
        reservationTest3.setiD(3);
        reservationTest3.setDateNotification(new Date());
        reservationTest3.setNotification(true);
        reservationTest3.setLecteur(lecteurMock);
        reservationTest3.setOuvrage(ouvrageMock);

        Assert.assertNotNull(Reservation.comparatorDatedemande);

    }
}

