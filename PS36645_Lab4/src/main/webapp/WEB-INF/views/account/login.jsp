<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <%--    <link href="../../css/style.css" rel="stylesheet">--%>
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

        form {
            border-radius: 20px;
            margin-top: 150px !important;
            width: 24% !important;
            background-color: white !important;
            padding: 50px;
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
            form {
                width: 100% !important;
            }
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <form action="login-in" class="mx-auto">
        <h4 class="text-center">Login</h4>
        <div class="mb-3 mt-5">
            <label for="exampleInputEmail1" class="form-label">User Name</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="username"
                   aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" class="form-control" name="password" id="exampleInputPassword1">
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="rememberMe" name="remember" value="true"/>
                <label class="form-check-label" for="rememberMe">Remember me</label>
            </div>
            <a href="register" class="form-text text-decoration-none mt-3">New here?</a>
        </div>

        <button type="submit" class="btn btn-primary mt-5">Login</button>
    </form>
    <a href="/home" class="btn btn-warning position-absolute bottom-0 end-0 m-2">Home</a>
</div>
</body>
</html>