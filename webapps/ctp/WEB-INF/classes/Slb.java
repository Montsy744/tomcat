import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Slb")
public class Slb extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String age = request.getParameter("age");
        boolean isNb = false;
        boolean age40 = false;
        boolean age55 = false;
        
        try {
            int ageNum = Integer.parseInt(age);
            if(ageNum < 40) {
                age40 = true;
            }
            if (ageNum > 55) {
                age55 = true;
            }
            isNb = true;
        } catch (NumberFormatException e) {
            response.sendRedirect("Sla?t=true");
        }
        
        if(isNb){
            try {
                HttpSession session = request.getSession();
                session.setAttribute("age", age); 
            } catch (Exception e) {
                out.println("<!doctype html>");
                out.println("<head><title>servlet Authent Failed</title></head><body><center> ");
                out.println("<h1>" + e.getMessage() + "</h1>");
                out.println("</body></html> ");
            }
            if (age55) {
                response.sendRedirect("S2a?55=true");
            } else if(age40) {
                response.sendRedirect("S2a?40=true");
            } else {
                response.sendRedirect("S2a");
            }
        }
        
    }
        
}
