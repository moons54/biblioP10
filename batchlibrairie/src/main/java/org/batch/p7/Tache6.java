package org.batch.p7;

import org.biblio.p7.service.*;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class Tache6 implements Tasklet {


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


    public Tache6(){
    }

    //LIAISON AVEC WEBSERVICE
    AuthentificationService_Service authentificationService_service=new AuthentificationService_Service();
    AuthentificationService por=authentificationService_service.getAuthentificationServicePort();

    OuvrageService_Service ouvrageService_service=new OuvrageService_Service();
    OuvrageService por2=ouvrageService_service.getOuvrageServicePort();

    PretService_Service pretServicePort_client=new PretService_Service();
    PretService por3=pretServicePort_client.getPretServicePort();

    ReservationService_Service reservationService_service=new ReservationService_Service();
    ReservationService por4=reservationService_service.getReservationServicePort();

    Calendar calAujourdhui = Calendar.getInstance();
    SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
    LocalDateTime currentTime = LocalDateTime.now();

    LocalDate date = currentTime.toLocalDate();
    GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));




    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        Calendar calAujourdhui = Calendar.getInstance();
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        List<Exemplaire> exemplaireList=por2.afficherExemplaire();
        List<Emprunt> empruntList=por3.afficherlesemprunts();


por4.annulerlesReservations();


        return RepeatStatus.FINISHED;
    }
}
