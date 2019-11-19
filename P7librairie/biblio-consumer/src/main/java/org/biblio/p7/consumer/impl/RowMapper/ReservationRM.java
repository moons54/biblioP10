package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.Reservation;
import org.biblio.p7.consumer.impl.LecteurDaoImpl;
import org.biblio.p7.consumer.impl.OuvrageDaoImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationRM implements RowMapper<Reservation> {
    @Override
    public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reservation reservation=new Reservation();
        reservation.setiD(rs.getInt("id"));
        reservation.setDateDemande(rs.getDate("date_de_demande"));
        reservation.setNotification(rs.getBoolean("notification"));
        reservation.setDateNotification(rs.getDate("date_notification"));



        //insertion du resultat d'un ouvrage
        OuvrageDaoImpl ouvrageDao=new OuvrageDaoImpl();
        reservation.setOuvrage(ouvrageDao.afficherOuvrage().get(rs.getInt("ouvrageid")));


        //insertion du resultat d'un lecteur
        LecteurDaoImpl lecteurDao=new LecteurDaoImpl();
        reservation.setLecteur(lecteurDao.rechercher(rs.getInt("lecteurid")));
        return reservation;
    }
}
