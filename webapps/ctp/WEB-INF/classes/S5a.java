import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/S5a")
public class S5a extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String test = request.getParameter("t");
        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        out.println("<h1>formulaire age</h1>");
        if(test != null) {
            out.println("<h1>Erreur mp ou login</h1>");
            out.println("<form action='S5b'>");
            out.println("<input name=\"login\" placeholder=\"Login\" type=\"text\">");
            out.println("<input name=\"mdp\" placeholder=\"Password\" type=\"password\">");
            out.println("<button>Let`s go!</button>");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            out.println("<form action='S5b'>");
            out.println("<input name=\"login\" placeholder=\"Login\" type=\"text\">");
            out.println("<input name=\"mdp\" placeholder=\"Password\" type=\"password\">");
            out.println("<button>Let`s go!</button>");
            out.println("</form>");
            out.println("</body></html>");
        }
        
        

    }
}