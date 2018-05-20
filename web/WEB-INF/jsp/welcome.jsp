<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 986296
  Date: 5/19/2018
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

    <link href="<c:url value="../../resources/css/taskslist.css" />" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div id="container">
    <a href="/logout"><button class ="mybutton" id="logoutbutton" >Logout</button></a>
    <div id="leftwrapper">
        <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Name</th>
                <th>Date Created</th>
                <th>Title</th>
                <th>Expiry Date</th>
                <th>Priority</th>
                <th>View</th>
            </tr>
            </thead>

        </table>
    </div>
    <div id="rightwrapper">
        <div id="result"></div>

            <label id="labeltitle">Title </label>
            <input type="text" id="title" class="input" name="title"> <br>

            <label id="labeldate">Expiry Date </label>
            <input type="text" id="expiredDate" class="input" name="expiredDate"> <br>

            <textarea id="summary" name="summary">Summary</textarea> <br>

            <label id="labelpriority">Priority</label>
            <select id="priority" name="priority">
                <option value="LOW">Low</option>
                <option value="MEDIUM">Medium</option>
                <option value="HIGH">High</option>
            </select></label>
            <br>
            <input type="submit" value="Submit" class="mybutton" id="submitbutton">

    </div>
</div>

</body>
<script>
    $(document).ready(function() {
        $("#example").DataTable({
            "ajax": {
                "url": "/todoList",
                "dataSrc":""
            },
            "columns": [
                { "data": "username" },
                { "data": "createDate" },
                { "data": "title" },
                { "data": "expiredDate" },
                { "data": "priority" },
                { "data": "button" }
            ]

        });
    });
    $(function () {

            $("#submitbutton").click(
                function (eventData) {

                    var title = $("#title").val();
                    var expiredDate = $("#expiredDate").val();
                    var summary = $("#summary").val();
                    var priority = $("#priority").val();
                    $.post(
                        "/todoList",
                        {"title":title,"expiredDate":expiredDate,"summary":summary,"priority":priority})
                        .done(function( data ) {
                            $("#result").text(data.message);
                            $("#example").DataTable({
                                destroy:true,
                                "ajax": {
                                    "url": "/todoList",
                                    "dataSrc":""
                                },
                                "columns": [
                                    { "data": "username" },
                                    { "data": "createDate" },
                                    { "data": "title" },
                                    { "data": "expiredDate" },
                                    { "data": "priority" },
                                    { "data": "button" }
                                ]

                            });
                        });

                }
            );
        }
    );
</script>

</html>
