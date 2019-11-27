package org.batch.p7;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.biblio.p7.service.*;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


@Component
public class Tache2 implements Tasklet {


    @Value("${mail.adresse}")
    private String mail;

    @Value("${mail.mdp}")
    private String mdp;

    @Value("${mail.smtp.starttls.enable}")
    private String starttls;

    @Value("${mail.smtp.host}")
    private String host;

    @Value("${mail.smtp.port}")
    private String port;

    @Value("${mail.smtp.auth")
    private String auth;

    // CORRECTED TICKET 2
    /**TICKET 2
     * Mis en place Methode Tache2 ayant pour objectif de modifier
     * le statut des ouvrages lorsque ceux ci sont en retard
     * Dès lors, le lecteur ne peux plus prolonger le délais de son ouvrage
     */

    public Tache2() {
    }

    Lecteur lecteur;
    Exemplaire exemplaire;


    //LIAISON AVEC WEBSERVICE EMPRUNT
    AuthentificationService_Service authentificationService_service=new AuthentificationService_Service();
    AuthentificationService por=authentificationService_service.getAuthentificationServicePort();

    OuvrageService_Service ouvrageService_service=new OuvrageService_Service();
    OuvrageService por2=ouvrageService_service.getOuvrageServicePort();

    PretService_Service pretServicePort_client=new PretService_Service();
    PretService por3=pretServicePort_client.getPretServicePort();

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {



      Calendar calAujourdhui = Calendar.getInstance();
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
       List<Emprunt> empruntList=por3.afficherlesemprunts();


          for (Emprunt emprunt : empruntList) {

              if(emprunt.getDateFin().toGregorianCalendar().before(calAujourdhui)){


              if (emprunt.getSituationEmprunt().getSituation().contains("En cours")) {
                  System.out.println("num enr   "+emprunt.getID()+"   ");
                  System.out.println("livre "+emprunt.getExemplaire().getOuvrage().getIntituleOuvrage()+"   ");
                  System.out.println("lecteur  "+emprunt.getLecteur().getNom()+"  ");
                  System.out.println("date de l'emprunt "+emprunt.getDateFin().toString()+ " <  "+df.format(calAujourdhui.getTime()) );

                  // CORRECTED TICKET 2
                  /**
                   * Nous modifions le status de l'emprunt de tel sorte a signaler que celui ci est en retard
                   * et donc non prorogeable
                   */
                  emprunt.setSituationEmprunt(por3.recherchersituationdemprunt(4));
                  por3.changestatutemprunt(emprunt);
              }
              }

          }



        return RepeatStatus.FINISHED;
    }
}
