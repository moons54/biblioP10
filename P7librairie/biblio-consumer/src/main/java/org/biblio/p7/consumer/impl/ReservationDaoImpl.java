package org.biblio.p7.consumer.impl;

import org.biblio.p7.bean.Reservation;
import org.biblio.p7.consumer.impl.RowMapper.ReservationRM;
import org.biblio.p7.contract.ReservationDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

public class ReservationDaoImpl extends AbstractDaoimpl implements ReservationDao {


    @Override
    public List<Reservation> listerlesreservations() {
        String vsql="SELECT * FROM public.reservation";
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=jdbcTemplate.query(vsql,reservationRM);
        return reservationList;
    }

    @Override
    public void ajouterUneReservation(Reservation reservation) {
        String vsql="INSERT into public.reservation(ouvrageid, date_de_demande, notification, date_notification, lecteurid) values "+
                "(:ouvrageId,:dateDemande,:notification,:dateNotification,:lecteurId)";
        SqlParameterSource vParams=new BeanPropertySqlParameterSource(reservation);
        NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        jdbcTemplate.update(vsql,vParams);
    }

    @Override
    public Reservation supprimerReservation(Integer iD) {
        String vsql="DELETE from reservation where id=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
        jdbcTemplate.update(vsql,new Object[]{iD});
        return null;
    }

    @Override
    public Reservation modifieReservation(Reservation reservation) {
        String vsql="update reservation set id=:id,ouvrageid=:ouvrage,date_de_demande=:date_de_demande,notification=:notification,date_notification=:date_notification";
        SqlParameterSource vParams=new MapSqlParameterSource()
                .addValue("id",reservation.getiD())
                .addValue("ouvrage",reservation.getOuvrage().getiD())
                .addValue("date_de_demande",reservation.getDateDemande())
                .addValue("notification",true)
                .addValue("date_notification",reservation.getDateNotification());

        NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        jdbcTemplate.update(vsql,vParams);

        return reservation;
    }

    @Override
    public List<Reservation> listerlesreservationparlecteur(int iD) {
        String vsql="SELECT * FROM public.reservation where lecteurid=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=jdbcTemplate.query(vsql,new Object[]{iD},reservationRM);

        return reservationList;
    }

    @Override
    public List<Reservation> listerlesreservationparouvrage(int iD) {
        String vsql="SELECT * FROM public.reservation where ouvrageid=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=jdbcTemplate.query(vsql,new Object[]{iD},reservationRM);

        return reservationList;
    }


}

