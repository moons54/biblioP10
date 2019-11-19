package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.Coordonnees;
import org.biblio.p7.bean.Lecteur;
import org.biblio.p7.consumer.impl.LecteurDaoImpl;
import org.biblio.p7.contract.LecteurDao;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordonneesRM implements RowMapper<Coordonnees> {

   // LecteurDaoImpl lecteurDao;

    @Override
    public Coordonnees mapRow(ResultSet rs, int rowNum) throws SQLException {
       Coordonnees coord= new Coordonnees();
       coord.setiD(rs.getInt("id"));
       coord.setRue(rs.getString("rue"));
       coord.setCodePostal(rs.getString("code_postale"));
       coord.setVille(rs.getString("ville"));
       coord.setTelephone(rs.getString("telephone"));
       coord.setEmail(rs.getString("email"));

        LecteurDaoImpl lecteurDao=new LecteurDaoImpl();
   coord.setLecteur(lecteurDao.rechercher(rs.getInt("lecteurid")));
        return coord;
    }
}
