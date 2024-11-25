<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>search</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form class="form-control" action="/product/search" method="post">
    <label for="min">Min Price</label>
    <input class="form-control" id="min" name="min" value="${param.min}" placeholder="Min Price?">
    <label for="max">Max Price</label>
    <input class="form-control" id="max" name="max" value="${param.max}" placeholder="Max Price?">

    <label for="name">Name</label>
    <input class="form-control" id="name" name="name" value="${param.name}" placeholder="Name?">

    <button class="btn btn-secondary">Search</button>
</form>
<table class="table table-striped">
    <tr>
        <th>
            <a class="text-decoration-none text-black"
               href="/product/search?field=id">ID</a>
        </th>
        <th>
            <a class="text-decoration-none text-black"
               href="/product/search?field=name">Name</a>
        </th>
        <th>
            <a class="text-decoration-none text-black"
               href="/product/search?field=price">Price</a>
        </th>
        <th>
            <a class="text-decoration-none text-black"
               href="/product/search?field=createDate">Create Day</a>
        </th>
    </tr>
    <c:forEach var="product" items="${pages.content}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td><fmt:formatNumber value="${product.price}" pattern="#,##0"/></td>
            <td><fmt:formatDate value="${product.createDate}" pattern="dd/MM/yyyy"/></td>
        </tr>
    </c:forEach>
</table>
<%--                        pegination--%>
<%--<nav aria-label="Page navigation example">--%>
<%--    <ul class="pagination">--%>
<%--        <li class="page-item">--%>
<%--            <a class="page-link"--%>
<%--               href="/product/search?page=${pages.number - 1}&field=${not empty param.field ? param.field : ''}&name=${not empty param.name ? param.name : ''}"--%>
<%--               aria-label="Previous">--%>
<%--                <span aria-hidden="true">&laquo;</span>--%>
<%--            </a>--%>
<%--        </li>--%>
<%--        <c:forEach var="i" begin="1" end="${pages.totalPages}">--%>
<%--            <li class="page-item">--%>
<%--                <a class="page-link"--%>
<%--                   href="/product/search?page=${i - 1}&field=${not empty param.field ? param.field : ''}&name=${not empty param.name ? param.name : ''}">${i}</a>--%>
<%--            </li>--%>
<%--        </c:forEach>--%>
<%--        <li class="page-item">--%>
<%--            <a class="page-link"--%>
<%--               href="/product/search?page=${pages.number + 1}&field=${not empty param.field ? param.field : ''}&name=${not empty param.name ? param.name : ''}"--%>
<%--               aria-label="Next">--%>
<%--                <span aria-hidden="true">&raquo;</span>--%>
<%--            </a>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</nav>--%>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link"
               href="/product/search?page=${pages.number - 1}"
               aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var="i" begin="1" end="${pages.totalPages}">
            <li class="page-item">
                <a class="page-link"
                   href="/product/search?page=${i - 1}">${i}</a>
            </li>
        </c:forEach>
        <li class="page-item">
            <a class="page-link"
               href="/product/search?page=${pages.number + 1}"
               aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
<div class="position-absolute bottom-0 end-0 m-2">
    <a href="/home" class="btn btn-warning ">Home</a>
</div>
</body>
</html>