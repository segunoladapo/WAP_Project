package model;

import java.util.List;

/**
 * Created by 986296 on 5/19/2018.
 */
public class TodoListResponse {
    private List<ToDoList> data;

    public List<ToDoList> getData() {
        return data;
    }

    public void setData(List<ToDoList> data) {
        this.data = data;
    }
}
