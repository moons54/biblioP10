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

    public ReservationDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate){this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;}



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
//---------------ENSEMBLE DES METHODES-----------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------------------------//

    //CORRECTED TICKET 3
    //REFACTORISATION DES METHODES RESERVATION

    //------------------------------------------------------//
    //---------------LES METHODES D'AFFICHAGE---------------//
    //------------------------------------------------------//

    //-1)------------AFFICHER LES RESERVATIONS------------------------------------------------------------//

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

    //-2)------------AFFICHER LES RESERVATIONS PAR LECTEUR-------------------------------------------------//

    private static String querySqlListerLesReservationsParLecteur(){
        return "SELECT * FROM public.reservation where lecteurid = :lecteurid";
    }

    public List<Reservation> getQueryListerLesReservationParLecteur(NamedParameterJdbcTemplate vJdbcTemplate, MapSqlParameterSource vSqlParams,ReservationRM reservationRM){
        return vJdbcTemplate.query(querySqlListerLesReservationsParLecteur(),vSqlParams,reservationRM);
    }

    @Override
    public List<Reservation> listerlesreservationparlecteur(int lecteurid) {
        NamedParameterJdbcTemplate vJdbcTemplate = getNameParameterJdbcTemplate();

        MapSqlParameterSource vSqlParams = new MapSqlParameterSource();
        vSqlParams.addValue("lecteurid", lecteurid);
        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=getQueryListerLesReservationParLecteur(vJdbcTemplate,vSqlParams,reservationRM);
        return reservationList;
    }
    //-3)------------AFFICHER LES RESERVATIONS PAR OUVRAGE-------------------------------------------------//

    private static String querySqlListerLesReservationParOuvrage(){
        return "SELECT * FROM public.reservation where ouvrageid = :ouvrageid";
    }

    public List<Reservation> getQueryListerLesReservationParOuvrage(NamedParameterJdbcTemplate vJdbcTemplate, MapSqlParameterSource vSqlParams,ReservationRM reservationRM){
        return vJdbcTemplate.query(querySqlListerLesReservationParOuvrage(),vSqlParams,reservationRM);
    }

    @Override
    public List<Reservation> listerlesreservationparouvrage(int ouvrageid) {
      //  NamedParameterJdbcTemplate jdbcTemplate= getJdbcTemplate();
        NamedParameterJdbcTemplate vJdbcTemplate = getNameParameterJdbcTemplate();

        MapSqlParameterSource vSqlParams = new MapSqlParameterSource();
        vSqlParams.addValue("ouvrageid", ouvrageid);
        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=getQueryListerLesReservationParOuvrage(vJdbcTemplate,vSqlParams,reservationRM);

        return reservationList;
    }
    //-4)------------AFFICHER LES RESERVATIONS PAR PRIORITE-------------------------------------------------//

    private static String querySqlListerLesReservationParPriorité(){
        return "SELECT * FROM public.reservation where ouvrageid = :ouvrageid";
    }

    public List<Reservation> getQueryListerLesReservationParPriorite(NamedParameterJdbcTemplate vJdbcTemplate, MapSqlParameterSource vSqlParams,ReservationRM reservationRM){
        return vJdbcTemplate.query(querySqlListerLesReservationParPriorité(),vSqlParams,reservationRM);
    }

    public List<Reservation> listerLesReservationParPriorite(int ouvrageid) {
        LOGGER.info("dans la methode listerlesresaparpriorite");
        System.out.println("numero de l'ouvrage   " +ouvrageid);
        NamedParameterJdbcTemplate vJdbcTemplate = getNameParameterJdbcTemplate();

        MapSqlParameterSource vSqlParams = new MapSqlParameterSource();
        vSqlParams.addValue("ouvrageid", ouvrageid);

        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=getQueryListerLesReservationParPriorite(vJdbcTemplate,vSqlParams,reservationRM);

        return reservationList;
    }

    //-5)------------AFFICHER LES RESERVATIONS NOTIFIES-------------------------------------------------//

    private static String querySqlListerLesReservationNotifie(){
        return "SELECT * FROM public.reservation where notification=true";
    }

    public List<Reservation> getQueryListerLesReservationParNotification(JdbcTemplate jdbcTemplate,ReservationRM reservationRM) {
        return jdbcTemplate.query(querySqlListerLesReservationNotifie(),reservationRM);
    }

    public List<Reservation> listerLesReservationnNotifie() {
        JdbcTemplate jdbcTemplate= getJdbcTemplate();
        ReservationRM reservationRM=new ReservationRM();
        List<Reservation> reservationList=getQueryListerLesReservationParNotification(jdbcTemplate,reservationRM);

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

    protected void addreservationQuery(NamedParameterJdbcTemplate vJdbcTemplate,MapSqlParameterSource vSqlParams,String querySqlAjoutReservation){
        vJdbcTemplate.update(querySqlAjoutReservation,vSqlParams);
    }


    public Reservation addreservation(Reservation reservation) {
        MapSqlParameterSource vParams= new MapSqlParameterSource()
                .addValue("ouvrage",reservation.getOuvrage().getiD())
                .addValue("dateDemande", new Date())
                .addValue("notification",false)
                .addValue("dateNotification",null)
                .addValue("lecteur",reservation.getLecteur().getId());
        NamedParameterJdbcTemplate vJdbcTemplate=getNameParameterJdbcTemplate();
        addreservationQuery(vJdbcTemplate,vParams,querySqlAjoutReservation());
        return reservation;
    }

    private MapSqlParameterSource getMapSqlParameterSource() {
        return new MapSqlParameterSource();
    }

//-----------------------------------------------------------------------------------------------------------------//
//---------------METHODES D"Annulation de reservation--------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------------------------//

    private static String queryAnnuleReservation(){
        return "DELETE from reservation where id = :id";
    }

    protected void annulereservationQuery(NamedParameterJdbcTemplate vJdbcTemplate,MapSqlParameterSource vSqlParams,String querySqlAjoutReservation){
        vJdbcTemplate.update(querySqlAjoutReservation,vSqlParams);
    }




    @Override
    public Reservation supprimerReservation(Integer iD) {
     //  JdbcTemplate jdbcTemplate= getJdbcTemplate();
        NamedParameterJdbcTemplate vJdbcTemplate = getNameParameterJdbcTemplate();

        MapSqlParameterSource vSqlParams = new MapSqlParameterSource();
        vSqlParams.addValue("id", iD);

        ReservationRM reservationRM=new ReservationRM();
        annulereservationQuery(vJdbcTemplate,vSqlParams,queryAnnuleReservation());
       // addreservationQueryupdate(vsql,new Object[]{iD});
        return null;
    }



//-----------------------------------------------------------------------------------------------------------------//
//---------------METHODES De modification de reservation--------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------------------------//


    private static String queryModifieReservation(){
        return "update reservation set ouvrageid = :ouvrageid,date_de_demande = :dateDemande,notification = :notification,date_notification = :dateNotification,lecteurid = :lecteurid where id = :id";

    }

        protected void modifiereservationQuery(NamedParameterJdbcTemplate vJdbcTemplate,MapSqlParameterSource vSqlParams,String querySqlAjoutReservation){
        vJdbcTemplate.update(queryModifieReservation(),vSqlParams);
    }


    @Override
    public Reservation modifieReservation(Reservation reservation) {
        LOGGER.warn("dans la methode modifier reservation");
       // String vsql="update reservation set ouvrageid=:ouvrage,date_de_demande=:dateDemande,notification=:notification,date_notification=:dateNotification,lecteurid=:lecteur where id=:id";
        NamedParameterJdbcTemplate vJdbcTemplate = getNameParameterJdbcTemplate();

      //  MapSqlParameterSource vSqlParams = new MapSqlParameterSource();

        MapSqlParameterSource vParams= getMapSqlParameterSource()
                .addValue("ouvrageid",reservation.getOuvrage().getiD())
                .addValue("dateDemande", reservation.getDateDemande())
                .addValue("notification",reservation.getNotification())
                .addValue("dateNotification",new Date())
                .addValue("lecteurid",reservation.getLecteur().getId())
                .addValue("id",reservation.getiD());
       // NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
       // jdbcTemplate.update(vsql,vParams);
        modifiereservationQuery(vJdbcTemplate,vParams,queryModifieReservation());
        return reservation;
    }







}

