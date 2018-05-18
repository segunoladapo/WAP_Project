package dao;

import model.ToDoList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 986296 on 5/18/2018.
 */
public class ToDoListDao {
    private static  List<ToDoList> toDoLists;
    {
        toDoLists = new ArrayList<>();
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
        toDoList1.setExpiredDate(toDoList.getExpiredDate());
        return toDoList1;
    }
}
