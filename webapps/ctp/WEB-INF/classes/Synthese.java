import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Synthese")
public class Synthese extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);
        String age = (String) session.getAttribute("age");
        String emploie = (String) session.getAttribute("situation");
        String[] sport = (String[]) session.getAttribute("sport");

        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        out.println("<h1>age utilisateur :</h1>");
        out.println("<p>" + age +"</p>");
        out.println("<h1>situation pro :</h1>");
        out.println("<p>" + emploie +"</p>");
        out.println("<h1>sport :</h1>");
        for(int i = 0; i < sport.length; i++) {
            out.println("<p>" + sport[i] +"</p>");
        }
        out.println("<form action='S4'>");
        out.println("<button>Let`s go!</button>");
        out.println("</form>");

        out.println("</body></html>");
        
        
    }
}