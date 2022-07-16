package com.lurius.les_visiteurs.controller;

import com.lurius.les_visiteurs.dao.PlanningDAO;
import com.lurius.les_visiteurs.model.PlanningEntity;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddPlanningServlet", value = {"/add-planning-servlet"})
public class AddPlanningServlet extends HttpServlet {

    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        PlanningEntity planningEntity = new PlanningEntity();
        planningEntity.setNom(request.getParameter("nom"));

        PlanningDAO planningDAO = new PlanningDAO(planningEntity);
        Integer idPlanning = planningDAO.creer();

        request.setAttribute("idPlanning", (Object) idPlanning);
        request.setAttribute("nomPlanning", (Object) request.getParameter("nom"));

        request.getRequestDispatcher("/planning.jsp").forward((ServletRequest) request, (ServletResponse) response);
    }
}
