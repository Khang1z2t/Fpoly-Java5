package com.java5.ps36645_lab2.Service;

import com.java5.ps36645_lab2.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProductService {
    List<Product> listProducts = new ArrayList<>();


    public void addProduct(Product product) {
        listProducts.add(product);
    }

    public List<Product> fillAll(){
        return listProducts;
    }

}
