<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/category/index" cssClass="form-control" modelAttribute="category">
    <h2>Category</h2>

    <label for="id">Id</label>
    <form:input path="id" cssClass="form-control" placeholder="Category Id?"/>
    <label for="name">Name</label>
    <form:input path="name" cssClass="form-control" placeholder="Category Name?"/>
    <hr>

    <button class="btn btn-primary" formaction="/category/create">Create</button>
    <button class="btn btn-success" formaction="/category/update">Update</button>
    <a class="btn btn-danger" href="/category/delete/${category.id}">Delete</a>
    <a class="btn btn-warning" href="/category/index">Reset</a>
</form:form>