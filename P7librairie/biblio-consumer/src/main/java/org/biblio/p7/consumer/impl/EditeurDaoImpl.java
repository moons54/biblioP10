package org.biblio.p7.consumer.impl;

import org.biblio.p7.bean.Editeur;
import org.biblio.p7.consumer.impl.RowMapper.EditeurRM;
import org.biblio.p7.contract.EditeurDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'objet Editeur
 */
public class EditeurDaoImpl extends AuteurDaoImpl implements EditeurDao {

    /**
     * Affiche la liste des Editeurs
     * @return List<Editeur>
     */
    @Override
    public List<Editeur> afficherEditeur() {
        String vsql = "SELECT id, intitule_editeur, lienweb FROM public.editeur ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        // Utilisation d'un RowMAPPER Editeur
        EditeurRM editeurRM=new EditeurRM();

        List<Editeur> afficheliste= vJdbcTemplate.query(vsql,editeurRM);
        return afficheliste;
    }

    /**
     * Affiche la liste des éditeurs par id
     * @param id
     * @return
     */
    public List<Editeur> afficherEditeur(int id) {
        String vsql = "SELECT * FROM public.editeur where id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        // Utilisation d'un RowMAPPER Editeur
        EditeurRM editeurRM=new EditeurRM();
        List<Editeur> afficheliste= vJdbcTemplate.query(vsql,new Object[]{id},editeurRM);
        return afficheliste;
    }

    /**
     * Ajout d'un nouvel Editeur
     * @param editeur
     */
    @Override
    public void ajouterEditeur(Editeur editeur) {
        String vSQL="INSERT into public.editeur(intitule_editeur, lienweb) VALUES "+
                "(:intituleEditeur,:lienweb)";
        SqlParameterSource vParams=new BeanPropertySqlParameterSource(editeur);
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);


    }

    /**
     * Suppression d'un Editeur
     * @param iD
     * @return
     */
    @Override
    public Editeur supprimerEditeur(Integer iD) {
        String vsql="DELETE from editeur where id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));
        // Utilisation d'un RowMAPPER Editeur
        EditeurRM editeurRM=new EditeurRM();
        vJdbcTemplate.update(vsql,new Object[]{iD});
        return null;
    }

    /**
     * Modifier Editeur
     * @param editeur
     */
    @Override
    public void modifierEditeur(Editeur editeur) {
        String vSQL="update editeur set intitule_editeur=:intitule_editeur,lienweb=:lienweb";
        SqlParameterSource vParams=new BeanPropertySqlParameterSource(editeur);
        NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
    }

    /**
     * Rechercher Editeur
     * @param iD
     * @return
     */
    @Override
    public Editeur rechercherEditeurparId(Integer iD) {
        String vsql = "SELECT id, intitule_editeur, lienweb FROM public.editeur WHERE id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));
        EditeurRM editeurRM=new EditeurRM();

        Editeur editeur = vJdbcTemplate.queryForObject(vsql, new Object[]{iD}, editeurRM);
        return editeur;
    }


    /**
     * Afficher les éditeurs par ouvrage
     * @param id
     * @return
     */
    public List<Editeur> afficherEditionparouvrage(int id) {
        String vSQL="select editeurid from edition_ouvrage where ouvrageid=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Integer> listint= vJdbcTemplate.queryForList(vSQL,new Object[]{id},Integer.class);
        List<Editeur> editeurList=new ArrayList<Editeur>();
        for (int i=0;i<listint.size();i++){
            editeurList.add(rechercherEditeurparId(listint.get(i)));
        }
        return editeurList;
    }
}
