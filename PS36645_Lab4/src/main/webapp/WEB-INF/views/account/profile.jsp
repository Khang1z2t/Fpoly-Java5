<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap');

        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;

        }

        body {
            background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(75, 14, 154, 1) 35%, rgba(0, 212, 255, 1) 100%);
            font-family: 'Poppins', sans-serif;

        }

        .form-form {
            border-radius: 20px;
            margin-top: 80px !important;
            width: 24% !important;
            background-color: white !important;
            padding: 50px;
            padding-top: 20px;
        }

        .btn-primary {
            width: 100%;
            border: none;
            border-radius: 50px;
            background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(75, 14, 154, 1) 35%, rgba(0, 212, 255, 1) 100%);

        }

        .form-control {
            color: rgba(0, 0, 0, .87);
            border-bottom-color: rgba(0, 0, 0, .42);
            box-shadow: none !important;
            border: none;
            border-bottom: 1px solid;
            border-radius: 4px 4px 0 0;
        }

        h4 {
            font-size: 2rem !important;
            font-weight: 700;
        }

        .form-label {
            font-weight: 800 !important;
        }

        @media only screen and (max-width: 600px) {
            .form-form {
                width: 100% !important;
            }
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <form:form action="save" class="mx-auto form-form" modelAttribute="account" method="post"
               enctype="multipart/form-data">
        <h4 class="text-center">Profile</h4>
        <c:if test="${not empty account.avatar}">
            <div class="text-center">
                <img alt="" src="../../images/${account.avatar.originalFilename}" class="mx-auto d-block rounded-circle" width="100"
                     height="100">
            </div>
        </c:if>
        <div class="mb-3 mt-3">
            <label for="exampleInputEmail1" class="form-label">User Name</label>
            <form:input path="username" type="text" class="form-control" id="exampleInputEmail1"
                        aria-describedby="emailHelp"/>
            <form:errors path="username" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <form:input path="password" type="password" class="form-control" id="exampleInputPassword1"/>
            <form:errors path="password" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <label for="Email" class="form-label">Email</label>
            <form:input path="email" type="email" class="form-control" id="Email"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">Image</label>
            <form:input path="avatar" name="image" type="file" id="image" class="form-control"/>
            <form:errors path="avatar" cssClass="text-danger"/>
        </div>
        <button type="submit" class="btn btn-primary mt-5">Change</button>
    </form:form>
    <div class="position-absolute bottom-0 end-0 m-2">
        <a href="logout" class="btn btn-danger m-2">Logout</a>
        <a href="/home" class="btn btn-warning ">Home</a>
    </div>

</div>
</body>
</html>