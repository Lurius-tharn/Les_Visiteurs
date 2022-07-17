package com.lurius.les_visiteurs.controller;


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
 * Servlet planningServlet redirige vers la page planning avec ses informations
 * @Author Fitz
 **/
@WebServlet(name = "planningServlet", value = {"/planning-servlet"})
public class PlanningServlet extends HttpServlet {
    public void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        String[] planning = req.getParameter("planning").split("\\|");
        int idplanning = Integer.parseInt(planning[0]);
        String nomPlanning = planning[1].replace("_", " ");
        System.out.println(nomPlanning);
        req.setAttribute("idPlanning", (Object) idplanning);
        req.setAttribute("nomPlanning", (Object) nomPlanning);

        req.getRequestDispatcher("/planning.jsp").forward((ServletRequest) req, (ServletResponse) resp);
    }
}