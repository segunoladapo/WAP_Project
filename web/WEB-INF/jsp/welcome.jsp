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

    <title>Title</title>
</head>
<body>
<div id="test"></div>
${user.username}
${user.password}


<table id="example" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Name</th>
        <th>Date Created</th>
        <th>Title</th>
        <th>Summary</th>
        <th>Expiry Date</th>
        <th>Priority</th>



    </tr>
    </thead>

</table>
</body>
<script>
    $(document).ready(function() {
        $("#example").DataTable({
            "ajax": {
                "url": "/todoList",
                "columns": [
                    { "data": "username" },
                    { "data": "createDate" },
                    { "data": "title" },
                    { "data": "summary" },
                    { "data": "expiredDate" },
                    { "data": "priority" },
                    { "data": "id"}
                ]
            }
        });
    });
</script>

</html>
