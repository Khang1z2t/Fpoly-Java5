package com.java5.ps36645_lab4.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Product {
    int id;
    String name;
    String description;
    int price;
    int quantity;
    String image;
    String category;
    String brand;
    int status;
}
