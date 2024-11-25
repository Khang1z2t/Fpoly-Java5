<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<table class="table table-success table-striped">
    <thead>
    <tr>
        <th scope="col">
            <a class="text-decoration-none text-black" href="/category/index?field=stt">STT</a>
        </th>
        <th scope="col">
            <a class="text-decoration-none text-black" href="/category/index?field=id">id</a>
        </th>
        <th scope="col"><a class="text-decoration-none text-black" href="/category/index?field=name">Name</a>
        </th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${page.content}" varStatus="status">
        <tr>
            <th scope="row">${page.number * page.size + status.index + 1}</th>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>
                <a class="btn btn-warning" href="/category/edit/${category.id}">Edit</a>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link"
               href="/category/index?page=${page.number - 1}&field=${param.field}"
               aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var="i" begin="1" end="${page.totalPages}">
            <li class="page-item">
                <a class="page-link"
                   href="/category/index?page=${i - 1}&field=${param.field}">${i}</a>
            </li>
        </c:forEach>
        <li class="page-item">
            <a class="page-link"
               href="/category/index?page=${page.number + 1}&field=${param.field}"
               aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>