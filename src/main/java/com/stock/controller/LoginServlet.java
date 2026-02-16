package com.stock.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        // --- PARTIE 2 : Authentification & Session ---
        if ("admin".equals(login) && "123".equals(pass)) {
            // Création de la session
            HttpSession session = request.getSession();
            session.setAttribute("user", "admin");

            // Redirection vers le catalogue
            response.sendRedirect(request.getContextPath() + "/catalogue");
        } else {
            // Echec : retour au login avec message d'erreur
            request.setAttribute("erreur", "Login ou mot de passe incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirection vers login.jsp si appel en GET sur /connexion
        response.sendRedirect("login.jsp");
    }
}
