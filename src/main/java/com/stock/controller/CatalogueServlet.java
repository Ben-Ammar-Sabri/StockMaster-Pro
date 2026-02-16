package com.stock.controller;

import com.stock.dao.IProduitDAO;
import com.stock.dao.ProduitDAOImpl;
import com.stock.model.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {

    private IProduitDAO dao = new ProduitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // --- GESTION DES COOKIES ---
        String lastVisit = "Première visite";
        jakarta.servlet.http.Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (jakarta.servlet.http.Cookie c : cookies) {
                if ("lastVisit".equals(c.getName())) {
                    lastVisit = c.getValue().replace("_", " ");
                }
            }
        }
        request.setAttribute("derniereVisite", lastVisit);

        // Ecriture du nouveau cookie
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter
                .ofPattern("dd/MM/yyyy_HH:mm:ss");
        jakarta.servlet.http.Cookie cookie = new jakarta.servlet.http.Cookie("lastVisit", now.format(formatter));
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        // --- PARTIE 5 : Couche DAO & JDBC (SQL Server) ---
        List<Produit> listeProduits = new ArrayList<>();
        try {
            listeProduits = dao.findAll();
            if (listeProduits.isEmpty()) {
                request.setAttribute("msg", "Aucun produit trouvé dans la base de données.");
            }
        } catch (Exception e) {
            request.setAttribute("erreurDB", "Erreur de connexion : " + e.getMessage());
        }

        request.setAttribute("listeProduits", listeProduits);
        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp").forward(request, response);
    }
}
