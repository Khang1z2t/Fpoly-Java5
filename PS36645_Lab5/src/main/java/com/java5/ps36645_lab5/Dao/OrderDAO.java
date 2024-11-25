package com.java5.ps36645_lab5.Dao;


import com.java5.ps36645_lab5.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderDAO extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.account a WHERE o.id = :orderId")
    Order findOrderWithAccountById(@Param("orderId") Long orderId);
}
