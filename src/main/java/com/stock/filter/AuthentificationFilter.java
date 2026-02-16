package com.stock.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Filtre de sécurité pour protéger l'accès au catalogue.
 * Si l'utilisateur n'est pas connecté (pas d'objet "user" en session),
 * il est redirigé vers la page de login.
 */
@WebFilter("/catalogue")
public class AuthentificationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialisation du filtre
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Récupération de la session sans en créer une nouvelle
        HttpSession session = httpRequest.getSession(false);

        // Vérification de l'existence de l'attribut "user"
        if (session != null && session.getAttribute("user") != null) {
            // Utilisateur authentifié : on laisse passer la requête
            chain.doFilter(request, response);
        } else {
            // Utilisateur non authentifié : redirection vers login.jsp avec message
            httpRequest.setAttribute("erreur", "Accès refusé. Veuillez vous connecter.");
            httpRequest.getRequestDispatcher("login.jsp").forward(httpRequest, httpResponse);
        }
    }

    @Override
    public void destroy() {
        // Nettoyage des ressources
    }
}
