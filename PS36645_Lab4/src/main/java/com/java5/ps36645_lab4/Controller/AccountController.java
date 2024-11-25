package com.java5.ps36645_lab4.Controller;

import com.java5.ps36645_lab4.Model.Account;
import com.java5.ps36645_lab4.Services.CookieService;
import com.java5.ps36645_lab4.Services.SessionService;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private ServletContext app;
    @Autowired
    SessionService sessionService;
    @Autowired
    CookieService cookieService;
    private List<Account> list = new ArrayList<>();

    @RequestMapping("/login")
    public String login() {
        Account account = sessionService.get("account");
        if (account != null) {
            return "redirect:/account/profile";
        } else {
            String username = cookieService.getValue("username");
            if (username != null) {
                account = list.stream().filter(a -> a.getUsername().equals(username)).findFirst().orElse(null);
                if (account != null) {
                    sessionService.set("account", account);
                    return "redirect:/account/profile";
                }
            }
        }
        return "account/login";
    }

    @RequestMapping("/login-in")
    public String loginIn(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam(value = "remember", defaultValue = "false") boolean remember,
                          Model model) {
        Account account = list.stream().filter(a -> a.getUsername().equals(username) && a.getPassword().equalsIgnoreCase(password)).findFirst().orElse(null);
        if (account == null) {
            model.addAttribute("message", "Invalid username or password");
            return "redirect:/account/login";
        }
        if (remember) {
            cookieService.add("username", username, 24);
        }
        sessionService.set("account", account);
        return "redirect:/account/profile";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {
        Account account = sessionService.get("account");
        if (account == null) {
            String username = cookieService.getValue("username");
            if (username != null) {
                account = list.stream().filter(a -> a.getUsername().equals(username)).findFirst().orElse(null);
                if (account != null) {
                    sessionService.set("account", account);
                }
            }
        }
        if (account == null) {
            return "account/login";
        }
        model.addAttribute("account", account);
        return "account/profile";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("account", new Account());
        return "account/register";
    }

    @RequestMapping("/save")
    public String save(Model model,
                       @Valid @ModelAttribute Account account,
                       BindingResult result,
                       @RequestParam("avatar") MultipartFile image) {
        if (result.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau đây và thử lại");
            return "account/register";
        }
        if (!image.isEmpty()) {
            String uploadDir = app.getRealPath("/WEB-INF/images/");
            Path uploadPath = Paths.get(uploadDir);
            try {
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                String fileName = image.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                account.setAvatar(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            account.setAvatar(null);
        }
        list.add(account);
        return "redirect:/account/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        sessionService.remove("account");
        cookieService.remove("username");
        return "redirect:/account/login";
    }

}
