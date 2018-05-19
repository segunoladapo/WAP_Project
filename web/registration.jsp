<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: loknath
  Date: 5/18/2018
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="<c:url value="resources/css/lab12.css" />" rel="stylesheet">
</head>
<body>
<div id="container">
    <h1>Registration</h1>
    <form method="post" action="/createuser">
    <div id="loginBox">
        <div class="formElement">
            <c:out value="${msg}"/><br>
            <div id="errormessage"></div>
            <label for="userName">User Name</label>
            <div class="input">
                <input type="text" name="username" id="userName" required/>
            </div>
        </div>

        <div class="formElement">
            <label for="passWord">Password</label>
            <div class="input">
                <input type="password" name="password" id="passWord" required />
            </div>
        </div>

        <div class="formElement">
            <label for="repassWord">Re-type Password</label>
            <div class="input">
                <input type="password" name="repassWord" id="repassWord" required/>
            </div>
        </div>

        <div id="submitionBlock">
            <button id="submitbtn">Sign up</button>
        </div>
    </div>
    </form>
</div>
</body>
<script src="<c:url value="resources/js/jquery-3.3.1.min.js" />" type="text/javascript"></script>
<script src="<c:url value="resources/js/registration.js" />" type="text/javascript"></script>
</html>
