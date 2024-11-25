package com.java5.ps36645_lab2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OkController {
    @RequestMapping("/ok")
    public String ok() {
        return "ok";
    }

    @PostMapping("/ctrl/ok")
    public String m1(Model model) {
        model.addAttribute("message", "m1() Method");
        return "ok";
    }

    @GetMapping("/ctrl/ok")
    public String m2(Model model) {
        model.addAttribute("message", "m2() Method");
        return "ok";
    }
    @PostMapping("/ctrl/ok/{x}")
    public String m3(Model model, @PathVariable("x") String x) {
        model.addAttribute("message", "m3() Method");
        return "ok";
    }
    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:/ctrl/ok";
    }
    @GetMapping("/forward")
    public String foward() {
        return "forward:/ok";
    }
}
