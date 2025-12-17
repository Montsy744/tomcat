import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Sla")
public class Sla extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String test = request.getParameter("t");

        if(test != null) {
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("<h1>Mettre un chiffre dans l'age</h1>");
            
            out.println("<form action='Slb'>");
            out.println("<input name='age' placeholder='Votre age ?' type='text'>");
            out.println("<button>Let`s go!</button>");
            out.println("</form>");

            out.println("</body></html>");
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("<h1>formulaire age</h1>");
            
            out.println("<form action='Slb'>");
            out.println("<input name='age' placeholder='Votre age ?' type='text'>");
            out.println("<button>Let`s go!</button>");
            out.println("</form>");

            out.println("</body></html>");
        }
        

    }
}