package org.biblio.p7.consumer.impl;

import org.biblio.p7.bean.EditionOuvrage;
import org.biblio.p7.bean.Exemplaire;
import org.biblio.p7.consumer.impl.RowMapper.EditionOuvrageRM;
import org.biblio.p7.contract.EditionOuvrageDao;
import org.biblio.p7.contract.ExemplaireDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

/**
 * Classe Edition ouvrage
 */
public class EditionOuvrageDaoImpl extends AbstractDaoimpl implements EditionOuvrageDao {
    @Override
    public List<EditionOuvrage> afficherEditionOuvrage() {
        String vSQL="select * from edition_ouvrage";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        EditionOuvrageRM editionOuvrageRM=new EditionOuvrageRM();
        List<EditionOuvrage> afficheliste= vJdbcTemplate.query(vSQL,editionOuvrageRM);
        return afficheliste;
    }

    @Override
    public List<EditionOuvrage> afficherEditionOuvrageparouvrage(int id) {
        String vSQL="select annee_editions,editeurid,ouvrageid from edition_ouvrage where ouvrageid=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        EditionOuvrageRM editionOuvrageRM=new EditionOuvrageRM();
        List<EditionOuvrage> afficheliste= vJdbcTemplate.query(vSQL,new Object[]{id},editionOuvrageRM);
        System.out.println("affichge edition ouvr"+afficheliste.toString());
        return afficheliste;
    }

    @Override
    public void ajouterEditionOuvrage(EditionOuvrage editionOuvrage) {
        String vSQL="insert into public.edition_ouvrage(annee_editions) values (:anneeEditions)";
        SqlParameterSource vParams=new BeanPropertySqlParameterSource(editionOuvrage);
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);

    }

    @Override
    public EditionOuvrage supprimerEditionOuvrage(Integer iD) {
        String vSQL="delete from edition_ouvrage where ouvrageid=?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));

        EditionOuvrageRM editionOuvrageRM=new EditionOuvrageRM();
        vJdbcTemplate.update(vSQL,new Object[]{iD});

        return null;
    }

    @Override
    public void modifierEditionOuvrage(EditionOuvrage editionOuvrage) {
        String vSQL="UPDATE edition_ouvrage set annee_editions=:anneeEditions";

        SqlParameterSource vParams=new BeanPropertySqlParameterSource(editionOuvrage);
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
    }


}
