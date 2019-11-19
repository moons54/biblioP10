package org.biblio.p7.managerimpl;

import org.biblio.p7.consumer.impl.DaoFactoryImpl;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

public class AbstractManagerImpl {


    //importation de la classe fabrique d'obj
    private static DaoFactoryImpl daoFactory;

    protected static DaoFactoryImpl getDaoFactory() {
        return daoFactory;
    }

    public static void setDaoFactory(DaoFactoryImpl daoFactory) {
        AbstractManagerImpl.daoFactory = daoFactory;
    }
}