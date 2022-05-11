package com.lurius.les_visiteurs.controller;

import com.lurius.les_visiteurs.dao.DAOCompte;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "accountExist", value = {"/account-exist"})
public class AccountExist extends HttpServlet {
    public void init() {
    }

    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        final String login = request.getParameter("login");
        String errorText = "";
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        if (DAOCompte.isAlreadyExisted(login)) {
            errorText = "Le login " + login + " existe d\u00e9ja";
        }
        response.getWriter().write("<message>" + errorText + "</message>");
    }

    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    }

    public void destroy() {
    }
}