import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Statut")
public class Statut extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        String token = (String) session.getAttribute("token");
        boolean estConnecte = (token == null ? false : true);
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        out.println("<h1>État de la connexion</h1>");

        if (estConnecte) {
            out.println("<h2 style='color:green'>Utilisateur connu du SGBD</h2>");
            out.println("<p>Bienvenue " + session.getAttribute("userLogin") + "</p>");
        } else {
            out.println("<h2 style='color:red'>Inconnu</h2>");
            out.println("<a href='index.html'>Retour au login</a>");
        }

        out.println("</body></html>");

    }
}
