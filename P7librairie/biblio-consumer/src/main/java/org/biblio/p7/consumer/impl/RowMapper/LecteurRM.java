package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.Lecteur;
import org.biblio.p7.consumer.impl.CoordonneesDaoImpl;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LecteurRM implements RowMapper<Lecteur> {

    // CoordonneesDaoImpl coordonneesDao;

    @Override
    public Lecteur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Lecteur lect = new Lecteur();
        lect.setId(rs.getInt("id"));
        lect.setIdentifiant(rs.getString("identifiant"));
        lect.setNom(rs.getString("nom"));
        lect.setPrenom(rs.getString("prenom"));
        lect.setMotDePasse(rs.getString("motdepasse"));
        lect.setDateDeNaissance(rs.getDate("date_de_naissance"));
        lect.setDateInscription(rs.getDate("date_inscription"));
        lect.setNum_cni(rs.getString("num_cni"));
        return lect;
    }
}
