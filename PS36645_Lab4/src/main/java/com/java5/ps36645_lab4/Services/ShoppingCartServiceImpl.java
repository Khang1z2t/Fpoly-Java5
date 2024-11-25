package com.java5.ps36645_lab4.Services;

import com.java5.ps36645_lab4.Dao.ProductList;
import com.java5.ps36645_lab4.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, Product> map = new HashMap<>();

    @Override
    public Product add(Integer id) {
        Product product = map.get(id);
        if (product == null) {
            product = ProductList.list.get(id);
            product.setQuantity(1);
            map.put(id, product);
        } else {
            product.setQuantity(product.getQuantity() + 1);
        }
        return product;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Product update(Integer id, String qty) {
        Product product = map.get(id);
        if (qty.equals("minus") && product.getQuantity() > 0) {
            product.setQuantity(product.getQuantity() - 1);
            if (product.getQuantity() <= 0)
                this.remove(id);
        } else if (qty.equals("plus") && product.getQuantity() < 100) {
            product.setQuantity(product.getQuantity() + 1);
        }

        return product;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Product> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream().mapToInt(Product::getQuantity).sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();
    }
}
