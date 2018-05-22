<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: loknath
  Date: 5/20/2018
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

    <link href="<c:url value='resources/css/todotaskslist.css' />" rel="stylesheet">
    <title>Edit Your Item</title>

</head>
<body>
<div id="logoutbuttondiv">
    <a href="/logout"><button class ="mybutton" id="logoutbutton" >Logout</button></a>
</div>
<div id="container">
    <div id="result"></div>
    <form method="post" action="/viewTodoList" onsubmit="return(validate());">
<div id="titlediv"><div id="titlelabel">Title</div>
    <input value="<c:out value='${todoList.title}'/>" type="text" id="title" class="input" name="title" required >
</div>
    <div id="startdatediv"><div id="startdatelabel">Start Date and Time</div>
        <input type="text" id="startDateTime" class="input" name="startDateTime" required value="${todoList.startDateTime}">
    </div>

<div id="expirydiv"><div id="datelabel">Due Date and Time </div>
    <input type="text" id="dueDateTime" class="input" name="dueDateTime" required value="${todoList.dueDateTime}">
</div>

<div id="summarydiv"><div id="summarylabel">Summary</div>
    <textarea id="summary" name="summary" required >${todoList.summary} </textarea>
</div>
        <input type="hidden" value="${todoList.id}" name="id"/>
<div id="prioritydiv"><div id="prioritylabel">Priority</div>
    <select id="priority" name="priority" required>
        <option value="${todoList.priority}">${todoList.priority}</option>
        <option value="LOW">Low</option>
        <option value="MEDIUM">Medium</option>
        <option value="HIGH">High</option>
    </select>
</div>
<div id="submitdiv">
    <input type="submit" value="Update" class="mybutton" id="submitbutton">
    <button class="mybutton" id="backButton">Done</button>
</div>
    </form>
</div>
</body>
<script>
    $(
        function () {
            $("#backButton").click(function (evt) {
                evt.preventDefault();
                window.location='/welcome';
            });
        }
    );


    function validate() {
        var title = $("#title").val();
        var startDate = $("#startDatTime").val();
        var expiredDate = $("#dueDateTime").val();
        var summary = $("#summary").val();
        var priority = $("#priority").val();
        var selectedDate = new Date(expiredDate);
        var now = new Date();

        if (selectedDate < now) {
            $("#result").text("Invalid Date");
            return false;
        }

        if (!(new Date(expiredDate) !== "Invalid Date" && !isNaN(new Date(expiredDate))) && !(new Date(startDate) !== "Invalid Date" && !isNaN(new Date(startDate)))){
            $("#result").text("Invalid Start or Due Date");
            return false;
        }

        if(title === "" || expiredDate === "" || summary ==="" || priority === "") {
            $("#result").text("Please enter some texts in the missing fields");
            return false;
        }
        return (true);

    }
</script>
</html>
