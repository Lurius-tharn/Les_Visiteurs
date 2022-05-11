package com.lurius.les_visiteurs.controller;


import com.lurius.les_visiteurs.dao.DAOCompte;
import com.lurius.les_visiteurs.model.Compte;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = {"/register-servlet"})
public class RegisterServlet extends HttpServlet {
    public void init() {
    }

    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/register.jsp").forward((ServletRequest) request, (ServletResponse) response);
    }

    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final HttpSession session = request.getSession();
        final Compte c = new Compte(login, password);
        final DAOCompte daoCompte = new DAOCompte(c);
        daoCompte.register();
        System.out.println(login);
        session.setAttribute("compte", (Object) c);
        request.getRequestDispatcher("/plannificator.jsp").forward((ServletRequest) request, (ServletResponse) response);
    }

    public void destroy() {
    }
}