package org.batch.p7;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.biblio.p7.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;

@Component
public class EmailServiceImpl implements EmailService {


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


    @Autowired
    public JavaMailSender emailSender;




    public void sendSimpleMessage(String to,String subject,String text){

        SimpleMailMessage message=new SimpleMailMessage();


        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailSender.send(message);
     }


    ;

    public void relanceNiv1(){

        HtmlEmail email = new HtmlEmail();

        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(mail,mdp));
        email.setSSLOnConnect(true);


        try {
            email.addTo("aurelien.mimouni@gmail.com");
            email.setFrom("aurelien.mimouni@gmail.com");
            email.setSubject("premiere relance");


            String text = "<html> " +
                    "<head></head>" +
                    "<body>" +
                    "<h1>Cher " + "</h1>" + "\n" +
                    "<p>vous avez emprunté un livre " +""+"</p>" + "\n" +
                    "</p>merci de le retourner des que possible</p>" +
                    "</body>" +
                    "</html>";

            email.setHtmlMsg(text);
            email.send();

        }
         catch (EmailException e) {
                // TODO Auto-generated catch block
                System.out.println("Unable to send an email" + e.getMessage());
            }


    }


}
