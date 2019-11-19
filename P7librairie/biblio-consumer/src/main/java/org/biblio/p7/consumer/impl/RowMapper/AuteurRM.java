package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.Auteur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuteurRM implements RowMapper<Auteur> {
    @Override
    public Auteur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Auteur auteur=new Auteur();
        auteur.setiD(rs.getInt("id"));
        auteur.setIntituleAuteur(rs.getString("intitule_auteur"));
        auteur.setDescriptionAuteur(rs.getString("description_auteur"));
        auteur.setLienweb(rs.getString("lienweb"));
        return auteur;
    }
}
