package org.biblio.p7;

import org.biblio.p7.bean.Lecteur;
import org.biblio.p7.bean.Ouvrage;
import org.biblio.p7.bean.Reservation;
import org.biblio.p7.consumer.impl.AbstractDaoimpl;
import org.biblio.p7.consumer.impl.ReservationDaoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Date;

public class ConsumerIntegrationTest extends AbstractDaoimpl {


    ReservationDaoImpl reservationDao = new ReservationDaoImpl();


    @Mock
    Ouvrage ouvrage;

    @Mock
    Lecteur lecteur;

    @Before
    public void init() {

    }

    @Test
    public void integration() throws Exception {


        Reservation reservationTest = new Reservation(1, new Date(), true, new Date(), ouvrage, lecteur);


        //Variable renvoyant la taille du nombre de reservation
        int num = reservationDao.listerlesreservations().size();

        //----------------------------------METHODE D'INSERTION-------------------------------------------//

        reservationDao.addreservation(reservationTest);
        Assert.assertTrue(num<reservationDao.listerlesreservations().size());


        //----------------------------------METHODE DE MODIFICATION-------------------------------------------//

        reservationTest.setNotification(false);
        reservationDao.modifieReservation(reservationTest);
        Assert.assertEquals(reservationTest.getDateNotification().toString(),"true");

        //----------------------------------METHODE DE CONSULTATION-------------------------------------------//


        //----------------------------------METHODE DE SUPPRESSION-------------------------------------------//

        reservationDao.supprimerReservation(reservationTest.getiD());
        Assert.assertEquals(num,reservationDao.listerlesreservations().size());


    }
}
