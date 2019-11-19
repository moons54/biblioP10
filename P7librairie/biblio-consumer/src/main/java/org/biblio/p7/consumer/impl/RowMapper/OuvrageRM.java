package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.Ouvrage;
import org.biblio.p7.bean.OuvrageGenre;
import org.biblio.p7.consumer.impl.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OuvrageRM implements RowMapper<Ouvrage> {
    @Override
    public Ouvrage mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ouvrage ouvrage=new Ouvrage();
        ouvrage.setiD(rs.getInt("id"));
        ouvrage.setIntituleOuvrage(rs.getString("intitule_ouvrage"));
        ouvrage.setDescription(rs.getString("description"));
        ouvrage.setPhoto(rs.getString("photo"));
        ouvrage.setIsbn(rs.getString("num_isbn"));

        AuteurDaoImpl auteurDao=new AuteurDaoImpl();
        ouvrage.setAuteur(auteurDao.rechercherparId(rs.getInt("auteurid")));

       OuvrageGenreDaoImpl ouvrageGenreDao=new OuvrageGenreDaoImpl();
        GenreDaoImpl genreDao=new GenreDaoImpl();

        ouvrage.setGenres(genreDao.RechercherOuvrageparGenre(rs.getInt("id")));

        EditeurDaoImpl editeurDao=new EditeurDaoImpl();

        ouvrage.setEditeurs(editeurDao.afficherEditionparouvrage(rs.getInt("id")));
        return ouvrage;
    }
}
