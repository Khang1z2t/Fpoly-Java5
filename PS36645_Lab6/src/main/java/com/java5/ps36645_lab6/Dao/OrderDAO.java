package com.java5.ps36645_lab6.Dao;


import com.java5.ps36645_lab6.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.account a WHERE o.id = :orderId")
    Order findOrderWithAccountById(@Param("orderId") Long orderId);



    @Query("Select o.id, sum(od.price * od.quantity) as totalValue " +
            "from Order o " +
            "join OrderDetail od on o.id = od.order.id " +
            "group by o.id " +
            "order by totalValue desc " +
            "limit 1")
    Object findOrderWithHighestValue();

    @Query("Select o.id, sum(od.price * od.quantity) as totalValue " +
            "from Order o " +
            "join OrderDetail od on o.id = od.order.id " +
            "group by o.id " +
            "order by totalValue asc " +
            "limit 1")
    Object findOrderWithLowestValue();

}
