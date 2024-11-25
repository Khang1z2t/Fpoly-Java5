<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<div class="container mt-3">
    <div class="card">
        <div class="row">
            <div class="col-md-8 cart pb-5">
                <div class="title p-2">
                    <div class="d-flex">
                        <div class="flex-grow-1">
                            <h4>
                                <b>Shopping Cart</b>
                            </h4>
                        </div>
                        <div class="text-muted">Số lượng: ${count} items</div>
                    </div>
                </div>
                <div class="mx-3">
                    <c:forEach var="products" items="${cart.items}">
                        <div class="card mb-3" style="max-height: 200px">
                            <div class="row g-0">
                                <div class="col-md-3">
                                    <img src="../images/${products.image}" class="img-fluid rounded-start p-1"
                                         style="max-height: 200px" alt="...">
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title">${products.name}</h5>
                                        <p class="card-text"><a href="/cart/update/${products.id}/minus"
                                                                class="text-decoration-none">-</a>
                                            <input class="form-control d-inline p-2" name="quantity" type="number"
                                                   value="${products.quantity}" onchange="this.form.submit" style="max-width: 50px"/>
                                            <a href="/cart/update/${products.id}/plus"
                                               class="text-decoration-none">+</a></p>
                                        <p class="card-text">Tổng: <fmt:formatNumber
                                                value="${products.price * products.quantity}" type="number"
                                                groupingUsed="true"/> đ </p>
                                        <p class="card-text"><small class="text-body-secondary"><a
                                                class="text-decoration-none text-muted"
                                                href="/cart/remove/${products.id}">Remove</a></small></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="position-absolute bottom-0 py-2">
                    <a href="/product/index" class="text-decoration-none text-muted px-3">
                        <i class="fa-solid fa-backward"></i> Back to shop</a>
                    <a href="/cart/clear" class="text-decoration-none text-muted"> Clear Cart </a>
                </div>
            </div>
            <div class="col-md-4 summary p-2">
                <div>
                    <h5>
                        <b>Summary</b>
                    </h5>
                </div>
                <div class="row">
                    <div class="col" style="padding-left: 14px;"> ITEMS: ${count}</div>
                    <div class="col text-right"><fmt:formatNumber value="${amount}" type="number"
                                                                  groupingUsed="true"/> đ
                    </div>
                </div>

                <label for="ship">SHIPPING</label>
                <select class="form-select w-auto mb-2" id="ship" onchange="location.href='?shipping=' + this.value">
                    <option class="text-muted" value="15000" <c:if test="${param.shipping == '15000'}">selected</c:if>>
                        Normal - 15,000 đ
                    </option>
                    <option class="text-muted" value="30000" <c:if test="${param.shipping == '30000'}">selected</c:if>>
                        Fast - 30,000 đ
                    </option>
                </select>
                <label for="code">GIVE CODE</label>
                <input id="code" class="form-control w-auto mb-2" placeholder="Enter your code">

                <c:set var="shippingCost" value="${param.shipping != null ? param.shipping : 15000}"/>
                <c:set var="totalAmount" value="${count == 0 ? 0 : amount + shippingCost}"/>


                <div class="row"
                     style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
                    <div class="col">TOTAL PRICE</div>
                    <div class="col text-right"><fmt:formatNumber value="${totalAmount}" type="number"
                                                                  groupingUsed="true"/> đ
                    </div>
                </div>
                <button class="btn btn-success">CHECKOUT</button>
            </div>
        </div>
    </div>
    <div class="position-absolute bottom-0 end-0 m-2">
        <a href="/home" class="btn btn-warning ">Home</a>
    </div>
</div>
</body>
</html>