package com.java5.ps36645_lab7.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSale {
    Product product;
    Long quantity;
    Double revenue;
}
