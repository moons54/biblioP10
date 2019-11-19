package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.Bibliotheque;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BibliothequeRM implements RowMapper<Bibliotheque> {
    @Override
    public Bibliotheque mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bibliotheque bibliotheque=new Bibliotheque();
        bibliotheque.setiD(rs.getInt("id"));
        bibliotheque.setIntituleBibliotheque(rs.getString("intitulebibliotheque"));
        bibliotheque.setAdresse(rs.getString("adresse"));
        bibliotheque.setCodePostal(rs.getString("codepostal"));
        bibliotheque.setVille(rs.getString("ville"));
        bibliotheque.setTelephone(rs.getString("telephone"));
        return bibliotheque;
    }
}
