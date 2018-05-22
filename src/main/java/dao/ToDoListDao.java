package dao;

import model.Priority;
import model.ToDoList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by 986296 on 5/18/2018.
 */
public class ToDoListDao {
    private static  List<ToDoList> toDoLists;
    static {
        toDoLists = new ArrayList<>();
        ToDoList toDoList = new ToDoList();
        toDoList.setDueDateTime("12/12/2020");
        toDoList.setStartDateTime("12/12/2020");//arthur
        toDoList.setUsername("sunil");
        toDoList.setSummary("Hello Summart");
        toDoList.setTitle("hello title");
        toDoList.setPriority(Priority.HIGH);
        toDoList.setId("1234444");
        toDoList.setCreateDate( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        toDoList.setButton("<button onclick=\"location.href = 'viewTodoList?id=" + toDoList.getId() +"'; return false;\">View</button>");
        toDoList.setDeleteButton("<button onclick=\"location.href = 'todolistdelete?id=" + toDoList.getId() +"'; return false;\">Delete</button>");
        toDoLists.add(toDoList);
    }

    public static void AddList(ToDoList toDoList){
        toDoLists.add(toDoList);
    }

    public static List<ToDoList> getToDoListsByUsername(String username){
        return toDoLists.stream()
                .filter(todo -> todo.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    public static ToDoList updateList(ToDoList toDoList){
        ToDoList toDoList1 = toDoLists.stream()
                .filter(todo -> todo.getId().equals(toDoList.getId())).findAny().get();
        toDoList1.setPriority(toDoList.getPriority());
        toDoList1.setSummary(toDoList.getSummary());
        toDoList1.setDueDateTime(toDoList.getDueDateTime());
        toDoList.setTitle(toDoList.getTitle());
        return toDoList1;
    }

    public static Optional<ToDoList> findToDoListById(String id){
        return toDoLists.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst();
    }

    public static void deleteTodoList(String id){
        ToDoList objToRemove = new ToDoList();
        objToRemove.setId(id);
        toDoLists.remove(objToRemove);
    }
}
