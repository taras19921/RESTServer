<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <link href="<c:url value="/resources/css/jquery/jquery-ui.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap/bootstrap-theme.min.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/task0.css" />" rel="stylesheet">

    <script src="<c:url value="/resources/js/jquery/jquery.min.js" />" type="text/javascript">
    </script>

    <script src="<c:url value="/resources/js/jquery/jquery-ui.js" />" type="text/javascript">
    </script>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-1.10.2.js"/>">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.validate.min.js"/>">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap/bootstrap.min.js"/>">
    </script>

<head>
    <title></title>
</head>
<body>
<jsp:include page="/WEB-INF/pages/header.jsp"></jsp:include>

<h3>Task 0</h3>

<div class="tables">

    <div class="user-table">
        <h4>Users</h4>
        <c:if test="${not empty users}">
            <table id="users-table" class="table table-bordered">
                <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
<input type="number" id="task-id" class="hidden" value="${taskId}"/>
</body>
</html>
