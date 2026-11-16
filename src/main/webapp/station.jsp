<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Stations & Carburants</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f7f6; }
        .container { max-width: 900px; margin: auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
        h1, h2 { color: #2c3e50; }
        .card { border: 1px solid #ddd; padding: 15px; border-radius: 6px; background: #fafafa; margin-bottom: 20px; }
        label { display: block; margin-top: 10px; font-weight: bold; }
        input { width: 95%; padding: 8px; margin-top: 5px; border: 1px solid #ccc; border-radius: 4px; }
        button { margin-top: 15px; padding: 10px 15px; background-color: #2980b9; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background-color: #1f6391; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #2c3e50; color: white; }
    </style>
</head>
<body>

<div class="container">
    <h1>Gestion des Stations & Prix des Carburants</h1>

    <!-- 1. RECHERCHE DES PRIX (Correspond à votre doGet) -->
    <div class="card" style="background-color: #eaf2f8;">
        <h2>🔍 Consulter les prix des carburants</h2>
        <form action="${pageContext.request.contextPath}/stations" method="get">
            <label>Nom de la Station :</label>
            <input type="text" name="station" value="${param.station}" placeholder="Ex: Afriquia" required>

            <label>Date :</label>
            <input type="date" name="date" value="${param.date}" required>

            <button type="submit">Rechercher les prix</button>
        </form>

        <!-- Résultats renvoyés via request.setAttribute("prixList", prixList) -->
        <c:if test="${not empty prixList}">
            <table>
                <thead>
                    <tr>
                        <th>Station</th>
                        <th>Carburant</th>
                        <th>Date</th>
                        <th>Prix (DH)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="h" items="${prixList}">
                        <tr>
                            <td>${h.station.nom}</td>
                            <td>${h.carburant.nom}</td>
                            <td>${h.date}</td>
                            <td><strong>${h.prix} DH</strong></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty prixList and not empty param.station}">
            <p style="color: #c0392b; margin-top: 10px;">Aucun prix trouvé pour cette station à cette date.</p>
        </c:if>
    </div>

    <!-- 2. AJOUT D'UNE STATION (Correspond à votre doPost action="addStation") -->
    <div class="card">
        <h2>⛽ Ajouter une nouvelle Station</h2>
        <form action="${pageContext.request.contextPath}/stations" method="post">
            <input type="hidden" name="action" value="addStation">

            <label>Nom de la station :</label>
            <input type="text" name="nom" required>

            <label>Ville :</label>
            <input type="text" name="ville" required>

            <label>Adresse :</label>
            <input type="text" name="adresse" required>

            <button type="submit">Ajouter la Station</button>
        </form>
    </div>
</div>

</body>
</html>