package com.java5.ps36645_lab3.Controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class UploadController {
    @Autowired
    ServletContext app;

    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }

    @RequestMapping("/upload/save")
    public String send(@RequestParam("file") MultipartFile attach, RedirectAttributes redirectAttributes)
            throws IllegalStateException, IOException {
        if (!attach.isEmpty()) {
            String fileName = attach.getOriginalFilename();
            String uploadDir = app.getRealPath("/docs/");
            Path uploadPath = Paths.get(uploadDir);
            try {
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(attach.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            System.out.println("The file is empty!");
        redirectAttributes.addFlashAttribute("message", "Upload thành công!");
        redirectAttributes.addFlashAttribute("fileName", attach.getOriginalFilename());
        redirectAttributes.addFlashAttribute("file", attach);
        return "redirect:/upload";
    }
}
