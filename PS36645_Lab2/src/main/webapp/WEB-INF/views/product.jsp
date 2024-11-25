<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container p-5">
    <h2>Product</h2>
    <form:form class="form-control" action="/product/save" modelAttribute="product" method="post"
               enctype="multipart/form-data">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <form:input path="name" type="text" class="form-control" id="name" name="name"/>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <form:input path="price" type="number" class="form-control" id="price" name="price"/>
        </div>
        <div class="mb-3">
            <label for="country" class="form-label">Country</label>
            <form:select path="country" type="text" class="form-control" id="country" name="country"
                         items="${countries}"/>
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">Image</label>
            <input path="image" type="file" class="form-control" id="image" name="image" accept="image/*"/>
        </div>
        <button class="btn btn-primary">Save</button>
    </form:form>
    <div>
        <h1 class="mb-3">Danh sách sản phẩm</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <%--            <th>ID</th>--%>
                <th>Tên Sản Phẩm</th>
                <th>Giá</th>
                <th>Quốc gia</th>
                <th>Hình</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                        <%--                <td>${product.id}</td>--%>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.country}</td>
                    <td><img class="img-fluid" width="50" src="../images/${product.image}" title="${product.image}"></td>
                    <td><a class="btn btn-danger" href="/product/delete/${product.name}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a class="btn btn-warning position-absolute end-0 me-3 mt-3" href="/home">Home</a>
</div>
</body>
</html>