package com.java5.lab1_demo.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bai2Controller {
    @Autowired
    ServletContext application;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    @RequestMapping("/bai2")
    public String bai2() {
        return "bai2";
    }

    @RequestMapping("/result2")
    public String result2() {
        String username = request.getParameter("username");
        session.setAttribute("username", username);
//        request.setAttribute("username", username);
        String pass = request.getParameter("pass");
//        request.setAttribute("pass", pass);
        session.setAttribute("pass", pass);
        return "result2";

    }
}
