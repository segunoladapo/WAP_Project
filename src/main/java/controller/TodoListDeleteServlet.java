package controller;

import dao.ToDoListDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 986296 on 5/21/2018.
 */

@WebServlet("/todolistdelete")
public class TodoListDeleteServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        ToDoListDao.deleteTodoList(id);
        resp.sendRedirect("/welcome");
    }
}