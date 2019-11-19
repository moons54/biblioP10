package org.batch.p7;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.biblio.p7.service.*;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;


@Component
public class Tache1 implements Tasklet {


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


    public Tache1() {
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


        List<Emprunt> empruntList=por3.afficherlesempruntsenretard();

        List<Lecteur> lecteurList=por.rechercherlesLecteurs();
        List<Lecteur> lecteurList1=new ArrayList<>();

        for (Lecteur lecteur:lecteurList){
            for (Emprunt emprunt: empruntList){
                if (lecteur.getId()==emprunt.getLecteur().getId()){
                    if (lecteurList1.contains(lecteur)){
                    }           else {
                        lecteurList1.add(lecteur);
                   }
                }

            }

        }
        for (Lecteur lecteur: lecteurList1){
            System.out.println("liste des retardataires"+lecteur.getNom());
            empruntList=por3.afficherlesempruntsenretarparLecteur(lecteur.getId());
            HtmlEmail email = new HtmlEmail();

            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("ami.test.dev@gmail.com", "Snickers3618"));
            email.setSSLOnConnect(true);


            try {
                email.addTo("aurelien.mimouni@gmail.com");
                email.setFrom("aurelien.mimouni@gmail.com");
                email.setSubject("premiere relance");


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
                        "<p class='text-center'> Cher " + lecteur.getNom() + ",</p>" + "\n" +
                        "<p>Sauf erreur ou omission, nous sommes en attente des ouvrages suivants  :  "+"</p>";
               for (Emprunt em : empruntList) {
                    text += "<li><strong>" + em.getExemplaire().getOuvrage().getIntituleOuvrage() + "Indentification :  " + em.getExemplaire().getReferenceInterne() + "</strong></li>" + "\n";
                }
                // }
                // text+="<p>Vous devez retourner les livres suivant  :  "+"<strong>" + emprunt.getExemplaire().getOuvrage().getIntituleOuvrage()  + "Indentification :  "+emprunt.getExemplaire().getReferenceInterne()+"</strong>"+ "\n" +
                text += "<p class='row'>" +
                        "<p class='red-text'><strong>merci de les retourner des que possible afin que nous puissions les proposer rapidement &agrave d'autres lecteurs</strong>" + "\n" + "</p>" +
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

