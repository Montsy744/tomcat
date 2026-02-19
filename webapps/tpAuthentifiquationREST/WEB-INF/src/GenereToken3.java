

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DS;
import model.UserDao;

@WebServlet("/genereToken3")
public class GenereToken3 extends HttpServlet {

    UserDao dao = new UserDao(new DS());

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getParameter("login");
        String psw = req.getParameter("psw");


        if(dao.getUser(login, psw) != null) {
            String uuid = JwtManager.createJWT();
            if(dao.addTokenAtUser(login, psw, uuid)) {
                res.setStatus(HttpServletResponse.SC_OK);
                res.getWriter().println(String.format("""
                            {
                                "token" : "%s"
                            }
                        """, uuid));
                return;
            } else {
                    res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
            
        } 
        res.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
