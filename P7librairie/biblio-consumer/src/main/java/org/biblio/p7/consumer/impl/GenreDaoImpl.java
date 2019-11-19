package org.biblio.p7.consumer.impl;

import org.biblio.p7.bean.Genre;
import org.biblio.p7.consumer.impl.RowMapper.GenreRM;
import org.biblio.p7.contract.GenreDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.ArrayList;
import java.util.List;


/**
 * Class Genre de l'ouvrage
 */
public class GenreDaoImpl extends AbstractDaoimpl implements GenreDao {
    @Override
    public List<Genre> afficherGenre() {
        String vsql = "SELECT * FROM public.genre ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        GenreRM genreRM=new GenreRM();
        List<Genre> afficheliste= vJdbcTemplate.query(vsql,genreRM);
        return afficheliste;
    }

    @Override
    public Genre rechercherGenre(Integer id) {
        String vsql = "SELECT * FROM public.genre where id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        GenreRM genreRM=new GenreRM();
        Genre afficheliste=  (Genre) vJdbcTemplate.queryForObject(vsql,new Object[]{id},genreRM);
        return afficheliste;

    }


    @Override
    public List<Genre> RechercherOuvrageparGenre(Integer id) {
        String vsql = "SELECT genreid FROM public.ouvrage_genre where ouvrageid=?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        List<Integer> listInt = vJdbcTemplate.queryForList(vsql, new Object[] { id },Integer.class);

        List<Genre> genreList=new ArrayList<Genre>();
        for (int i=0;i<listInt.size();i++){
            genreList.add(rechercherGenre(listInt.get(i)));
        }
        return genreList;
    }

    @Override
    public void ajouterGenre(Genre genre) {
        String vSQL="INSERT INTO public.genre(intitule_genre, description_genre, webographie) values "+
                "(:intitule,:description,:webographie)";

        SqlParameterSource vParams=new BeanPropertySqlParameterSource(genre);
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);


    }

    @Override
    public Genre supprimerGenre(Integer iD) {

        String vsql="DELETE from genre where id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));
        GenreRM genreRM=new GenreRM();

        vJdbcTemplate.update(vsql,new Object[]{iD});

        return null;
    }

    @Override
    public void modifierGenre(Genre genre) {
        String vSQL="update genre set intitule_genre=:intituleGenre, description_genre=:descriptionGenre, webographie=:webographie";

        SqlParameterSource vParams=new BeanPropertySqlParameterSource(genre);
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
    }

    @Override
    public Genre rechercherparId(Integer iD) {
        String vsql="SELECT  intitule_genre, description_genre, webographie from genre where id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));
        GenreRM genreRM=new GenreRM();
        Genre genre = vJdbcTemplate.queryForObject(vsql, new Object[]{iD}, genreRM);

        return genre;
    }



}
