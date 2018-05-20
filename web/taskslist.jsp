<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: loknath
  Date: 5/19/2018
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task List</title>
    <link href="<c:url value="resources/css/taskslist.css" />" rel="stylesheet">
</head>
<body>
<div id="container">
    <a href="/logout"><button class ="mybutton" id="logoutbutton" >Logout</button></a>
    <div id="leftwrapper">

    </div>


    <div id="rightwrapper">
        <form method="post" action=" # ">
            <label id="labeltitle">Title </label>
            <input type="text" id="title" class="input" name=""> <br>

            <label id="labeldate">Expiry Date </label>
            <input type="text" id="date" class="input"> <br>

            <textarea id="text-area">Summary</textarea> <br>

            <label id="priority">Priority</label>
            <select id="select">
                <option>Low</option>
                <option>Medium</option>
                <option>High</option>
            </select></label>
            <br>
            <input type="submit" value="Submit" class="mybutton" id="submitbutton">
        </form>
    </div>
</div>
</body>
</html>
