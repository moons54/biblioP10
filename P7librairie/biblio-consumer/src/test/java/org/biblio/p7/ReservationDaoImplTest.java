package org.biblio.p7;


import javafx.beans.binding.When;
import org.biblio.p7.bean.Lecteur;
import org.biblio.p7.bean.Ouvrage;
import org.biblio.p7.bean.Reservation;
import org.biblio.p7.consumer.impl.ReservationDaoImpl;
import org.biblio.p7.consumer.impl.RowMapper.ReservationRM;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReservationDaoImplTest {


    ReservationDaoImpl reservationDao;


    @Mock
    Ouvrage ouvrage;

    @Mock
    Lecteur lecteur;

    @Before
    public void initialize() {
        reservationDao = new ReservationDaoFake();
    }


    @Test
    public void ListerlesReservationTest() {

      List<Reservation> reservationListTest=reservationDao.listerlesreservations();
      Assert.assertEquals("true",reservationListTest.get(0).getNotification().toString());
    }

    @Test
    public void ListerlesReservationparLecteur(){
       List<Reservation> reservationListTest=reservationDao.listerlesreservationparlecteur(1);
        Assert.assertEquals(true,reservationListTest.get(0).getNotification().booleanValue());
    }

    public Reservation jeureservation() {
        Reservation reservation = new Reservation(1, new Date(), true, new Date(), ouvrage, lecteur);
        return reservation;
    }

    private class ReservationDaoFake extends ReservationDaoImpl {

        public JdbcTemplate getJdbcTemplate() {
            return null;
        }

        public MapSqlParameterSource getMapSqlParameterSource(){
            return null;
        }

        @Override
        public List<Reservation> getQueryListerLesReservations(JdbcTemplate jdbcTemplate, ReservationRM reservationRM) {
            List<Reservation> reservationList=new ArrayList<>();
            lecteur.setId(1);
            Reservation reservation = new Reservation(1, new Date(), true, new Date(), ouvrage, lecteur);
            lecteur.setId(3);
            Reservation reservation2 = new Reservation(4, new Date(), false, new Date(), ouvrage, lecteur);

            reservationList.add(reservation);
            reservationList.add(reservation2);

            return reservationList;
        }
    }
}


