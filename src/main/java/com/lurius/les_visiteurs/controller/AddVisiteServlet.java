package com.lurius.les_visiteurs.controller;

import com.lurius.les_visiteurs.dao.VisiteDAO;
import com.lurius.les_visiteurs.model.VisiteEntity;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * Servlet AddVisiteServlet permettant d'ajouter une visite, redirige ensuite vers la page du planning crée
 * @Author Fitz
 **/
@WebServlet(name = "AddVisiteServlet", value = {"/add-visite-servlet"})
public class AddVisiteServlet extends HttpServlet {

    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        String[] planning = request.getParameter("planning").split("\\|");
        int idplanning = Integer.parseInt(planning[0]);
        String nomPlanning = planning[1].replace("_", " ");
        VisiteEntity visite = new VisiteEntity();
        visite.setIdPlanning(idplanning);
        visite.setNom(request.getParameter("nom"));
        visite.setNote(Integer.parseInt(request.getParameter("note")));

        visite.setDate(request.getParameter("date"));
        VisiteDAO visiteDAO = new VisiteDAO(visite);
        visiteDAO.creer();

        request.setAttribute("idPlanning", (Object) idplanning);
        request.setAttribute("nomPlanning", (Object) nomPlanning);

        request.getRequestDispatcher("/planning.jsp").forward((ServletRequest) request, (ServletResponse) response);

    }

}