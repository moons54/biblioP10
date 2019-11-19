package org.biblio.p7.service;

import org.biblio.p7.bean.Reservation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "ReservationService")
public interface ReservationService {

    @WebMethod
    public List<Reservation> Listerlesreservation();

    @WebMethod
    public void ajouterunereservation(Reservation reservation);

    @WebMethod
    public Reservation modifierunereservation(Reservation reservation);

    @WebMethod
    public Reservation supprimerunereservation(@WebParam(name = "iD") int iD);

    @WebMethod
    public List<Reservation> listerlesreservationparlecteur(@WebParam(name = "iD") int iD);

    @WebMethod
    public List<Reservation> listerlesreservationparouvrage(@WebParam(name = "iD") int iD);

}
