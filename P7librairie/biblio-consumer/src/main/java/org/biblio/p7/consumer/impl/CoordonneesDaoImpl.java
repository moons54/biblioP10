package org.biblio.p7.consumer.impl;

import org.biblio.p7.bean.Coordonnees;
import org.biblio.p7.consumer.impl.RowMapper.CoordonneesRM;
import org.biblio.p7.contract.CoordonneesDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;


/**
 * Class pour Gestion des coordonnées
 */

public class CoordonneesDaoImpl extends AbstractDaoimpl implements CoordonneesDao {


    /**
     * Affiche un objet coordonnée
     * @param iD
     * @return
     */
    @Override
    public Coordonnees afficheCoordonneByLecteur(Integer iD) {
        String vsql = "SELECT * FROM public.coordonnees WHERE lecteurid=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));
        CoordonneesRM rmcoord = new CoordonneesRM();
        Coordonnees coordonnees=vJdbcTemplate.queryForObject(vsql,new Object[]{iD},rmcoord);
        return coordonnees;
    }


    /**
     * Liste les coordonnées
     * @param iD
     * @return
     */
    public List<Coordonnees> listeCoordonneByLecteur(Integer iD) {
        String vsql = "SELECT * FROM public.coordonnees WHERE lecteurid=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));
        CoordonneesRM rmcoord = new CoordonneesRM();
        List<Coordonnees> lcord=vJdbcTemplate.query(vsql,new Object[]{iD},rmcoord);
        return lcord;
    }

    /**
     * Ajoute de nouveaux coordonnées
     * @param coordonnees
     */
    @Override
    public void ajouteCoordonnees(Coordonnees coordonnees) {
        String vsql ="Insert INTO public.coordonnees (rue, code_postale, ville, telephone, email, lecteurid) values (:rue,:codePostal,:ville,:telephone,:email,:lecteurid)";

        SqlParameterSource ajoutparam = new MapSqlParameterSource()
                .addValue("rue", coordonnees.getRue())
                .addValue("codePostal", coordonnees.getCodePostal())
                .addValue("ville", coordonnees.getVille())
                .addValue("telephone", coordonnees.getTelephone())
                .addValue("email",coordonnees.getEmail())
                .addValue("lecteurid", coordonnees.getLecteur().getId());
        NamedParameterJdbcTemplate vJdbcTemplate= new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vsql,ajoutparam);
    }

    /**
     * Modification de coodornnées
     * @param coordonnees
     */
    @Override
    public void modifierCoordonnees(Coordonnees coordonnees) {
        String vsql ="UPDATE public.coordonnees SET rue=:rue, code_postale=:codePostal, ville=:ville, telephone=:telephone, email=:email, lecteurid=:lecteurid WHERE id = :id";

        SqlParameterSource ajoutparam = new MapSqlParameterSource()
                .addValue("rue", coordonnees.getRue())
                .addValue("codePostal", coordonnees.getCodePostal())
                .addValue("ville", coordonnees.getVille())
                .addValue("telephone", coordonnees.getTelephone())
                .addValue("email",coordonnees.getEmail())
                .addValue("lecteurid", coordonnees.getLecteur().getId())
                .addValue("id",coordonnees.getiD());
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vsql,ajoutparam);

    }


}
