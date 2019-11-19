package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRM implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre=new Genre();
        genre.setiD(rs.getInt("id"));
        genre.setIntituleGenre(rs.getString("intitule_genre"));
        genre.setDescriptionGenre(rs.getString("description_genre"));
        genre.setWebographie(rs.getString("webographie"));


        return genre;
    }
}
