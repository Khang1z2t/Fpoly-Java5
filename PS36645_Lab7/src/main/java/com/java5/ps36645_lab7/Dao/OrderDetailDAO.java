package com.java5.ps36645_lab7.Dao;


import com.java5.ps36645_lab7.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {


//    @Query("SELECT new ProductSale(od.product.id,SUM(od.quantity), SUM(od.quantity * od.price)) " +
//            "FROM OrderDetail od WHERE od.product.id = ?1")
//    ProductSale findProductSalesByProductId(int productId);


//    @Query("SELECT od FROM OrderDetail od WHERE od.price * od.quantity = (SELECT MAX(od.price * od.quantity) FROM OrderDetail od)")
//    List<OrderDetail> findByMaxPrice();
}