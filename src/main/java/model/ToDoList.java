package model;

/**
 * Created by 986296 on 5/18/2018.
 */
public class ToDoList {
    private String username;
    private String createDate;
    private String title;
    private String summary;
    private String dueDateTime;//arthur
    private Priority priority;
    private String id;
    private String button;
    private  boolean done;

    private String deleteButton;
    private String asDoneButton;

    private String startDateTime;//arthur

    public boolean isDone(){return this.done;}

    public void setDone(boolean value){this.done=value;}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getStartDateTime(){return this.startDateTime;}

    public String getAsDoneButton(){return this.asDoneButton;}

    public  void setAsDoneButton(String value){this.asDoneButton = value;}
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(String dueDateTime) {
        this.dueDateTime = dueDateTime;
    }//arthur

    public void setStartDateTime(String startDateTime){this.startDateTime=startDateTime;}//arthur

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    @Override
    public boolean equals(Object obj){
        ToDoList toDoList = (ToDoList) obj;
        return this.id.equals(toDoList.id);
    }

    public String getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(String deleteButton) {
        this.deleteButton = deleteButton;
    }
}
