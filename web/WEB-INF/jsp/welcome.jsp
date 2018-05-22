<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 986296
  Date: 5/19/2018
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">


    <link href="<c:url value="../../resources/css/taskslist.css" />" rel="stylesheet">
    <title>Dashboard - ToDo Master</title>
</head>
<body>
    <div id="logoutbuttondiv">
        <a href="/logout"><button class ="mybutton" id="logoutbutton" >Logout</button></a>
    </div>
<div id="container">
    <div id="leftwrapper">
        <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Date Created</th>
                <th>Title</th>
                <th>Start Date and Time</th>
                <th>Due date and Time</th>
                <th>Priority</th>
                <th>View</th>
                <th>Delete</th>
                <th>Done</th>
            </tr>
            </thead>

        </table>
    </div>
    <div id="rightwrapper">
        <div id="result"></div>
    <form>
        <div id="titlediv"><div id="titlelabel">Title</div>
            <input type="text" id="title" class="input" name="title" required>
        </div>

        <div id="startDatediv"><div id="startdatelabel">Start Date and Time</div>
            <input type="input" id="startDateTime"
                   class="input"
                   name="startDateTime" placeholder="MM/DD/YYYY"
                   required title ="Format: MM/DD/YYYY"
                   pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}" />
        </div>

        <div id="expirydiv"><div id="datelabel">Due Date and Time</div>
            <input type="input" id="dueDateTime"
                   class="input"
                   name="dueDateTime" placeholder="MM/DD/YYYY"
                   required title ="Format: MM/DD/YYYY"
                   pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}" />
        </div>

        <div id="summarydiv"><div id="summarylabel">Summary</div>
            <textarea id="summary" name="summary" required></textarea>
        </div>

        <div id="prioritydiv"><div id="prioritylabel">Priority</div>
            <select id="priority" name="priority" required>
                <option value="LOW">Low</option>
                <option value="MEDIUM">Medium</option>
                <option value="HIGH">High</option>
            </select>
        </div>
        <div id="submitdiv">
            <input type="submit" value="Submit" class="mybutton" id="submitbutton">
        </div>
    </form>
    </div>
</div>
</body>
<script>

    function deleteTask(id){
        if(confirm("Do you really want to delete this task ?")){
            removeFromView(id);
        }
    }


    function setAsDone(id) {
        //alert(id);
        if(confirm("Do you want to mark this task as done ?")){
            removeFromView(id);
        }
    }
    function removeFromView(id) {
        //alert(id);

            location.href = "todolistdelete?id="+id;

    }
    $(document).ready(function() {
        $("#example").DataTable({
            "ajax": {
                "url": "/todoList",
                "dataSrc":""
            },
            "columns": [
                { "data": "createDate" },
                { "data": "title" },
                { "data": "startDateTime" },
                { "data": "dueDateTime" },
                { "data": "priority" },
                { "data": "button" },
                { "data":"deleteButton"},
                { "data":"asDoneButton"}
            ]
        });
    });
    $(function () {
            $("#submitbutton").click(
                function (eventData) {
                    var title = $("#title").val();
                    var expiredDate = $("#dueDateTime").val();
                    var summary = $("#summary").val();
                    var priority = $("#priority").val();

                    var startDate = $("#startDateTime").val();

                    var selectedDate = new Date(expiredDate);
                    var now = new Date();

                    if (!(new Date(expiredDate) !== "Invalid Date" && !isNaN(new Date(expiredDate)))){
                        $("#result").text("Invalid Due Date");
                        return false;
                    }
                    if (!(new Date(startDate) !== "Invalid Date" && !isNaN(new Date(startDate)))){
                        $("#result").text("Invalid Start Date");
                        return false;
                    }

                    if (selectedDate < now) {
                        $("#result").text("Invalid Date");
                        return false;
                    }
                    if(title === "" || expiredDate === "" || summary ==="" || priority === ""){
                        $("#result").text("Please enter some texts in the missing fields");
                        return false;
                    }else {

                        $.post(
                            "/todoList",
                            {"title": title, "dueDateTime": expiredDate,"startDateTime":startDate, "summary": summary, "priority": priority})
                            .done(function (data) {
                                $("#title").value = "";
                                $("#dueDateTime").value = "";
                                $("#startDateTime").value = "";
                                $("#summary").value = "";
                                $("#result").text(data.message);
                                $("#example").DataTable({
                                    destroy: true,
                                    "ajax": {
                                        "url": "/todoList",
                                        "dataSrc": ""
                                    },
                                    "columns": [
                                        {"data": "createDate"},
                                        {"data": "title"},
                                        { "data": "startDateTime" },
                                        { "data": "dueDateTime" },
                                        {"data": "priority"},
                                        {"data": "button"},
                                        { "data":"deleteButton"}
                                    ]

                                });
                            });


                        }
                }
            );
        }
    );
</script>
</html>
