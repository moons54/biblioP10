package org.biblio.p7.manager;

import org.biblio.p7.bean.Bibliotheque;
import org.biblio.p7.bean.Exemplaire;

import java.util.List;

public interface ExemplaireManager {

    public List<Exemplaire> afficherExemplaire();

    public void ajouterExemplaire(Exemplaire exemplaire);

    public Exemplaire supprimerExemplaire(Integer iD);

    public void modifierExemplaire(Exemplaire exemplaire);

    public List<Exemplaire> afficherlistExemplaire(int ouvrageid);

    public Bibliotheque affichebiblio(int id);

    public List<Bibliotheque> listerlesbibliotheques();

    public Exemplaire afficherexemplairebyID(Integer id);

    public Exemplaire changestatusexemplaire(Exemplaire exemplaire);
}
