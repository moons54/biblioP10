package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.OuvrageGenre;
import org.biblio.p7.consumer.impl.GenreDaoImpl;
import org.biblio.p7.consumer.impl.OuvrageDaoImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OuvrageGenreRM implements RowMapper<OuvrageGenre> {
    @Override
    public OuvrageGenre mapRow(ResultSet rs, int rowNum) throws SQLException {
        OuvrageGenre ouvrageGenre=new OuvrageGenre();

        OuvrageDaoImpl ouvrageDao=new OuvrageDaoImpl();
        ouvrageGenre.setOuvrage(ouvrageDao.rechercherparId(rs.getInt("ouvrageid")));

        GenreDaoImpl genreDao=new GenreDaoImpl();
        ouvrageGenre.setGenre(genreDao.rechercherparId(rs.getInt("genreid")));

        return ouvrageGenre;
    }
}
