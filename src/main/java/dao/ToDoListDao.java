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
        toDoList.setSummary("Go to the walmart to buy milk and some clothes");
        toDoList.setTitle("Go to the walmart");
        toDoList.setDone(false);
        toDoList.setPriority(Priority.HIGH);
        toDoList.setId("1234444");
        toDoList.setCreateDate( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        toDoList.setButton("<button onclick=\"location.href = 'viewTodoList?id=" + toDoList.getId() +"'; return false;\">Edit</button>");
        toDoList.setDeleteButton("<button id='"+toDoList.getId()+"' onclick=\'deleteTask(this.id);return false;\'>Delete</button>");
        toDoList.setAsDoneButton("<button id='"+toDoList.getId()+"' onclick=\'setAsDone(this.id);return false;\'>Done</button>");


        ToDoList toDoList2 = new ToDoList();
        toDoList2.setDueDateTime("05/22/2020 08:00:00 AM");
        toDoList2.setStartDateTime("05/22/2020 05:00:00 PM");//arthur
        toDoList2.setUsername("sunil");
        toDoList2.setSummary("Read notes for exam");
        toDoList2.setTitle("Read Notes");
        toDoList2.setDone(false);
        toDoList2.setPriority(Priority.HIGH);
        toDoList2.setId("1235544");
        toDoList2.setCreateDate( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        toDoList2.setButton("<button onclick=\"location.href = 'viewTodoList?id=" + toDoList.getId() +"'; return false;\">Edit</button>");
        toDoList2.setDeleteButton("<button id='"+toDoList.getId()+"' onclick=\'deleteTask(this.id);return false;\'>Delete</button>");
        toDoList2.setAsDoneButton("<button id='"+toDoList.getId()+"' onclick=\'setAsDone(this.id);return false;\'>Done</button>");












        toDoLists.add(toDoList);
        toDoLists.add(toDoList2);
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
