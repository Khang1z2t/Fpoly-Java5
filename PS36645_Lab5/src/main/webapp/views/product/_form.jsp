<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/product/index" cssClass="form-control" modelAttribute="product">
    <h2>Product</h2>

    <%--    <label for="id">Id</label>--%>
    <%--    <form:input path="id" cssClass="form-control" placeholder="Category Id?"/>--%>
    <label for="name">Name</label>
    <form:input path="name" cssClass="form-control" placeholder="Product Name?"/>
    <label for="name">Price</label>
    <form:input path="price" cssClass="form-control" placeholder="Product Price?"/>
    <label for="name">Category</label>
    <form:select path="category.id" cssClass="form-select" placeholder="Product Name?"
                 items="${categories}" itemValue="id" itemLabel="name"/>
    <hr>


    <button class="btn btn-primary" formaction="/product/create">Create</button>
    <button class="btn btn-success" formaction="/product/update">Update</button>
    <a class="btn btn-danger" href="/product/delete/${product.id}">Delete</a>
    <a class="btn btn-warning" href="/product/index">Reset</a>
</form:form>