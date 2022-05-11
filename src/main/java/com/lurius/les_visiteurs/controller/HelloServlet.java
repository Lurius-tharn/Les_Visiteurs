package com.lurius.les_visiteurs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "helloServlet", value = { "/hello-servlet-modif" })
public class HelloServlet extends HttpServlet
{
    private String message;

    public void init() {
        this.message = "Hello World!";
    }

    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        final HttpSession session = request.getSession();
        session.setAttribute("compte", (Object)null);
        final PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + this.message + "</h1>");
        out.println("<Form method = 'GET' action='login-servlet'>");
        out.println("<label>Login Test <Input name='login' type='text'></label>");
        out.println("<label>Mdp <Input name='password'  type='text'></label>");
        out.println("<Input  type='submit' value = 'se connecter'> ");
        out.println("</Form>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}