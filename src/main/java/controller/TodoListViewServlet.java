package controller;

import dao.ToDoListDao;
import model.Priority;
import model.ToDoList;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/viewTodoList")
public class TodoListViewServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        Optional<ToDoList> toDoList = ToDoListDao.findToDoListById(id);
        req.setAttribute("todoList", toDoList.get());
        req.getRequestDispatcher("viewTodoList.jsp").forward(req,resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession sessionObject = req.getSession();
        User user = (User) sessionObject.getAttribute("userName");
        String id = req.getParameter("id");
        Optional<ToDoList> toDoListOptional = ToDoListDao.findToDoListById(id);
        ToDoList toDoList = toDoListOptional.get();
        toDoList.setExpiredDate(req.getParameter("expiredDate"));
        toDoList.setTitle(req.getParameter("title"));
        toDoList.setPriority(Priority.valueOf(req.getParameter("priority")));
        toDoList.setSummary(req.getParameter("summary"));
        ToDoListDao.updateList(toDoList);
        req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(req,resp);
    }
}
