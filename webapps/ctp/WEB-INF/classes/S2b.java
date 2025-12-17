import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/S2b")
public class S2b extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String s = request.getParameter("emploi");

        try {
            HttpSession session = request.getSession(true);
            session.setAttribute("situation", s); 
        } catch (Exception e ){
            out.println("<!doctype html>");
            out.println("<head><title>servlet Authent Failed</title></head><body><center> ");
            out.println("<h1>" + e.getMessage() + "</h1>");
            out.println("</body></html> ");
        }
    
        response.sendRedirect("S3a");

    }
        
}
        

