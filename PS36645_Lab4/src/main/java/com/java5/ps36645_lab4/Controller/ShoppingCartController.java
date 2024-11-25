package com.java5.ps36645_lab4.Controller;

import com.java5.ps36645_lab4.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService cart;

    @RequestMapping("/view")
    public String view(Model model) {
        model.addAttribute("cart", cart);
        model.addAttribute("count", cart.getCount());
        model.addAttribute("amount", cart.getAmount());
        return "cart";
    }

    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cart.add(id);
        return "redirect:/product/index";
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "redirect:/cart/view";
    }

    @RequestMapping("/update/{id}/{pre}")
    public String update(@PathVariable("id") Integer id, @PathVariable("pre") String pre) {
        cart.update(id, pre);
        return "redirect:/cart/view";
    }

    @RequestMapping("/clear")
    public String clear() {
        cart.clear();
        return "redirect:/cart/view";
    }
}
