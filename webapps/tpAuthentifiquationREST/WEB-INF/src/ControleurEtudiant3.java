import java.io.PrintWriter;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DS;
import model.UserDao;

@WebServlet("/etudiants3/*")
public class ControleurEtudiant3 extends HttpServlet {

    UserDao dao = new UserDao(new DS());

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String token = req.getHeader("Authorization");
        if (token == null) {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } else if (dao.verifTokenBasic(token.replace("Basic ", "").trim())) {
            res.setContentType("application/json;charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println(" { \"retour d'un GET\" : \"\" }");
            out.close();
        } else {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    
}