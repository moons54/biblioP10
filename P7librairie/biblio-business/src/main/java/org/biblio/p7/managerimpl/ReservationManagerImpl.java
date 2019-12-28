package org.biblio.p7.managerimpl;

import org.apache.commons.lang3.time.DateParser;
import org.biblio.p7.bean.Exemplaire;
import org.biblio.p7.bean.Reservation;
import org.biblio.p7.manager.ReservationManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ReservationManagerImpl extends AbstractManagerImpl implements ReservationManager {

    public static final String STATUT_RENDU = "1";
    public static final SimpleDateFormat spf=new SimpleDateFormat("yyyy MMM dd");
    public static final Calendar calendar=new GregorianCalendar();

    public static Date ajouterJour(Date date, int nbJour) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, nbJour);
        return cal.getTime();
    }
public static final Date DATE_JOUR= new Date();
//public static final LocalDate DATE_48;
//public static final Date DATE_48H= new Date()-DATE_JOUR.toInstant().get(DATE_JOUR);

    @Override
    public List<Reservation> Listerlesreservation() {
        return getDaoFactory().getReservationDao().listerlesreservations();
    }

    @Override
    public void ajouterunereservation(Reservation reservation) {
        getDaoFactory().getReservationDao().ajouterUneReservation(reservation);
    }

    @Override
    public Reservation modierunereservation(Reservation reservation) {
        return getDaoFactory().getReservationDao().modifieReservation(reservation);
    }

    @Override
    public Reservation supprimerunereservation(int iD) {
        return getDaoFactory().getReservationDao().supprimerReservation(iD);
    }

    @Override
    public List<Reservation> listerlesreservationparlecteur(int iD) {
        return getDaoFactory().getReservationDao().listerlesreservationparlecteur(iD);
    }

    @Override
    public List<Reservation> listerlesreservationparouvrage(int iD) {
        return getDaoFactory().getReservationDao().listerlesreservationparouvrage(iD);
    }

    @Override
    public Reservation addreservation(Reservation reservation) {

       /* List<Reservation> maliste=getDaoFactory().getReservationDao().listerlesreservationparouvrage(reservation.getOuvrage().getiD());
        List<Exemplaire> exemplaireList=getDaoFactory().getExemplaireDao().afficherExemplaire();
        for (Exemplaire exemplaire:exemplaireList){
            if(exemplaire.getOuvrage()!=reservation.getOuvrage()){
                exemplaireList.remove(exemplaire);
            }
        }
        System.out.println("affiche la taille de ma liste d'exemplaire"+ exemplaireList.size());


        if (maliste.size()<3){


        }*/
        return getDaoFactory().getReservationDao().addreservation(reservation);
    }

    @Override
    public boolean controlereservation(Reservation reservation) {

        //   List<Reservation> maliste=getDaoFactory().getReservationDao().listerlesreservationparouvrage(2);
        List<Exemplaire> exemplaireList = getDaoFactory().getExemplaireDao().afficherExemplaire();
        for (Exemplaire exemplaire : exemplaireList) {
            if (exemplaire.getOuvrage() != reservation.getOuvrage()) {
                exemplaireList.remove(exemplaire);
            }
        }
        System.out.println("affiche la taille de ma liste d'exemplaire" + exemplaireList.size());

        return false;
    }

    //CORRECTED TICKET 1 Lister par ordre les reservations
    @Override
    public List<Reservation> listerlesreservationsparordre(int iD) {
        List<Reservation> filedattente = getDaoFactory().getReservationDao().listerlesreservationparouvrage(iD);


     //   Collections.sort(filedattente, Reservation.comparatorDatedemande);
        //  };
        return filedattente;
    }




    @Override
    public Reservation attribuerUneReservation() {

       List<Exemplaire> exemplaireList=getDaoFactory().getExemplaireDao().getExemplaireRendus();
        for(Exemplaire exemplaire:exemplaireList) {
            //TODO si reservation disponible mais il y a une resa en cours mettre etat rendu
                List<Reservation> reservationList = listerLesReservationParPriorite(exemplaire.getOuvrage().getiD());
                for (Reservation reservation: reservationList) {

                    reservation.setDateNotification(new Date());
                    getDaoFactory().getReservationDao().modifieReservation(reservation);
                }
        }
        return null;
    }


    @Override
    public List<Reservation> listerLesReservationParPriorite(int iD) {
       List<Reservation> reservationList= getDaoFactory().getReservationDao().listerLesReservationParPriorite(iD);

       Collections.sort(reservationList,Reservation.comparatorDatedemande);

        List<Reservation> reservationList1=reservationList.stream()
                .limit(1)
                .collect(Collectors.toList());

        return reservationList1;
    }

    @Override
    public List<Reservation> AnnulerlesReservations() {
        List<Exemplaire> exemplaireList = getDaoFactory().getExemplaireDao().getExemplaireRendus();
        List<Reservation> reservationList=new ArrayList<>();
        for (Exemplaire exemplaire : exemplaireList) {
           reservationList = listerLesReservationParPriorite(exemplaire.getOuvrage().getiD());
              for (Reservation reservation:reservationList){
                  System.out.println("val date jour "+ajouterJour(DATE_JOUR,-2));
                  System.out.println("val de date resa "+reservation.getDateNotification());
                  System.out.println("val de resa id"+reservation.getiD());
                      if (ajouterJour(DATE_JOUR,-2).after(reservation.getDateNotification())){
                          reservation.setNotification(true);
                          getDaoFactory().getReservationDao().modifieReservation(reservation);

                      }
              }
        }


        return reservationList;
    }


    public List<Reservation> SupprimerLesReservation(){
        List<Reservation> reservationList=getDaoFactory().getReservationDao().listerLesReservationnNotifie();
        for (Reservation reservation:reservationList
             ) {
            getDaoFactory().getReservationDao().supprimerReservation(reservation.getiD());

        }
        return null;
    }



}