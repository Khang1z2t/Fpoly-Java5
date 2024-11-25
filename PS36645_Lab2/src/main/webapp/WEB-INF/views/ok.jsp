<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container p-5">
    <form class="form-control " action="/ctrl/ok" method="post">
        <button class="btn btn-primary">OK 1</button>
        <button class="btn btn-danger" formmethod="get">OK 2</button>
        <button class="btn btn-success" formaction="/ctrl/ok/x">OK 3</button>
        <button class="btn btn-warning position-absolute end-0 me-3" formaction="/home">Home</button>
    </form>
    <div class="m-3 ">
        <h2 class="bg-secondary">${message}</h2>
    </div>
</div>
</body>
</html>