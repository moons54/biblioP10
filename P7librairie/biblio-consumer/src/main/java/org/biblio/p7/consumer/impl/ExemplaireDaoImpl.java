package org.biblio.p7.consumer.impl;

import org.biblio.p7.bean.Exemplaire;
import org.biblio.p7.consumer.impl.RowMapper.ExemplaireRM;
import org.biblio.p7.contract.ExemplaireDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

/**
 * Classe gérant les exemplaire d'un ouvrage
 */
public class ExemplaireDaoImpl extends AbstractDaoimpl implements ExemplaireDao {

    /**
     * Lister les exemplaires
     * @return
     */
    @Override
    public List<Exemplaire> afficherExemplaire() {
        String vsql = "SELECT id, referenceinterne,status, ouvrageid,bibliothequeid FROM public.exemplaire ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        ExemplaireRM exemplaireRM=new ExemplaireRM();
        List<Exemplaire> afficheliste= vJdbcTemplate.query(vsql,exemplaireRM);
        return afficheliste;
    }

    /**
     * ajouter un exemplaire
     * @param exemplaire
     */
    @Override
    public void ajouterExemplaire(Exemplaire exemplaire) {
        String vSQL="INSERT into public.exemplaire(referenceinterne) values "+
                "(:referenceInterne)";
        SqlParameterSource vParams=new BeanPropertySqlParameterSource(exemplaire);
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);

    }

    /**
     * Supprimer un exemplaire
     * @param iD
     * @return
     */
    @Override
    public Exemplaire supprimerExemplaire(Integer iD) {
        String vsql="DELETE from exemplaire where id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));
        ExemplaireRM exemplaireRM=new ExemplaireRM();


        vJdbcTemplate.update(vsql,new Object[]{iD});

        return null;
    }

    /**
     * modifier un exemplaire
     * @param exemplaire
     */
    @Override
    public void modifierExemplaire(Exemplaire exemplaire) {
        String vSQL="update exemplaire set status=:status where id=?";
        SqlParameterSource vParams=new BeanPropertySqlParameterSource(exemplaire);
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
    }

    /**
     * Rechercher un exemplaire par son id
     * @param id
     * @return
     */
    public Exemplaire rechercherExemplaire(Integer id) {
        String vsql = "SELECT id, referenceinterne,status, ouvrageid,bibliothequeid FROM public.exemplaire where id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        ExemplaireRM exemplaireRM=new ExemplaireRM();
        Exemplaire exemplaire= (Exemplaire) vJdbcTemplate.queryForObject(vsql,new Object[]{id},exemplaireRM);
        return exemplaire;
    }

    public List<Exemplaire> rechercherlisteExemplaire(Integer ouvid ) {
        String vsql = "SELECT * FROM public.exemplaire where ouvrageid=? and (status is null or status='1')";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        ExemplaireRM exemplaireRM=new ExemplaireRM();
        List<Exemplaire> exemplaireList=  vJdbcTemplate.query(vsql,new Object[]{ouvid},exemplaireRM);
        return exemplaireList;
    }


    /**
     * changement du statut d'un exemplaire
     * methode utilisé lorsqu'un ouvrage est emprunté
     * @param exemplaire
     * @return
     */
    @Override
    public Exemplaire changestatusexemplaire(Exemplaire exemplaire) {
        String vSQL="update exemplaire set status=:status where id=:id";
        SqlParameterSource vParams=new MapSqlParameterSource()
                .addValue("status",99)
                .addValue("id",exemplaire.getiD());
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
        return exemplaire;
    }
}
