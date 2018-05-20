package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ToDoListDao;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 986296 on 5/19/2018.
 */

@WebServlet("/todoList")
public class ToDoListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession sessionObject = req.getSession();
        User user = (User) sessionObject.getAttribute("userName");
        ToDoList toDoList = new ToDoList();
        toDoList.setId(UUID.randomUUID().toString());
        toDoList.setPriority(Priority.valueOf((String)req.getParameter("priority")));
        toDoList.setCreateDate(new Date().toString());
        toDoList.setExpiredDate(req.getParameter("createdDate"));
        toDoList.setTitle(req.getParameter("title"));
        toDoList.setUsername(user.getUsername());
        toDoList.setSummary(req.getParameter("summary"));
        toDoList.setButton("<button onclick=\"location.href = 'viewTodoList?id=" + toDoList.getId() +"'; return false;\">View</button>");

        ToDoListDao.AddList(toDoList);
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Response response = new Response();
        response.setMessage("Todo List saved!");
        String serialized = new ObjectMapper().writeValueAsString(response);
        out.print(serialized);
        out.flush();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession sessionObject = req.getSession();
        User user = (User) sessionObject.getAttribute("userName");
        List<ToDoList> toDoLists = ToDoListDao.getToDoListsByUsername(user.getUsername());
        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();
        TodoListResponse todoListResponse = new TodoListResponse();
        todoListResponse.setData(toDoLists);
        String serialized = new ObjectMapper().writeValueAsString(toDoLists);
        out.print(serialized);
        out.flush();
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession sessionObject = req.getSession();
        User user = (User) sessionObject.getAttribute("userName");
        String id = req.getParameter("id");
    }
}