package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.EditionOuvrage;

import org.biblio.p7.consumer.impl.EditeurDaoImpl;
import org.biblio.p7.consumer.impl.OuvrageDaoImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EditionOuvrageRM implements RowMapper<EditionOuvrage> {
    @Override
    public EditionOuvrage mapRow(ResultSet rs, int rowNum) throws SQLException {
        EditionOuvrage editionOuvrage=new EditionOuvrage();
        editionOuvrage.setAnneeEditions(rs.getDate("annee_editions"));


        OuvrageDaoImpl ouvrageDao=new OuvrageDaoImpl();
        editionOuvrage.setOuvrage(ouvrageDao.rechercherparId(rs.getInt("ouvrageid")));

        EditeurDaoImpl editeurDao=new EditeurDaoImpl();
        editionOuvrage.setEditeur(editeurDao.rechercherEditeurparId(rs.getInt("editeurid")));

        return editionOuvrage;
    }
}
