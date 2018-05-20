package controller;

import dao.ToDoListDao;
import model.ToDoList;

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
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Optional<ToDoList> toDoList = ToDoListDao.findToDoListById(id);
        PrintWriter out = resp.getWriter();
        out.println(toDoList.get().getExpiredDate());
        out.println(toDoList.get().getId());
        out.println(toDoList.get().getPriority());
        out.println(toDoList.get().getSummary());
        out.println(toDoList.get().getCreateDate());

    }
}
