package org.biblio.p7.contract;

import org.biblio.p7.bean.Exemplaire;

import java.util.List;

public interface ExemplaireDao {
    public List<Exemplaire> afficherExemplaire();

    public void ajouterExemplaire(Exemplaire exemplaire);

    public Exemplaire supprimerExemplaire(Integer iD);

    public void modifierExemplaire(Exemplaire exemplaire);

    public Exemplaire rechercherExemplaire(Integer id);

    public List<Exemplaire> rechercherlisteExemplaire(Integer ouvid );

    public Exemplaire changestatusexemplaire(Exemplaire exemplaire);

    //CORRECTED TICKET 1

    /**
     * ajout de la méthode permettant de compter le nombre d'exemplaire
     * @param numexemplaire
     * @return
     */
    public int getCountExemplaire(Exemplaire numexemplaire);

    public List<Exemplaire> getExemplaireRendus();
}
