package com.java5.ps36645_lab2.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    String name;
    Double price;
    String country;
    String image;
    public  enum countries {
        Vietnam,
        USA,
        Japan,
        Korea,
        China
    }
}