<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <link href="<c:url value="/resources/css/jquery/jquery-ui.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap/bootstrap-theme.min.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">

    <script src="<c:url value="/resources/js/jquery/jquery-1.12.4.js"/>"
            type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/jquery/jquery-ui-1.12.1.js" />"
            type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/jquery/jquery.min.js" />" type="text/javascript">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.validate.min.js"/>">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap/bootstrap.min.js"/>">
    </script>

    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $.get("/rest-server/task-id", function (data) {
                if (!empty(data)) {
                    $("#tasks-select option[value='" + data + "']").prop('selected', true);

                }
            });

            $('#tasks-select').change(function() {
                var taskId = $("#tasks-select option:selected").val();
                if (taskId == 0)
                    window.location.href = "/rest-server/task0";
                else if (taskId == 1)
                    window.location.href = "/rest-server/task1";
                else if (taskId == 2)
                    window.location.href = "/rest-server/task2";
                else if (taskId == 3)
                    window.location.href = "/rest-server/task3";
                else if (taskId == 4)
                    window.location.href = "/rest-server/task4";
                else if (taskId == 5)
                    window.location.href = "/rest-server/task5";
                else if (taskId == 6)
                    window.location.href = "/rest-server/task6";
            });
        });

        function empty(e) {
            switch (e) {
                case "":
                case null:
                case false:
                case typeof this == "undefined":
                    return true;
                default:
                    return false;
            }
        }
    </script>

<head>
<body>

<div class = "page-header">

    <h1 class="rest-server-title">REST Server</h1>

    <div class="tasks-block">
        <div class="tasks">
            <select id="tasks-select" class="form-control">
                <option>Select task</option>
                <option value="0">Task0</option>
                <option value="1">Task1</option>
                <option value="2">Task2</option>
                <option value="3">Task3</option>
                <option value="4">Task4</option>
                <option value="5">Task5</option>
                <option value="6">Task6</option>
            </select>
        </div>
    </div>

</div>

</body>
</html>
