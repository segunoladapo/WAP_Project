package controller;//import javax.servlet.ServletException;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import model.User;
import model.response.AuthResponse;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        try {

            PrintWriter out = resp.getWriter();
            //AuthResponse authResponse = new AuthResponse();
            String uName = req.getParameter("userName").trim();
            String pwd = req.getParameter("passWord");
            String keepLogged = req.getParameter("keepLogged");

            if (uName != null && pwd != null && !uName.isEmpty() && !pwd.isEmpty()) {
                Optional<User> optUser = UserDao.findUserByPwdAndUsername(uName, pwd);

                if (optUser.isPresent()) {

                    HttpSession sess = req.getSession();
                    sess.setAttribute("userName", optUser.get());
                    if(keepLogged!=null && keepLogged.equalsIgnoreCase("yes")){
                        Cookie cU  = new Cookie("uName",uName);
                        Cookie cP  = new Cookie("pwd",pwd);
                        cU.setMaxAge(7200);
                        cP.setMaxAge(7200);
                        resp.addCookie(cU);
                        resp.addCookie(cP);
                    }
                    else {
                        for(Cookie c : req.getCookies()){
                            if (c.getName().equals("uName") || c.getName().equals("pwd")) {
                                c.setMaxAge(-1);
                                resp.addCookie(c);
                            }
                        }
                    }
                    resp.sendRedirect("/welcome");

                } else {


                    req.setAttribute("msg", "Invalid credentials");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);

                }
            } else {

                req.setAttribute("msg", "Provide both User Name and Password");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
            req.setAttribute("msg", "An error occured while processing the log in. If it persists please contact the administrator.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws IOException {

        if(req.getSession() != null || req.getSession().getAttribute("userName") != null){

            resp.sendRedirect("/welcome");
        }
    }
}