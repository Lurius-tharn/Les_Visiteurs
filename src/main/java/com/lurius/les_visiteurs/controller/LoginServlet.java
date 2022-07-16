package com.lurius.les_visiteurs.controller;

import com.lurius.les_visiteurs.dao.CompteDAO;
import com.lurius.les_visiteurs.model.CompteEntity;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = {"/login-servlet"})
public class LoginServlet extends HttpServlet {
    public void init() {
    }

    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        response.setContentType("text/html");
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final CompteEntity c = new CompteEntity();
        c.setLogin(login);
        c.setPassword(password);

        final CompteDAO daoCompte = new CompteDAO(c);
        if (daoCompte.LogIn()) {
            session.setAttribute("compte", (Object) c);
            request.getRequestDispatcher("/connected-servlet").forward((ServletRequest) request, (ServletResponse) response);
        } else {
            request.getRequestDispatcher("/authentification.jsp").forward((ServletRequest) request, (ServletResponse) response);
        }
    }

    public void destroy() {
    }
}