package org.biblio.p7.consumer.impl;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoimpl {



    /*
    Classe Mère qui fera hériter toutes les classes Dao
    */

    /* Création de l'attribut Datasource permettant la connexion à la base de données */

    @Inject
    @Named("mabiblio")
    private static DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource) {
        AbstractDaoimpl.dataSource = dataSource;
    }


}

