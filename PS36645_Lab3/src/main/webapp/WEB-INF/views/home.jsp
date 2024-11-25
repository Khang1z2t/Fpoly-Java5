<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/home">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/student">Bài 1 + 2: Student</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/upload">Bài 3: Upload File</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/student">Bài 4: Valid Form</a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="/result">Bài 5: Result Controller</a>--%>
<%--                </li>--%>
            </ul>
        </div>
    </div>
</nav>
<div class="m-3">
    <h2>${message}</h2>
</div>
</body>
</html>