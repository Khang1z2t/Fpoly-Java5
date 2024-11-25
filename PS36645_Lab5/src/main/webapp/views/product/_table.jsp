<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>


<table class="table table-success table-striped">
    <thead>
    <tr>
        <th scope="col">
            <a class="text-decoration-none text-black" href="/product/index?field=stt">STT</a>
        </th>
        <th scope="col">
            <a class="text-decoration-none text-black" href="/product/index?field=id">id</a>
        </th>
        <th scope="col">
            <a class="text-decoration-none text-black" href="/product/index?field=name">Name</a>
        </th>
        <th scope="col">
            <a class="text-decoration-none text-black" href="/product/index?field=price">Price</a>
        </th>
        <th scope="col">
            <a class="text-decoration-none text-black" href="/product/index?field=createDate">Create Date</a>
        </th>
        <th scope="col">
            <a class="text-decoration-none text-black">Category</a>
        </th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${page.content}" varStatus="status">
        <tr>
            <th scope="row">${page.number * page.size + status.index + 1}</th>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td><fmt:formatNumber value="${product.price}" pattern="#,##0"/> đ</td>
            <td><fmt:formatDate value="${product.createDate}" pattern="dd/MM/yyyy"/></td>
            <td>${product.category.name}</td>
            <td>
                <a class="btn btn-warning" href="/product/edit/${product.id}">Edit</a>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link"
               href="/product/index?page=${page.number - 1}&field=${param.field}"
               aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var="i" begin="1" end="${page.totalPages}">
            <li class="page-item">
                <a class="page-link"
                   href="/product/index?page=${i - 1}&field=${param.field}">${i}</a>
            </li>
        </c:forEach>
        <li class="page-item">
            <a class="page-link"
               href="/product/index?page=${page.number + 1}&field=${param.field}"
               aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>