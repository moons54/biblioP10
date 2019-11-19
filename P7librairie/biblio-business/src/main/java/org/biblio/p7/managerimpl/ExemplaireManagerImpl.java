package org.biblio.p7.managerimpl;

import org.biblio.p7.bean.Bibliotheque;
import org.biblio.p7.bean.Exemplaire;
import org.biblio.p7.manager.ExemplaireManager;

import java.util.List;

public class ExemplaireManagerImpl extends AbstractManagerImpl implements ExemplaireManager {
    @Override
    public List<Exemplaire> afficherExemplaire() {

        return getDaoFactory().getExemplaireDao().afficherExemplaire();
    }

    @Override
    public void ajouterExemplaire(Exemplaire exemplaire) {
        getDaoFactory().getExemplaireDao().ajouterExemplaire(exemplaire);
    }

    @Override
    public Exemplaire supprimerExemplaire(Integer iD) {
        getDaoFactory().getExemplaireDao().supprimerExemplaire(iD);
        return null;
    }

    @Override
    public void modifierExemplaire(Exemplaire exemplaire) {
        getDaoFactory().getExemplaireDao().modifierExemplaire(exemplaire);

    }

    @Override
    public List<Exemplaire> afficherlistExemplaire(int ouvrageid) {

        return getDaoFactory().getExemplaireDao().rechercherlisteExemplaire(ouvrageid);
    }


    public Bibliotheque affichebiblio(int id){
        return getDaoFactory().getBibliothequeDao().rechercherBibliothequeparId(id);
    }

    @Override
    public List<Bibliotheque> listerlesbibliotheques() {
        return getDaoFactory().getBibliothequeDao().afficherBibliotheque();
    }

    @Override
    public Exemplaire afficherexemplairebyID(Integer id){
        return getDaoFactory().getExemplaireDao().rechercherExemplaire(id);
    }

    @Override
    public Exemplaire changestatusexemplaire(Exemplaire exemplaire) {
        return getDaoFactory().getExemplaireDao().changestatusexemplaire(exemplaire);
    }
}
