package controller;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet("/creeateuser")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username!= null && password != null){
            Optional<User> optionalUser = UserDao.findUser(username);
            if(optionalUser.isPresent()){
                req.setAttribute("msg","Username Already exist. Please use another username");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
                return;
            }
            User newUser = new User();
            newUser.setPassword(password);
            newUser.setUsername(username);
            UserDao.createUser(newUser);
            req.setAttribute("msg","Account Created successfully, please login with your credentials.");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }else{
            req.setAttribute("msg","Account not created. Field missing.");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }


    }
}