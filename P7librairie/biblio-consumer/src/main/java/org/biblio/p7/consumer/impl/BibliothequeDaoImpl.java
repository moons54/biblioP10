package org.biblio.p7.consumer.impl;

import org.biblio.p7.bean.Bibliotheque;
import org.biblio.p7.consumer.impl.RowMapper.BibliothequeRM;
import org.biblio.p7.contract.BibliothequeDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BibliothequeDaoImpl extends AbstractDaoimpl implements BibliothequeDao {

    /**
     * Affiche la liste des bibliotheques
     * @return
     */
    @Override
    public List<Bibliotheque> afficherBibliotheque() {
        String vsql = "SELECT * FROM public.bibliotheque ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        BibliothequeRM bibliothequeRM=new BibliothequeRM();
        List<Bibliotheque> afficheliste= vJdbcTemplate.query(vsql,bibliothequeRM);
        return afficheliste;

    }

    /**
     * Ajoute une bibliotheque
     * @param bibliotheque
     */
    @Override
    public void ajouterbibliotheque(Bibliotheque bibliotheque) {

    }

    /**
     * Suppression d'un bibliotheque
     * @param iD
     * @return
     */
    @Override
    public Bibliotheque supprimerBibliotheque(Integer iD) {
        return null;
    }


    /**
     * Modifier une bibliothèque
     * @param bibliotheque
     */
    @Override
    public void modifierBibliotheque(Bibliotheque bibliotheque) {

    }

    /**
     * Rechercher une bibliotheque par son numéro id
     * @param iD
     * @return
     */
    @Override
    public Bibliotheque rechercherBibliothequeparId(Integer iD) {
        String vsql="SELECT * from public.bibliotheque where id=?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate((getDataSource()));
        BibliothequeRM bibliothequeRM=new BibliothequeRM();
        Bibliotheque bibliotheque = (Bibliotheque) vJdbcTemplate.queryForObject(vsql, new Object[]{iD}, bibliothequeRM);
        return bibliotheque;
    }
}
