package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.biblio.p7.service.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class EmpruntAction extends ActionSupport implements SessionAware {

    @Override
    public void setSession(Map<String, Object> session) {

    }

    private final Logger LOGGER = (Logger) LogManager.getLogger(EmpruntAction.class);



    //LIAISON AVEC WEBSERVICE EMPRUNT
    AuthentificationService_Service authentificationService_service=new AuthentificationService_Service();
    AuthentificationService por=authentificationService_service.getAuthentificationServicePort();

    OuvrageService_Service ouvrageService_service=new OuvrageService_Service();
    OuvrageService por2=ouvrageService_service.getOuvrageServicePort();

    PretService_Service pretServicePort_client=new PretService_Service();
    PretService por3=pretServicePort_client.getPretServicePort();

    ReservationService_Service reservationService_service=new ReservationService_Service();
    ReservationService por4=reservationService_service.getReservationServicePort();



    //Parametre en Entrée
    private Integer id;
    private Integer idutilisateur;
    private String intitule;
    private String descrption;
    private String photo;
    private String numISBN;
    private String referenceInterne;
    private Integer numemprunt;
    private boolean renouvellement;
    private Date dateDemande;
    private Boolean notification;
    private Date dateNotification;
    private Integer ouvrageid;
    private Boolean controlereservable;
    private Integer nombreOuvrageAttente;
    private String message;
    private Date dateRetour;
    private XMLGregorianCalendar dteretour;


    private Ouvrage ouvrage;
    private Genre genre;
    private Editeur editeur;
    private Exemplaire exemplaire;
    private OuvrageGenre ouvrageGenre;
    private Auteur auteur;
    private Emprunt emprunt;
    private Reservation reservation;
    private Coordonnees coordonnees;
    private Lecteur lecteur;
    private Bibliotheque bibliotheque;
    private List<Bibliotheque> bibliothequeList;
    private List<Ouvrage> ouvrageList;
    private List<Exemplaire> exemplaireList=new ArrayList<>();
    private List<Editeur> editeurList;
    private List<Auteur> auteurList;
    private List<OuvrageGenre> ouvrageGenreList;
    List<Emprunt> empruntList=new ArrayList<>();
    List<Reservation> reservationList=new ArrayList<>();
    List<Reservation> filedattente=new ArrayList<>();



    //GETTER AND SETTER


    @Value("${duree.emprunt}")
    private int maxemprunt;


    @Value("${duree.prolongation}")
    private int maxprolongation;

    public boolean isRenouvellement() {
        return renouvellement;
    }

    public void setRenouvellement(boolean renouvellement) {
        this.renouvellement = renouvellement;
    }

    public Integer getNumemprunt() {
        return numemprunt;
    }

    public void setNumemprunt(Integer numemprunt) {
        this.numemprunt = numemprunt;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNumISBN() {
        return numISBN;
    }

    public void setNumISBN(String numISBN) {
        this.numISBN = numISBN;
    }

    public String getReferenceInterne() {
        return referenceInterne;
    }

    public void setReferenceInterne(String referenceInterne) {
        this.referenceInterne = referenceInterne;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
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

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public OuvrageGenre getOuvrageGenre() {
        return ouvrageGenre;
    }

    public void setOuvrageGenre(OuvrageGenre ouvrageGenre) {
        this.ouvrageGenre = ouvrageGenre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public List<Bibliotheque> getBibliothequeList() {
        return bibliothequeList;
    }

    public void setBibliothequeList(List<Bibliotheque> bibliothequeList) {
        this.bibliothequeList = bibliothequeList;
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

    public List<Editeur> getEditeurList() {
        return editeurList;
    }

    public void setEditeurList(List<Editeur> editeurList) {
        this.editeurList = editeurList;
    }

    public List<Auteur> getAuteurList() {
        return auteurList;
    }

    public void setAuteurList(List<Auteur> auteurList) {
        this.auteurList = auteurList;
    }

    public List<OuvrageGenre> getOuvrageGenreList() {
        return ouvrageGenreList;
    }

    public void setOuvrageGenreList(List<OuvrageGenre> ouvrageGenreList) {
        this.ouvrageGenreList = ouvrageGenreList;
    }

    public List<Emprunt> getEmpruntList() {
        return empruntList;
    }

    public void setEmpruntList(List<Emprunt> empruntList) {
        this.empruntList = empruntList;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
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

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public Date getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(Date dateNotification) {
        this.dateNotification = dateNotification;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Integer getOuvrageid() {
        return ouvrageid;
    }

    public void setOuvrageid(Integer ouvrageid) {
        this.ouvrageid = ouvrageid;
    }

    public Boolean getControlereservable() {
        return controlereservable;
    }

    public void setControlereservable(Boolean controlereservable) {
        this.controlereservable = controlereservable;
    }

    public Integer getNombreOuvrageAttente() {
        return nombreOuvrageAttente;
    }

    public void setNombreOuvrageAttente(Integer nombreOuvrageAttente) {
        this.nombreOuvrageAttente = nombreOuvrageAttente;
    }

    public List<Reservation> getFiledattente() {
        return filedattente;
    }

    public void setFiledattente(List<Reservation> filedattente) {
        this.filedattente = filedattente;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public XMLGregorianCalendar getDteretour() {
        return dteretour;
    }

    public void setDteretour(XMLGregorianCalendar dteretour) {
        this.dteretour = dteretour;
    }
    //LES METHODES

    String doemprunbyid(){
        LOGGER.info("dans la methode doemprunt");
        // empruntList = por.rechercherEmpruntparId()
        return ActionSupport.SUCCESS;
    }

    public String domodif() throws Exception {


        LOGGER.info("DANS LA METHODE DOMODIF");

        String resultat = ActionSupport.INPUT;

        if (numemprunt != null) {
            if (emprunt != null) {
                try {

                    Emprunt tmputil = por3.rechercherEmpruntparId(numemprunt);
                    ouvrage=por2.rechercherparISBN(numISBN);
                    exemplaire=por2.afficherexemplairebyID(id);
                    tmputil.isRenouvellement();
                    LOGGER.warn(" voir si on y est dedans ");
                    por3.modifierEmprunt(tmputil);
                }catch (NoSuchElementException e){
                    ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
                resultat = ActionSupport.SUCCESS;
            } else {
                this.addActionError("Id doit être défini");
                resultat = ActionSupport.ERROR;
            }
        } else {
            // Si topo est null c'est qu'on va entrer sur la jsp update.jsp, il faut embarquer les données sur lecteur afin de pré-rempir les champs de la page web
            emprunt = por3.rechercherEmpruntparId(numemprunt);
            lecteur=por.rechercher(id);
            coordonnees=por.recherchercoordonnee(lecteur.getId());
            empruntList=por3.afficherlesempruntsparLecteur(lecteur.getId());


        }
        return resultat;
    }

    //CORRECTED TICKET 1

    /**
     * Creation de la methode permettant de creer une reservation
     * @return
     */
    public String doresa() {
        final DateTime now = new DateTime();
//por4.attribuerUneReservation();
        LOGGER.info("dans la methode reservation");
        LocalDateTime currentTime = LocalDateTime.now();

        LocalDate date = currentTime.toLocalDate();
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        XMLGregorianCalendar datefin = null;
        try {
            datefin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String vresult = ActionSupport.INPUT;
        if (this.reservation != null) {
            if (this.reservation.getOuvrage().getID() == 0) {
                this.addActionError("erreur");
            } else {

            }

            if (!this.hasErrors()) {
                try {

                    //   reservation.setDateDemande(datefin);
                    reservation.setNotification(false);
                    reservation.setDateNotification(datefin);
                    reservation.setLecteur(this.reservation.getLecteur());
                    reservation.setOuvrage(this.reservation.getOuvrage());

                    por4.addreservation(this.reservation);

                    vresult = ActionSupport.SUCCESS;
                } catch (Exception e) {
                    vresult = ActionSupport.ERROR;
                }
            }
        } else {
            lecteur = por.rechercher(idutilisateur);
            ouvrage = por2.rechercherparId(ouvrageid);
            nombreOuvrageAttente = reservationList.size();

            //On crée une liste de toutes les reservations
            List<Reservation> listerlesreservation = por4.listerlesreservation();

            //on crée une liste des tous les exemplaires
            List<Exemplaire> afficherExemplaire = por2.afficherExemplaire();


            //on crée une liste de tous les emprunts
            List<Emprunt> afficherlesemprunts = por3.afficherlesemprunts();


            //Passe d'une double boucle ayant pour objet la selection de tous les exemplaires d'un ouvrage
            for (int i = 0; i < afficherExemplaire.size(); i++) {
                if (afficherExemplaire.get(i).getOuvrage().getID() == ouvrage.getID()) {
                    exemplaireList.add(afficherExemplaire.get(i));
                }
            }
            for (int i = 0; i < listerlesreservation.size(); i++) {
                if (listerlesreservation.get(i).getOuvrage().getID() == ouvrage.getID()) {
                    reservationList.add(listerlesreservation.get(i));
                }
            }


            //CORRECTED TICKET 1
            /*
            Boucle permettant de vériier que le nombre de reservation soit infèrieur a 2 fois le nombre d'exemplaire
            Regle de gestion Ticket 1
             */
            if (reservationList.size() < 2 * exemplaireList.size()) {
                controlereservable = true;
                filedattente = reservationList.stream()
                       .collect(Collectors.toList());
                nombreOuvrageAttente = filedattente.size();
                empruntList = por3.afficherlesemprunts();

                XMLGregorianCalendar dteretourtemp = por3.listerlesEmpruntParDateFin(ouvrageid).get(0).getDateFin();

                dteretour = dteretourtemp;

            } else {
                controlereservable = false;
                message = "Liste d'attente importante actuellement, reessayez plus tard";
            }

            //CORRECTED TICKET 1
            /*
              Boucle permettant de controler que le lecteur ne puisse réserver un ouvrage qu’il a déjà en cours d’emprunt
              Regle de gestion Ticket 1
           */
            empruntList = por3.afficherlesemprunts();
            for (Emprunt emprunt : empruntList
            ) {
                if (emprunt.getLecteur().getId() == lecteur.getId()) {
                    if (emprunt.getExemplaire().getOuvrage().getID() == ouvrage.getID()) {
                        controlereservable = false;
                        message="vous êtes en possession d'un exemplaire actuellement";
                        System.out.println("valeur de controlersv"+controlereservable.toString());
                    }
                }
            }
        }

        return vresult;
    }


    public String doresabyid(){
        LOGGER.info("dans la methode doresa");
        reservationList = por4.listerlesreservationparouvrage(id);
        return ActionSupport.SUCCESS;
    }



    public String doemprunt()
    {

        final DateTime now = new DateTime();
        // DatatypeFactory.newInstance (). NewXMLGregorianCalendar (now.toGregorianCalendar ());
        LOGGER.info("Dans la methode doemprunt");

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime currentTime2 = LocalDateTime.now();
        currentTime2=currentTime.plus(maxemprunt, ChronoUnit.DAYS);

        LocalDate date = currentTime2.toLocalDate();
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        XMLGregorianCalendar datefin = null;
        try {
            datefin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String vresult = ActionSupport.INPUT;

        //condition validant l'ajout de formulaire
        if (this.emprunt!=null)
        {
            if (this.emprunt.getExemplaire().getID()==0)
            {

                this.addActionError("erreur");
            }
            else
            {

            }
            if (!this.hasErrors())
            {
                try {
                    emprunt.setExemplaire(this.emprunt.getExemplaire());
                    emprunt.setLecteur(this.emprunt.getLecteur());
                    emprunt.setDateDebut(this.emprunt.getDateDebut());
                    emprunt.setDateFin(datefin);

                    por3.addemprunt(emprunt);

                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("reservation  "+emprunt.toString());
                }
                catch (Exception e)
                {
                    vresult = ActionSupport.ERROR;
                }
            }
        }else {
            lecteur=por.rechercher(idutilisateur);
            exemplaire=por2.afficherexemplairebyID(id);
        }
        return vresult;
    }
    public String doprolongation()
    {

        LOGGER.info("Dans la methode doemprunt");
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime currentTime2 = LocalDateTime.now();
        currentTime2=currentTime.plus(maxemprunt, ChronoUnit.DAYS);

        LocalDate date = currentTime2.toLocalDate();
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        XMLGregorianCalendar datefin = null;
        try {
            datefin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // Emprunt emprunt=new Emprunt();

        String vresult = ActionSupport.INPUT;

        //condition validant l'ajout de formulaire
        if (this.emprunt!=null)
        {
            if (this.emprunt.getExemplaire().getID()==0)
            {

                this.addActionError("erreur");
            }
            else
            {

            }
            if (!this.hasErrors())
            {
                try {
                    emprunt.setExemplaire(this.emprunt.getExemplaire());
                    emprunt.setLecteur(this.emprunt.getLecteur());
                    emprunt.setRenouvellement(this.emprunt.isRenouvellement());
                    emprunt.setDateRetourEffectif(datefin);
                    por3.modifierEmprunt(emprunt);
                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("reservation  "+emprunt.toString());
                }
                catch (Exception e)
                {
                    vresult = ActionSupport.ERROR;
                }
            }
        }else {
            lecteur=por.rechercher(idutilisateur);
            exemplaire=por2.afficherexemplairebyID(id);
            emprunt=por3.rechercherEmpruntparId(numemprunt);
        }
        return vresult;
    };

    public String doresaannulation(){
        por4.supprimerunereservation(id);
        return ActionSupport.SUCCESS;
    };



}
