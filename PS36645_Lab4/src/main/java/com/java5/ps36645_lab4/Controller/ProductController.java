package com.java5.ps36645_lab4.Controller;

import com.java5.ps36645_lab4.Dao.ProductList;
import com.java5.ps36645_lab4.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ShoppingCartService cart;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("products", ProductList.list.values());
        model.addAttribute("count", cart.getCount());
        return "product";
    }
}
