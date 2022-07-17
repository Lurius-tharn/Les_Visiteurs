package com.lurius.les_visiteurs.controller;

import com.lurius.les_visiteurs.dao.CompteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * Servlet AccountExist vérifiant si le login rentré par
 * l'utilisateur lors de la création de compte existe dans la base
 * @Author Fitz
 **/
@WebServlet(name = "accountExist", value = {"/account-exist"})
public class AccountExist extends HttpServlet {
    public void init() {
    }

    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        // Le login est récupéré à partir de la requete http
        final String login = request.getParameter("login");
        String errorText = "";
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        if (CompteDAO.alreadyExists(login)) {
            errorText = "Le login " + login + " existe d\u00e9ja";
        }
        // Envoie d'une balise html au service AJAX

        response.getWriter().write("<message>" + errorText + "</message>");
    }

    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    }

    public void destroy() {
    }
}