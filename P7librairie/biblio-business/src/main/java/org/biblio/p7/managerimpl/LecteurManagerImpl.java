package org.biblio.p7.managerimpl;

import org.biblio.p7.bean.Lecteur;
import org.biblio.p7.bean.Exception.Exception.NotFoundException;
import org.biblio.p7.consumer.impl.LecteurDaoImpl;
import org.biblio.p7.manager.LecteurManager;
import org.biblio.p7.contract.*;
import org.biblio.p7.consumer.impl.DaoFactoryImpl;
import org.biblio.p7.manager.ManagerFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


public class LecteurManagerImpl extends AbstractManagerImpl implements LecteurManager {

  /*  @Inject
    @Named("mabiblio")
    private PlatformTransactionManager platformTransactionManager;
*/
    @Override
    public List<Lecteur> affichelecteur() throws NotFoundException {


return getDaoFactory().getLecteurDao().affichelecteur();
    }

    @Override
    public void ajouteLecteur(Lecteur lecteur) {
        getDaoFactory().getLecteurDao().ajouteLecteur(lecteur);

    }


    @Override
    public Lecteur supprimeLecteur(Integer iD) {
       // getDaoFactory().getLecteurDao().supprimeLecteur(iD);


        return  getDaoFactory().getLecteurDao().supprimeLecteur(iD);
    }

    @Override
    public void modifieLecteur(Lecteur lecteur) {
       /* TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                getDaoFactory().getLecteurDao().modifieLecteur(lecteur);
            }
        });*/
       getDaoFactory().getLecteurDao().modifieLecteur(lecteur);
    }

    @Override
    public Lecteur rechercher(Integer iD) {
        return getDaoFactory().getLecteurDao().rechercher(iD);
    }

    @Override
    public Lecteur rechercherByNom(String nom) {
        System.out.println(" dans rec by nom");

        return getDaoFactory().getLecteurDao().rechercherByLecteur(nom);
    }

    @Override
    public Lecteur controleLecteur(String identifiant, String motdepasse) throws NotFoundException {
        return getDaoFactory().getLecteurDao().controleLecteur(identifiant,motdepasse);
    }




}
