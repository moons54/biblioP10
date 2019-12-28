package org.biblio.p7.bean;

import java.util.Comparator;
import java.util.Date;

/**
 * classe ayant pour objectif la reservation d'un ouvrage non disponible
 */
public class Reservation {
    private int iD;
    private Date dateDemande;
    private Boolean notification;
    private Date dateNotification;
    private Ouvrage ouvrage;
    private Lecteur lecteur;

    public Reservation() {
    }

    public Reservation(int iD) {
        this.iD = iD;
    }


    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public Date getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(Date dateNotification) {
        this.dateNotification = dateNotification;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "iD=" + iD +
                ", dateDemande=" + dateDemande +
                ", notification=" + notification +
                ", dateNotification=" + dateNotification +
                ", ouvrage=" + ouvrage +
                ", lecteur=" + lecteur +
                '}';
    }


    public static Comparator<Reservation> comparatorDatedemande=new Comparator<Reservation>() {
        @Override
        public int compare(Reservation o1, Reservation o2) {
            return o1.getDateDemande().compareTo(o2.dateDemande);
        }
    };
}