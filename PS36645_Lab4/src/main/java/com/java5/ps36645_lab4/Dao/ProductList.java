package com.java5.ps36645_lab4.Dao;

import com.java5.ps36645_lab4.Model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductList {
    public static Map<Integer, Product> list = new HashMap<>();

    static {
        list.put(1, new Product(1, "Iphone 19", "Iphone 19 là sự bù đắp cho việc không phát hành Iphone 9", 12000000, 0, "1.png", "Phone", "Apple", 1));
        list.put(2, new Product(2, "Samsung S29", "Samsung Galaxy S29 lấy ý tưởng từ 2029 hoặc 2019", 12000000, 0, "2.png", "Phone", "Samsung", 1));
        list.put(3, new Product(3, "Apple TV 2025", "Smart TV của Apple nên là chắc sẽ xịn", 33000000, 0, "3.png", "TV", "Samsung", 1));
        list.put(4, new Product(4, "Laptop Acer Nitro 5", "Laptop Acer 3N1 chính sách siêu okela", 42000000, 0, "4.png", "Laptop", "Dell", 1));
    }
}
