package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.Exemplaire;
import org.biblio.p7.consumer.impl.BibliothequeDaoImpl;
import org.biblio.p7.consumer.impl.OuvrageDaoImpl;
import org.biblio.p7.contract.OuvrageDao;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemplaireRM implements RowMapper<Exemplaire> {
    @Override
    public Exemplaire mapRow(ResultSet rs, int rowNum) throws SQLException {
        Exemplaire exemplaire=new Exemplaire();
        exemplaire.setiD(rs.getInt("id"));
        exemplaire.setReferenceInterne(rs.getString("referenceinterne"));
        exemplaire.setStatus(rs.getString("status"));
        OuvrageDaoImpl ouvrageDao = new OuvrageDaoImpl();
       exemplaire.setOuvrage(ouvrageDao.rechercherparId(rs.getInt("ouvrageid")));


        BibliothequeDaoImpl bibliothequeDao=new BibliothequeDaoImpl();
        exemplaire.setBibliotheque(bibliothequeDao.rechercherBibliothequeparId(rs.getInt("bibliothequeid")));
        return exemplaire;
    }
}
