package controller;

import dao.ToDoListDao;
import model.ToDoList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/viewTodoList")
public class TodoListViewServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        Optional<ToDoList> toDoList = ToDoListDao.findToDoListById(id);
        req.setAttribute("todoList", toDoList.isPresent());
        req.getRequestDispatcher("viewTodoList.jsp").forward(req,resp);

    }
}
