package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.Editeur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EditeurRM implements RowMapper<Editeur> {
    @Override
    public Editeur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Editeur editeur=new Editeur();
        editeur.setiD(rs.getInt("id"));
        editeur.setIntituleEditeur(rs.getString("intitule_editeur"));
        editeur.setLienweb(rs.getString("lienweb"));

        return editeur;
    }
}
