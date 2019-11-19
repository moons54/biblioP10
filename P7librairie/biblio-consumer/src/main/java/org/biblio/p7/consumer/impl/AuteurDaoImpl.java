package org.biblio.p7.consumer.impl;

import org.biblio.p7.bean.Auteur;
import org.biblio.p7.consumer.impl.RowMapper.AuteurRM;
import org.biblio.p7.contract.AuteurDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

public class AuteurDaoImpl extends AbstractDaoimpl implements AuteurDao {


    @Override
    public List<Auteur> afficherAuteur() {
        String vsql = "SELECT * FROM public.auteur ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        AuteurRM auteurRM=new AuteurRM();
        List<Auteur> afficheliste= vJdbcTemplate.query(vsql,auteurRM);
        return afficheliste;
    }

    @Override
    public void ajouterAuteur(Auteur auteur) {
        String vSQL="insert into public.auteur(intitule_auteur, description_auteur, lienweb) VALUES "+
                "(:intituleAuteur,:descriptionAuteur,:lienweb)";

        SqlParameterSource vParams=new BeanPropertySqlParameterSource(auteur);
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
    }

    @Override
    public Auteur supprimerAuteur(Integer iD) {
        String vsql="DELETE from auteur where id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));
        AuteurRM auteurRM=new AuteurRM();
        vJdbcTemplate.update(vsql,new Object[]{iD});
        return null;
    }

    @Override
    public void modifierAuteur(Auteur auteur) {
    String vSQL="update auteur set intitule_auteur=:intituleAuteur, description_auteur=:descriptionAuteur, lienweb=:lienweb";
        SqlParameterSource vParams=new BeanPropertySqlParameterSource(auteur);
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
    }

    @Override
    public Auteur rechercherparId(Integer iD) {
        String vsql = "SELECT * FROM public.auteur WHERE id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));
        AuteurRM auteurRM = new AuteurRM();
        Auteur auteur=vJdbcTemplate.queryForObject(vsql,new Object[]{iD},auteurRM);
        return auteur;
    }
}
