package org.batch.p7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;


@Component
public class gestionMail {

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

   /* public void sendmail(Lecteur lecteur, List<Emprunt> ouvragelist){



    }*/
@Bean
public JavaMailSender emailSender(){
    JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);

    mailSender.setUsername(mail);
    mailSender.setPassword(mdp);

    Properties properties=mailSender.getJavaMailProperties();
    properties.put("mail.smtp.starttls.enable", starttls);
    properties.put("mail.smtp.host",starttls);
    properties.put("mail.smtp.port",host);
    properties.put("mail.smtp.auth",port);
    properties.put("mail.smtp.auth",auth);

    return mailSender;
}
}
