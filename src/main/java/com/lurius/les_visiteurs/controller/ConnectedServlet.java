package com.lurius.les_visiteurs.controller;

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

/**
 * @version 1.0
 * Servlet ConnectedServlet créant une session Compte, puis redirigeant l'utilisateur vers la page principale
 * l'utilisateur lors de la création de compte existe dans la base
 * @Author Fitz
 **/
@WebServlet(name = "ConnectedServlet", value = {"/connected-servlet"})
public class ConnectedServlet extends HttpServlet {
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        response.setContentType("text/html");
        final CompteEntity c = (CompteEntity) session.getAttribute("compte");
        request.getRequestDispatcher("/plannificator.jsp").forward((ServletRequest) request, (ServletResponse) response);
    }

    public void destroy() {
    }
}