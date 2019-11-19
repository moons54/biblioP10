package org.biblio.p7.consumer.impl;

import org.biblio.p7.bean.Genre;
import org.biblio.p7.bean.Ouvrage;
import org.biblio.p7.bean.OuvrageGenre;
import org.biblio.p7.consumer.impl.RowMapper.OuvrageGenreRM;
import org.biblio.p7.contract.OuvrageGenreDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OuvrageGenreDaoImpl extends AuteurDaoImpl implements OuvrageGenreDao {
    @Override
    public List<OuvrageGenre> afficherGenreOuvrage(Integer id) {
        String vSQL = "select * from ouvrage_genre where ouvrageid= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());


        // List<OuvrageGenre> afficheliste= vJdbcTemplate.query(vSQL,ouvrageRM);

        //on envoi une liste de genre
        List<Integer> integerList = vJdbcTemplate.queryForList(vSQL, new Object[]{id}, Integer.class);

        List<OuvrageGenre> ouvrageGenres = new ArrayList<OuvrageGenre>();

        for (int i = 0; i < integerList.size(); i++) {
            ouvrageGenres.add(rechercherGenreOuvrage(integerList.get(i)));
        }


    /*for (OuvrageGenre ouvrageliste: ouvrageGenres){
        ouvrageGenres.add(rechercherGenreOuvrage(integerList.get(integerList.indexOf(ouvrageliste))));


        }*/
        System.out.println("voir la valeur de ouvrage genre " + ouvrageGenres.toString());
        return ouvrageGenres;

    }

    public OuvrageGenre rechercherGenreOuvrage(Integer id) {
        String vSQL = "select * from ouvrage_genre where ouvrageid=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        OuvrageGenreRM ouvrageRM = new OuvrageGenreRM();

        OuvrageGenre afficheliste = (OuvrageGenre) vJdbcTemplate.queryForObject(vSQL, new Object[]{id}, ouvrageRM);


        return afficheliste;
    }



    @Override
    public void ajouterGenreOuvrage(OuvrageGenre ouvrageGenre) {

    }

    @Override
    public OuvrageGenre supprimeGenreOuvrage(Integer iD) {
        return null;
    }

    @Override
    public void modifierGenreOuvrage(OuvrageGenre ouvrageGenre) {

    }

    @Override
    public List<OuvrageGenre> affichelisteouvrageGenre() {
        String vSQL = "select * from ouvrage_genre ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        OuvrageGenreRM ouvrageRM = new OuvrageGenreRM();
        List<OuvrageGenre> ouvrageGenre = vJdbcTemplate.query(vSQL, ouvrageRM);

        return ouvrageGenre;
    }



    public List<OuvrageGenre> listerlesouvragepargenre(Integer id) {
        String vSQL = "select * from ouvrage_genre where genreid=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        OuvrageGenreRM ouvrageRM = new OuvrageGenreRM();

        //on envoi une liste d ouvrage
        List<Integer> integerList = vJdbcTemplate.queryForList(vSQL, new Object[]{id}, Integer.class);

        List<OuvrageGenre> ouvrageGenres = new ArrayList<OuvrageGenre>();

        for (int i = 0; i < integerList.size(); i++) {
            ouvrageGenres.add(recgenreouv(integerList.get(i)));
        }

        return ouvrageGenres;
    }

    public OuvrageGenre recgenreouv(Integer id) {
        String vSQL = "select * from ouvrage_genre where genreid=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        OuvrageGenreRM ouvrageRM = new OuvrageGenreRM();

        OuvrageGenre afficheliste = (OuvrageGenre) vJdbcTemplate.queryForObject(vSQL, new Object[]{id}, ouvrageRM);


        return afficheliste;
    }



}
