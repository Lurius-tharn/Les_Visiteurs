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

@WebServlet(name = "suprimerServlet", value = {"/supprimer-servlet"})
public class SupprimerServlet extends HttpServlet {
    public void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final int idPlanning = Integer.parseInt(req.getParameter("idPlanning"));
        final String[] visites = req.getParameter("visites").split(",");
        System.out.println(visites);
        VisiteDAO visiteDAO = new VisiteDAO();

        req.setAttribute("idPlanning", (Object) idPlanning);
        for (String idVisite : visites
        ) {
            VisiteEntity visiteEntity = new VisiteEntity();
            visiteEntity.setIdVisite(Integer.parseInt(idVisite));
            visiteEntity.setIdPlanning(idPlanning);
            visiteDAO.setVisite(visiteEntity);
            visiteDAO.supprimer();

        }

        req.getRequestDispatcher("/planning.jsp").forward((ServletRequest) req, (ServletResponse) resp);
    }
}