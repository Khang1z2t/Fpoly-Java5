<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>

<div class="wrapper">
    <div class="container">
        <div class="d-flex my-2">
            <h2 class="flex-grow-1">Product</h2>
            <a href="/cart/view" class="text-decoration-none text-black mt-2"><i
                    class="fa-solid fa-cart-shopping fa-xl"></i>
                <span class="position-absolute translate-middle badge rounded-pill bg-danger">
                    ${count}
                </span>
            </a>
        </div>
        <div class="row g-1">
            <c:forEach var="product" items="${products}">
                <div class="col-md-3">
                    <div class="card" style="width: 18rem;">
                        <img src="../images/${product.image}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text"><fmt:formatNumber value="${product.price}" type="number"
                                                                   groupingUsed="true"/> đ </p>
                            <p class="card-text">Hãng: ${product.brand} - Loại: ${product.category}</p>
                            <p class="card-text">${product.description}</p>
                            <a href="/cart/add/${product.id}" class="btn btn-success w-100">Add to cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="position-absolute bottom-0 end-0 m-2">
        <a href="/home" class="btn btn-warning ">Home</a>
    </div>
</div>
<script>
    document.addEventListener("DOMContentLoaded", function (event) {
        const cartButtons = document.querySelectorAll('.cart-button');
        cartButtons.forEach(button => {
            button.addEventListener('click', cartClick);
        });

        function cartClick() {
            let button = this;
            button.classList.add('clicked');
        }
    });
</script>
</body>
</html>