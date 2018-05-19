package controller;//import javax.servlet.ServletException;

import model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //super.doGet(req, resp);
        HttpSession sessionObject = req.getSession();
        User user = (User) sessionObject.getAttribute("userName");

        PrintWriter pr = resp.getWriter();


        pr.print("<html><head><title>Welcome " + user.getUsername() + "</title></head><body>");
        pr.print("Welcome " + user.getUsername() + " <a href='logout' title='Logout here'>Log out</a>");
        pr.print("</body></html>");

    }
}
