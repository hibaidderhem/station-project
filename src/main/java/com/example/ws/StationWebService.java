package com.example.ws;

import com.example.model.Carburant;
import com.example.model.HistoCarb;
import com.example.model.Station;
import jakarta.ejb.Stateless;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import jakarta.ejb.LocalBean;


@LocalBean
@Stateless
@WebService(serviceName = "StationWebService")
public class StationWebService {

    @PersistenceContext(unitName = "StationPU")
    private EntityManager em;

    // Station CRUD
    @WebMethod
    public void addStation(String nom, String ville, String adresse) {
        em.persist(new Station(nom, ville, adresse));
    }

    @WebMethod
    public Station getStation(String nom) {
        return em.find(Station.class, nom);
    }

    // Carburant CRUD
    @WebMethod
    public void addCarburant(String nom, String description) {
        em.persist(new Carburant(nom, description));
    }

    // Daily Prices & Filtering
    @WebMethod
    public void setPrixCarburant(String stationNom, String carburantNom, String date, double prix) {
        em.merge(new HistoCarb(stationNom, carburantNom, date, prix));
    }

    @WebMethod
    public List<HistoCarb> getPrixParStationEtDate(@WebParam(name = "nom_station") String nomStation,
                                                   @WebParam(name = "date") String date) {
        return em.createQuery("SELECT h FROM HistoCarb h WHERE h.station = :station AND h.date = :date", HistoCarb.class)
                .setParameter("station", nomStation)
                .setParameter("date", date)
                .getResultList();
    }
}