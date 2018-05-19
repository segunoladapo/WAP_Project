package controller;//import javax.servlet.ServletException;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Optional;

public class AuthenticationServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.print("AuthenticationServlet initialized...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();

        String uName = req.getParameter("userName");
        String pwd = req.getParameter("passWord");
        String keepLogged = req.getParameter("keepLogged");

        if (uName != null && pwd != null && !uName.isEmpty() && !pwd.isEmpty()) {
            Optional<User> optUser = UserDao.findUserByPwdAndUsername(uName, pwd);

            if (optUser.isPresent()) {

                HttpSession sess = req.getSession();
                sess.setAttribute("userName", optUser.get());
                out.print("{\"auth\":\"YES\",\"message\":\"You are connected\"}");
            } else {
                //out.print("{'auth':'NO','message':'Invalid credentials'}");
                out.print("{\"auth\":\"NO\",\"message\":\"Invalid credentials\"}");
            }
        } else
        {
            out.print("{\"auth\":\"NO\",\"message\":\"Provide both User Name and Password\"}");
            //out.print("{'auth':'NO','message':'Provide both User Name and Password'}");
        }
    }


}