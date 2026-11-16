package com.example.controller;

import com.example.model.HistoCarb;
import com.example.ws.StationWebService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/stations")
public class StationServlet extends HttpServlet {

    // Injection directe de votre EJB/Web Service dans la Servlet
    @EJB
    private StationWebService stationWebService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupération des paramètres de recherche transmis par le formulaire JSP
        String stationNom = request.getParameter("station");
        String date = request.getParameter("date");

        if (stationNom != null && date != null && !stationNom.isEmpty()) {
            // Appel direct de la méthode métier de votre service
            List<HistoCarb> prixList = stationWebService.getPrixParStationEtDate(stationNom, date);
            request.setAttribute("prixList", prixList);
        }

        // Redirection vers la vue JSP
        request.getRequestDispatcher("/station.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Gérer ici les actions d'ajout (CRUD) si demandé par le TP
        String action = request.getParameter("action");

        if ("addStation".equals(action)) {
            String nom = request.getParameter("nom");
            String ville = request.getParameter("ville");
            String adresse = request.getParameter("adresse");

            stationWebService.addStation(nom, ville, adresse);
        }

        // Rediriger vers la page principale après traitement
        response.sendRedirect(request.getContextPath() + "/stations");
    }
}