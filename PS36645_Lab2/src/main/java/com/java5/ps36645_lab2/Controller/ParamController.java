package com.java5.ps36645_lab2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
    @RequestMapping("/param")
    public String param() {
        return "param";
    }

    @RequestMapping("/param/save/{x}/{score}")
    public String save(@RequestParam("y") String y, @PathVariable("x") String x, @PathVariable("score") Double score, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("score", score);
        return "param";
    }

}
