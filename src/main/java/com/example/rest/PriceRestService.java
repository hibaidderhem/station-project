package com.example.rest;

import com.example.model.HistoCarb;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/prices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PriceRestService {

    @PersistenceContext(unitName = "StationPU")
    private EntityManager em;

    @GET
    @Path("/{nom_station}/{date}")
    public List<HistoCarb> getPrixParStationEtDate(
            @PathParam("nom_station") String nomStation,
            @PathParam("date") String date) {

        return em.createQuery("SELECT h FROM HistoCarb h WHERE h.station = :station AND h.date = :date", HistoCarb.class)
                .setParameter("station", nomStation)
                .setParameter("date", date)
                .getResultList();
    }
}