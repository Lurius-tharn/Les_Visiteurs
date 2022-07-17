package com.lurius.les_visiteurs.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version 1.0
 * Servlet SignOutServlet supprime la session du compte courant, puis redirige vers la page d'authentification
 * @Author Fitz
 **/
@WebServlet(name = "SignOutServlet", value = {"/signOut-servlet"})
public class SignOutServlet extends HttpServlet {
    public void init() {
    }

    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("compte") != null) {
            session.setAttribute("compte", null);
        }
        request.getRequestDispatcher("/authentification.jsp").forward((ServletRequest) request, (ServletResponse) response);
    }

    public void destroy() {
    }
}