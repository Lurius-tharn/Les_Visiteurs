package com.lurius.les_visiteurs.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "planningServlet", value = { "/planning-servlet" })
public class PlanningServlet extends HttpServlet
{
    public void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final int idPlanning = Integer.parseInt(req.getParameter("idPlanning"));
        req.setAttribute("idPlanning", (Object)idPlanning);
        req.getRequestDispatcher("/planning.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}