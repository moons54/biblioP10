package org.biblio.p7.manager;

import org.biblio.p7.bean.EditionOuvrage;
import org.biblio.p7.managerimpl.*;

public interface ManagerFactory {


   LecteurManager getLecteurManager();

   CoordonneesManager getCoordonneesManager();

   GenreManager getGenreManager();

   AuteurManager getAuteurManager();

   EditeurManager getEditeurManager();

   ExemplaireManager getExemplaireManager();

   EditionOuvrageManager getEditionOuvrageManager();

   OuvrageManager getOuvrageManager();

   EmpruntManager getEmpruntManager();

}
