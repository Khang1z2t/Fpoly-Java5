<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>report</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <table class="table table-hover table-success">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Total</th>
            <th scope="col">Quantity</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reports" items="${reports}">
            <tr>
                <th scope="row">${reports.groupName.id}</th>
                <td>${reports.groupName.name}</td>
                <td>${reports.sum}</td>
                <td>${reports.count}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="position-absolute bottom-0 end-0 m-2">
    <a href="/home" class="btn btn-warning ">Home</a>
</div>
</body>
</html>