<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html lang="fr">

        <head>
            <meta charset="UTF-8">
            <title>Catalogue des Produits - StockMaster Pro</title>
            <style>
                body {
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                    margin: 2rem;
                    background-color: #f8f9fa;
                }

                .header {
                    background: white;
                    padding: 1rem;
                    border-radius: 8px;
                    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
                    margin-bottom: 2rem;
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                }

                h2 {
                    color: #333;
                }

                table {
                    width: 100%;
                    border-collapse: collapse;
                    background: white;
                    border-radius: 8px;
                    overflow: hidden;
                    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
                }

                th,
                td {
                    padding: 1rem;
                    text-align: left;
                    border-bottom: 1px solid #eee;
                }

                th {
                    background-color: #007bff;
                    color: white;
                }

                tr:hover {
                    background-color: #f1f1f1;
                }

                .user-info {
                    font-weight: bold;
                    color: #007bff;
                }
            </style>
        </head>

        <body>
            <div class="header">
                <h2>StockMaster Pro</h2>
                <div class="user-info">
                    Utilisateur connecté : ${sessionScope.user} |
                    Dernière visite : ${requestScope.derniereVisite}
                </div>
            </div>
            <h3>Liste des Produits</h3>

            <%-- Messages d'erreur ou d'info pour le diagnostique --%>
                <c:if test="${not empty requestScope.erreurDB}">
                    <div style="color: red; padding: 10px; border: 1px solid red; margin-bottom: 10px;">
                        ⚠️ <strong>Erreur de Base de Données :</strong> ${requestScope.erreurDB}
                    </div>
                </c:if>
                <c:if test="${not empty requestScope.msg}">
                    <div style="color: orange; padding: 10px; border: 1px solid orange; margin-bottom: 10px;">
                        ℹ️ ${requestScope.msg}
                    </div>
                </c:if>

                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Prix</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${listeProduits}">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.nom}</td>
                                <td>${p.prix} €</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </body>

        </html>