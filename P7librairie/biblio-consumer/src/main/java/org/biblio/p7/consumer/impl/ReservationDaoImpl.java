package org.biblio.p7.consumer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.biblio.p7.bean.Reservation;
import org.biblio.p7.consumer.impl.RowMapper.ReservationRM;
import org.biblio.p7.contract.ReservationDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class ReservationDaoImpl extends AbstractDaoimpl implements ReservationDao {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(ReservationDao.class);

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    public ReservationDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


    //Constructeur
    public ReservationDaoImpl() {
        super();
    }


    public static Date ajouterJour(Date date, int nbJour) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, nbJour);
        return cal.getTime();
    }
//-----------------------------------------------------------------------------------------------------------------//
//---------------ENSEMBLE DES METHODES D"AFFICHAGE-----------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------------------------//

    //CORRECTED TICKET 3
    //REFACTORISATION DES METHODES RESERVATION


    private static String querySqlListerLesReservations() {
        return "SELECT * FROM public.reservation";
    }

    public List<Reservation> getQueryListerLesReservations(JdbcTemplate jdbcTemplate,ReservationRM reservationRM){
        return jdbcTemplate.query(querySqlListerLesReservations(),reservationRM);
    }

    @Override
    public List<Reservation> listerlesreservations() {
        JdbcTemplate jdbcTemplate= getJdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=getQueryListerLesReservations(jdbcTemplate,reservationRM);
        return reservationList;
    }

   private static String querySqlListerLesReservationsParLecteur(){
        return "SELECT * FROM public.reservation where lecteurid=?";
    }

    public List<Reservation> getQueryListerLesReservationParLecteur(JdbcTemplate jdbcTemplate,int iD,ReservationRM reservationRM){
        return jdbcTemplate.query(querySqlListerLesReservationsParLecteur(),new Object[]{iD},reservationRM);
    }


    @Override
    public List<Reservation> listerlesreservationparlecteur(int iD) {
        String vsql="SELECT * FROM public.reservation where lecteurid=?";
        JdbcTemplate jdbcTemplate= getJdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
//        List<Reservation> reservationList=jdbcTemplate.query(vsql,new Object[]{iD},reservationRM);
    List<Reservation> reservationList=getQueryListerLesReservationParLecteur(jdbcTemplate,iD,reservationRM);
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
//-----------------------------------------------------------------------------------------------------------------//
//---------------ENSEMBLE DES METHODES D"Insertion de reservation--------------------------------------------------//
//-----------------------------------------------------------------------------------------------------------------//

private static String querySqlAjoutReservation(){
        return "INSERT into public.reservation(ouvrageid, date_de_demande, notification, date_notification, lecteurid) VALUES "+
                "(:ouvrage,:dateDemande,:notification,:dateNotification,:lecteur)";
}

    public Reservation addreservation(Reservation reservation) {
        LOGGER.warn("dans la methode addreservation");
      /*  String vSQL="INSERT into public.reservation(ouvrageid, date_de_demande, notification, date_notification, lecteurid) VALUES "+
                "(:ouvrage,:dateDemande,:notification,:dateNotification,:lecteur)";*/
        SqlParameterSource vParams= getMapSqlParameterSource()
                .addValue("ouvrage",reservation.getOuvrage().getiD())
                .addValue("dateDemande", new Date())
                .addValue("notification",false)
                .addValue("dateNotification",null)
                .addValue("lecteur",reservation.getLecteur().getId());
       NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(querySqlAjoutReservation(),vParams);
        return reservation;
    }

    private MapSqlParameterSource getMapSqlParameterSource() {
        return new MapSqlParameterSource();
    }


    @Override
    public Reservation supprimerReservation(Integer iD) {
        String vsql="DELETE from reservation where id=?";
        JdbcTemplate jdbcTemplate= getJdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
        jdbcTemplate.update(vsql,new Object[]{iD});
        return null;
    }



    @Override
    public Reservation modifieReservation(Reservation reservation) {
        LOGGER.warn("dans la methode modifier reservation");
        String vsql="update reservation set ouvrageid=:ouvrage,date_de_demande=:dateDemande,notification=:notification,date_notification=:dateNotification,lecteurid=:lecteur where id=:id";
        SqlParameterSource vParams= getMapSqlParameterSource()
                .addValue("ouvrage",reservation.getOuvrage().getiD())
                .addValue("dateDemande", reservation.getDateDemande())
                .addValue("notification",reservation.getNotification())
                .addValue("dateNotification",new Date())
                .addValue("lecteur",reservation.getLecteur().getId())
                .addValue("id",reservation.getiD());
        NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        jdbcTemplate.update(vsql,vParams);

        return reservation;
    }



    @Override
    public List<Reservation> listerlesreservationparouvrage(int iD) {
        String vsql="SELECT * FROM public.reservation where ouvrageid=?";
        JdbcTemplate jdbcTemplate= getJdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=jdbcTemplate.query(vsql,new Object[]{iD},reservationRM);

        return reservationList;
    }
    public List<Reservation> listerLesReservationParPriorite(int iD) {
        LOGGER.info("dans la methode listerlesresaparpriorite");
        String vsql="SELECT * FROM public.reservation where ouvrageid=?";
        JdbcTemplate jdbcTemplate= getJdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=jdbcTemplate.query(vsql,new Object[]{iD},reservationRM);

        return reservationList;
    }


    public List<Reservation> listerLesReservationnNotifie() {
        String vsql="SELECT * FROM public.reservation where notification=true";
        JdbcTemplate jdbcTemplate= getJdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=jdbcTemplate.query(vsql,reservationRM);

        return reservationList;
    }



}

