<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>param</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container p-5">
    <form class="form-control" action="/param/save/2024/9" method="post">
        <input class="form-control" name="y" value="">
        <button class="btn btn-primary">Save</button>
    </form>
    <ul class="list-group">
        <li class="list-group-item">${x}</li>
        <li class="list-group-item">${y}</li>
        <li class="list-group-item">${score}</li>
    </ul>
    <a class="btn btn-warning position-absolute end-0 me-3 mt-3" href="/home">Home</a>
</div>
</body>
</html>