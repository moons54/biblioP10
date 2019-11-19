package action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import org.biblio.p7.service.*;
import org.biblio.p7.service.AuthentificationService;
import org.biblio.p7.service.AuthentificationService_Service;

import org.biblio.p7.service.Lecteur;
import org.biblio.p7.service.RecherchercoordonneeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class
LoginAction extends ActionSupport implements SessionAware {

    private final Logger LOGGER=(Logger) LogManager.getLogger(LoginAction.class);

    /**
     * appel des Webservices
     */

    //WEB SERVICES AUTHENTIFICATION
    AuthentificationService_Service authentificationService_service=new AuthentificationService_Service();
    AuthentificationService por=authentificationService_service.getAuthentificationServicePort();


    //WEB SERVICE OUVRAGE
    OuvrageService_Service ouvrageService_service=new OuvrageService_Service();
    OuvrageService por2=ouvrageService_service.getOuvrageServicePort();

    //WEB SERVICE EMPRUNT
    PretService_Service pretServicePort_client=new PretService_Service();
    PretService por3=pretServicePort_client.getPretServicePort();


    //PARAMETRE EN ENTREE
    Integer id;
    String identifiant;
    String motDePasse;
    String motDePasse2;
    Integer idutilisateur;
    String nom;
    String prenom;
    XMLGregorianCalendar dateInscription;
    XMLGregorianCalendar dateNaissance;
    String num_Cni;
    String rue;
    String codePostal;
    String ville;
    String telephone;
    String email;
    String dtp;

    @Value("${duree.emprunt}")
    private int maxemprunt;


    @Value("${duree.prolongation}")
    private int maxprolongation;

    //PARAMETRE EN SORTIE
    static Map<String, Object> session;
    private List<Lecteur> lecteurs;
    private Lecteur lecteur;
    private Genre genre;
    private Editeur editeur;
    private Coordonnees coordonnees;
    private Ouvrage ouvrage;
    private Exemplaire exemplaire;
    private Emprunt emprunt;
    private List<Ouvrage> ouvrageList;
    private List<Exemplaire> exemplaireList;
    private List<Emprunt> empruntList;
    private List<Emprunt> empruntencours;


    //GETTER AND SETTER

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }



    public List<Lecteur> getLecteurs() {
        return lecteurs;
    }

    public void setLecteurs(List<Lecteur> lecteurs) {
        this.lecteurs = lecteurs;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public XMLGregorianCalendar getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(XMLGregorianCalendar dateInscription) {
        this.dateInscription = dateInscription;
    }

    public XMLGregorianCalendar getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(XMLGregorianCalendar dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    public String getNum_Cni() {
        return num_Cni;
    }

    public void setNum_Cni(String num_Cni) {
        this.num_Cni = num_Cni;
    }

    public String getMotDePasse2() {
        return motDePasse2;
    }

    public void setMotDePasse2(String motDePasse2) {
        this.motDePasse2 = motDePasse2;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDtp() {
        return dtp;
    }

    public void setDtp(String dtp) {
        this.dtp = dtp;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public List<Ouvrage> getOuvrageList() {
        return ouvrageList;
    }

    public void setOuvrageList(List<Ouvrage> ouvrageList) {
        this.ouvrageList = ouvrageList;
    }

    public List<Exemplaire> getExemplaireList() {
        return exemplaireList;
    }

    public void setExemplaireList(List<Exemplaire> exemplaireList) {
        this.exemplaireList = exemplaireList;
    }

    public List<Emprunt> getEmpruntList() {
        return empruntList;
    }

    public void setEmpruntList(List<Emprunt> empruntList) {
        this.empruntList = empruntList;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public List<Emprunt> getEmpruntencours() {
        return empruntencours;
    }

    public void setEmpruntencours(List<Emprunt> empruntencours) {
        this.empruntencours = empruntencours;
    }

    public int getMaxemprunt() {
        return maxemprunt;
    }

    public void setMaxemprunt(int maxemprunt) {
        this.maxemprunt = maxemprunt;
    }

    public int getMaxprolongation() {
        return maxprolongation;
    }

    public void setMaxprolongation(int maxprolongation) {
        this.maxprolongation = maxprolongation;
    }

    //METHODE




    //Authentification de l'utilisateur
    public String doLogin() {
       LOGGER.info("DANS LA METHODE DOLOGIN");
       String vresult = ActionSupport.INPUT;

        if (!StringUtils.isAllEmpty(identifiant, motDePasse)) {
            try {
                lecteur = por.controlerLecteur(identifiant, motDePasse);
                System.out.println("---------------------------"+"identifié comme "+ identifiant.toString());
                        /*this.session.put("user", lecteur);
                        this.session.put("id",lecteur.getId());*/

            }
            catch(Exception e){
                this.addActionError("mt de pass invalide");
            }

            this.session.put("user", lecteur);
            this.session.put("id",lecteur.getId());
            this.session.put("dureelivre",maxemprunt);
            this.session.put("prolongation",maxprolongation);
            vresult=ActionSupport.SUCCESS;
        }
        return vresult;
    }

    //METHODE AFFICHANT LA LISTE DES UTILISATEURS
    public String doList() {

        lecteurs = por.rechercherlesLecteurs();
        return ActionSupport.SUCCESS;
    }

    //METHODE DE DECONNEXION
    public String doLogout(){
        this.session.remove("user");
        return ActionSupport.SUCCESS;
    }


    //METHODE CREANT UN NOUVEL UTILISATEUR
    public String doCreate(){
        LOGGER.info("DANS LA METHODE DOCREATE");
        Lecteur lecteur=new Lecteur();
        String vresult = ActionSupport.INPUT;
        //condition validant l'ajout de formulaire
        if (this.identifiant !=null) {
            if (this.motDePasse == null||this.motDePasse.hashCode()!=this.motDePasse2.hashCode()) {
                this.addActionError("erreur");
            } else
            {
                System.out.println("ok");
            }
            if (!this.hasErrors())
            {
                try
                {
                    lecteur.setIdentifiant(identifiant);
                    lecteur.setMotDePasse(motDePasse);
                    lecteur.setNom(nom);
                    lecteur.setPrenom(prenom);
                    lecteur.setDateDeNaissance(dateNaissance);
                    lecteur.setNumCni("34333232");
                    por.ajouterLecteur(lecteur);
                setIdutilisateur(lecteur.getId());
                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("premier etape pour   "+identifiant);
                } catch (Exception e)
                {
                    vresult = ActionSupport.ERROR;
                }
            }
        }
        return vresult;
    };


    //METHODE POUR DETAIL D'UN UTILISATEUR
    public String doDetail(){
        LOGGER.info("DANS LA METHODE DODETAIL");
        //gestion des erreurs si id du topo null
        if(idutilisateur==null){
            //  this.addActionError(getText("error.topo.missing.id."));
        }else
            lecteur=por.rechercher(Integer.parseInt(this.getSession().get("id").toString()));
            coordonnees=por.recherchercoordonnee(Integer.parseInt(this.getSession().get("id").toString()));
            empruntList=por3.afficherlesempruntsparLecteur(lecteur.getId());
            empruntencours=por3.afficherlesempruntsparLecteurencours(lecteur.getId());
            {
            }
        return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;
    };
    //METHODE POUR DETAIL D'UN temp UTILISATEUR
    public String doDetail1() throws Exception{
        lecteur = new Lecteur();
        LOGGER.info("DANS LA METHODE DODETAIL");
        //gestion des erreurs si id du topo null
        if(this.nom==null){
            //  this.addActionError(getText("error.topo.missing.id."));
        }else
            lecteur=por.rechercherparNom(this.nom);
        // coordonnees=por.recherchercoordonnee(Integer.parseInt(this.getSession().get("id").toString()));
       // empruntList=por3.afficherlesempruntsparLecteur(lecteur.getId());
       // empruntencours=por3.afficherlesempruntsparLecteurencours(lecteur.getId());
        {
        }
        return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;
    };

    public String doDetail2() throws Exception{
        lecteur = new Lecteur();
        LOGGER.info("DANS LA METHODE DODETAIL");
        //gestion des erreurs si id du topo null
        if(this.nom==null){
            //  this.addActionError(getText("error.topo.missing.id."));
        }else
            lecteur=por.rechercher(idutilisateur);
            coordonnees=por.recherchercoordonnee(idutilisateur);
        // coordonnees=por.recherchercoordonnee(Integer.parseInt(this.getSession().get("id").toString()));
        // empruntList=por3.afficherlesempruntsparLecteur(lecteur.getId());
        // empruntencours=por3.afficherlesempruntsparLecteurencours(lecteur.getId());
        {
        }
        return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;
    };

    public String dovalidate() {

        Coordonnees coordonnees=new Coordonnees();
        String vresult = ActionSupport.INPUT;
        //condition validant l'ajout de formulaire
        if (this.email!=null) {
            if (this.telephone == null)
            {
                this.addActionError("erreur");
            } else
            {
            }
            if (!this.hasErrors())
            {
                try
                {
                    coordonnees.setRue(rue);
                    coordonnees.setCodePostal(codePostal);
                    coordonnees.setVille(ville);
                    coordonnees.setEmail(email);
                    coordonnees.setTelephone(telephone);
                    coordonnees.setLecteur(por.rechercher(idutilisateur));
                    por.ajouterCoordonnees(coordonnees);
                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("Bienvenue  "+identifiant);
                } catch (Exception e)
                {

                    vresult = ActionSupport.ERROR;
                }

            }
        }

        return vresult;
    };

    //METHODE CONTROLE DE L'UTILISATEUR
    public String docontrole() throws Exception {
        LOGGER.info("DANS LA METHODE DOCONTROLE");
        if(nom==null){
             this.addActionError(getText("error.missing"));
        }else
            lecteur=por.rechercherparNom(this.nom);
        {
            this.addActionError("il n'y a pas d'element pour ce numéro " );
        }
        return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    //METHODE SUPPRESSION D'UN UTILISATEUR
    public String doSupp() throws Exception {
        LOGGER.info("DANS LA METHODE DOSUPP");
        String vresult=ActionSupport.INPUT;
        if (idutilisateur == null)
        {

            this.addActionError(getText("error.topo.missing.id"));
        }
        else
            por.supprimerLecteur(idutilisateur);
            vresult= ActionSupport.SUCCESS;
            this.addActionMessage("utilisateur a bien été supprimé avec succes");
        {
        }
    return vresult;
    }

    public String domodif() throws Exception {
        LOGGER.info("DANS LA METHODE DOMODIF");
        String resultat = ActionSupport.INPUT;
        if (lecteur != null)
        {
            if (lecteur.getNom() != null)
            {
                try {
                    Lecteur tmputil = por.rechercher(lecteur.getId());
                    tmputil.setIdentifiant(lecteur.getIdentifiant());
                    tmputil.setMotDePasse(lecteur.getMotDePasse());
                    tmputil.setNom(lecteur.getNom());
                    tmputil.setPrenom(lecteur.getPrenom());
                    tmputil.setNumCni("TR432FDS");
                    tmputil.setDateInscription(dateInscription);
                    tmputil.setDateDeNaissance(dateNaissance);
                    tmputil.setId(idutilisateur);
                    por.modifierLecteur(tmputil);
                }
                catch (NoSuchElementException e)
                {
                ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
                resultat = ActionSupport.SUCCESS;
            } else
                {
                this.addActionError("Id doit être défini");
                resultat = ActionSupport.ERROR;
                }
        } else {
            // Si topo est null c'est qu'on va entrer sur la jsp update.jsp, il faut embarquer les données sur lecteur afin de pré-rempir les champs de la page web
            lecteur = por.rechercher(idutilisateur);
        }
        return resultat;
    }

    public String domodifcoordonnees() throws Exception
    {


        LOGGER.info("DANS LA METHODE DOMODIFcoordonnes");
        String resultat = ActionSupport.INPUT;
        if (coordonnees != null)
        {
            if (coordonnees.getEmail() != null)
            {
                try {
                        Coordonnees tmputil = por.recherchercoordonnee(coordonnees.getLecteur().getId());
                        tmputil.setRue(coordonnees.getRue());
                        tmputil.setEmail(coordonnees.getEmail());
                        tmputil.setCodePostal(coordonnees.getCodePostal());
                        tmputil.setVille(coordonnees.getVille());
                        tmputil.setTelephone(coordonnees.getTelephone());
                        tmputil.setID(coordonnees.getID());
                        tmputil.setLecteur(por.rechercher(coordonnees.getLecteur().getId()));
                        por.modifierCooronnees(tmputil);
                    }catch (NoSuchElementException e)
                        {
                            ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
                        }
                            resultat = ActionSupport.SUCCESS;
            } else
                {
                    this.addActionError("Id doit être défini");
                    resultat = ActionSupport.ERROR;
                }
        } else
            {
            // Si topo est null c'est qu'on va entrer sur la jsp update.jsp, il faut embarquer les données sur lecteur afin de pré-rempir les champs de la page web
                coordonnees = por.recherchercoordonnee(idutilisateur);
            }
                return resultat;
    }

    public String doProfil()
    {
            LOGGER.info("DANS LA METHODE DODETAIL");
            idutilisateur=Integer.parseInt(getSession().get("id").toString());
            //gestion des erreurs si id du Utilisateur null
            if(idutilisateur==null)
        {
           //  this.addActionError(getText("error.topo.missing.id."));
        }
        else
            {
                lecteur=por.rechercher(idutilisateur);
                coordonnees=por.recherchercoordonnee(lecteur.getId());
                empruntList=por3.afficherlesemprunts();
            }

            {
            }
            return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;
    };
}