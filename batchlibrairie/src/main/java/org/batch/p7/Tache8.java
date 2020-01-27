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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class Tache8 implements Tasklet {


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


    public Tache8() {
    }

    Lecteur lecteur;
    Exemplaire exemplaire;

    /**
     * nous mettons en place un mail permettant d'avertir le lecteur que son livre l'attend pdt 48H
     * les lecteurs ayant reservé
     */


    //LIAISON AVEC WEBSERVICE EMPRUNT
    AuthentificationService_Service authentificationService_service=new AuthentificationService_Service();
    AuthentificationService por=authentificationService_service.getAuthentificationServicePort();

    OuvrageService_Service ouvrageService_service=new OuvrageService_Service();
    OuvrageService por2=ouvrageService_service.getOuvrageServicePort();

    PretService_Service pretServicePort_client=new PretService_Service();
    PretService por3=pretServicePort_client.getPretServicePort();

    ReservationService_Service reservationService_service=new ReservationService_Service();
    ReservationService por4=reservationService_service.getReservationServicePort();

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        Calendar calAujourdhui = Calendar.getInstance();
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");


        List<Reservation> reservationList=por4.listerlesreservation();
        for (Reservation res:reservationList
             ) {
        reservationList.remove(res);

        }

        List<Lecteur> lecteurList=por.rechercherlesLecteurs();
        List<Lecteur> lecteurList1=new ArrayList<>();

        for (Lecteur lecteur:lecteurList){
            for (Reservation reservation: reservationList){
                if (lecteur.getId()==reservation.getLecteur().getId()){
                    if(reservation.getDateNotification()!=null){
                        if (lecteurList1.contains(lecteur)){
                        }           else {
                            lecteurList1.add(lecteur);
                        }
                    }

                }

            }
        }
        for (Lecteur lecteur1: lecteurList1){
            System.out.println("liste des res"+lecteur1.getNom());
            List<Reservation> reservationList1=por4.listerlesreservationparlecteur(lecteur1.getId());

             reservationList=reservationList1.stream()
                    .filter(x->x.getDateNotification()!=null)
                    .collect(Collectors.toList());

            HtmlEmail email = new HtmlEmail();

            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("ami.test.dev@gmail.com", "Snickers3618"));
            email.setSSLOnConnect(true);


            try {
                email.addTo("aurelien.mimouni@gmail.com");
                email.setFrom("aurelien.mimouni@gmail.com");
                email.setSubject("Votre livre vous attend");


                String text = "<html> " +
                        "<head><script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/bs4/dt-1.10.18/sl-1.3.0/datatables.min.js\"></script>\n" +
                        "\n" +
                        "<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/v/bs4-4.1.1/dt-1.10.18/r-2.2.2/sl-1.3.0/datatables.min.css\"/>\n" +
                        "\n" +
                        "<script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/bs4-4.1.1/dt-1.10.18/r-2.2.2/sl-1.3.0/datatables.min.js\"></script>\n" +
                        "<link href=\"css/DataTables-1.10.18/css/dataTables.bootstrap4.min.css\">\n" +
                        "\n" +
                        "\n" +
                        "<script src=\"https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css\"/>\n" +
                        "\n" +
                        "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n" +
                        "\n" +
                        "\n" +
                        "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                        "<link href=\"https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lumen/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iqcNtN3rj6Y1HX/R0a3zu3ngmbdwEa9qQGHdkXwSRoiE+Gj71p0UNDSm99LcXiXV\" crossorigin=\"anonymous\">\n</head>" +
                        "<body>" +
                        "<div class='container'>" +
                        "<div class='card'>" +
                        "<h2>" +
                        "<p class='card-head alert-success text-center'>LIBRAIRIE OC CLASSBOOK" + "</p>" + "</h2>" + "\n" +
                        "<p class='text-right'>Paris le "+df.format(calAujourdhui.getTime())+"</p>"+
                        "<p class='text-center'> Cher " + lecteur1.getNom() + ",</p>" + "\n" +
                        "<p>Votre livre vous Attend ! Vous avez  48 H pour réccuperer votre livre.  :  "+"</p>";
               for (Reservation em : reservationList) {
                    text += "<li><strong>" + em.getOuvrage().getIntituleOuvrage() + "Indentification :  " + em.getOuvrage().getIsbn() + "</strong></li>" + "\n";
                }
                // }
                // text+="<p>Vous devez retourner les livres suivant  :  "+"<strong>" + emprunt.getExemplaire().getOuvrage().getIntituleOuvrage()  + "Indentification :  "+emprunt.getExemplaire().getReferenceInterne()+"</strong>"+ "\n" +
                text += "<p class='row'>" +
                        "<p class='red-text'><strong>Bonjour votre livre vous attend a notre librairie, vous avez 48 heure pour le reccuperer. Au dela de ce délais, votre reservation sera perdu.</strong>" + "\n" + "</p>" +
                         "<p class='card-head alert-info'>L'equipe oc Classbook</p>" +
                        "</p>" +
                        "</div>" +
                        "</body>" +
                        "</html>";

                email.setHtmlMsg(text);
                email.send();

            } catch (EmailException e) {
                // TODO Auto-generated catch block
                System.out.println("Unable to send an email" + e.getMessage());
            }
        }
 return RepeatStatus.FINISHED;


    }


}

