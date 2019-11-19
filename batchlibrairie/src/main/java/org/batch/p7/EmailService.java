package org.batch.p7;

import org.biblio.p7.service.Exemplaire;
import org.biblio.p7.service.Lecteur;
import org.springframework.stereotype.Component;


public interface EmailService {

    public void sendSimpleMessage(String to, String subject, String text);

    public void relanceNiv1();
}
