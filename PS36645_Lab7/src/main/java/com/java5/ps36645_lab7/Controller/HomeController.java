package com.java5.ps36645_lab7.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Lab7 - PS36645 - Bảo Khang (28)");
        return "home";
    }
}