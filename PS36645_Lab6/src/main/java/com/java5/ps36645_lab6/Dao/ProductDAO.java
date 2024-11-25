package com.java5.ps36645_lab6.Dao;


import com.java5.ps36645_lab6.Entity.Product;
import com.java5.ps36645_lab6.Entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
//	List<Product> findByPrice(double minPrice, double maxPrice);
    Page<Product> findByPriceBetween(double minPrice, double maxPrice, Pageable pageable);

    @Query("SELECT o FROM Product o WHERE o.name like  %?1%")
    List<Product> findAllByName(String name);

    @Query("SELECT o FROM Product o WHERE o.name like  %?1%")
    Page<Product> findByKeywords(String name, Pageable pageable);

//@Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
//Page<Product> findByKeywords(String keywords, Pageable pageable);

    @Query("SELECT p.id, p.name, SUM(od.quantity) AS total_quantity, SUM(od.price * od.quantity) AS total_revenue\n" +
            "FROM Product p " +
            "JOIN OrderDetail od ON p.id = od.product.id " +
            "GROUP BY p.id, p.name " +
            "ORDER BY total_revenue DESC ")
    List<Object[]> findTotalAmountAndQuantityByProductType();


    @Query("SELECT new Report(o.category, sum(o.price), count(o)) "
            + " FROM Product o "
            + " GROUP BY o.category"
            + " ORDER BY sum(o.price) DESC")
    List<Report> getInventoryByCategory();
}
