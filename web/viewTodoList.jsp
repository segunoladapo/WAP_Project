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
<head>
    <link href="<c:url value='resources/css/todotaskslist.css' />" rel="stylesheet">
    <title>View</title>

</head>
<body>
<div id="logoutbuttondiv">
    <a href="/logout"><button class ="mybutton" id="logoutbutton" >Logout</button></a>
</div>
<div id="container">
<div id="titlediv"><div id="titlelabel">Title</div>
    <input type="text" id="title" class="input" name="title" required>
</div>

<div id="expirydiv"><div id="datelabel">Expiry Date </div>
    <input type="text" id="expiredDate" class="input" name="expiredDate" required>
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
</div>
</body>
</html>
