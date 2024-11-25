package com.java5.lab1_demo.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private static final int MAX_AGE_SECONDS = 60 * 60 * 24; // 24h in seconds
    @Autowired
    ServletContext application;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    @RequestMapping("/user")
    public String user() {

        return "user";
    }

    @RequestMapping("/result")
    public String result() {
        String msg = request.getParameter("message");
        request.setAttribute("message", msg);
        String ss = request.getParameter("session");
        session.setAttribute("session", ss);
        application.setAttribute("ss", ss);
        String country = request.getParameter("country");
        request.setAttribute("country", country);

        Cookie[] cookies = request.getCookies();
        String cookieValue = "";

        boolean found = false;
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("java5cookie")) {
                    cookieValue = cookie.getValue();
                    request.setAttribute("cookey", cookieValue);
                    found = true;
                }

                System.out.println(cookie.getAttribute("cookey"));

                System.out.println(cookie.getValue());
                if (!found) {
                    Cookie c = createCookie("java5cookie", "Java5 Cookie");
                    response.addCookie(c);
                }
                request.setAttribute("java5cookie", cookieValue);
            }
        }

        return "result";
    }

    private Cookie createCookie(String name, String value) {
        try {
            value = java.net.URLEncoder.encode(value, "utf-8");
        } catch (Exception e) {

        }
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(MAX_AGE_SECONDS);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        return cookie;
    }
}
