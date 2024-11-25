package com.java5.ps36645_lab3.Controller;

import com.java5.ps36645_lab3.Model.Student;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {
    List<Student> list = new ArrayList<>();

    @Autowired
    private ServletContext app;


    @ModelAttribute("genders")
    public List<Student.genders> countries() {
        return Arrays.stream(Student.genders.values()).toList();
    }

    @ModelAttribute("faculties")
    public List<Student.faculties> faculties() {
        return Arrays.stream(Student.faculties.values()).toList();
    }

    @ModelAttribute("hobbies")
    public List<Student.hobbies> hobbies() {
        return Arrays.stream(Student.hobbies.values()).toList();
    }

    @RequestMapping("/student")
    public String student(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("students", fillAll());
        return "student";
    }

    @RequestMapping("student/save")
    public String save(Model model,
                       @Valid @ModelAttribute("student") Student student,
                       BindingResult result,
                       @RequestParam("image") MultipartFile image) throws Exception {
        if (result.hasErrors()) {
            model.addAttribute("message", "Vui lòng điền đầy đủ thông tin");
            model.addAttribute("students", fillAll());
            return "student";
        }

        if (!image.isEmpty()) {
            String uploadDir = app.getRealPath("/images/");
            Path uploadPath = Paths.get(uploadDir);
            try {
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                String fileName = image.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                student.setImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            result.rejectValue("image", "error.image", "Ảnh không được để trống");
        }
        addStudent(student);
        model.addAttribute("students", fillAll());
        return "redirect:/student";
    }

    @RequestMapping("/student/delete/{name}")
    public String delete(Model model, @PathVariable("name") String name) {
        list.removeIf(student -> student.getName().equals(name));
        model.addAttribute("students", fillAll());
        return "redirect:/student";
    }


    public void addStudent(Student student) {
        list.add(student);
    }

    public List<Student> fillAll() {
        return list;
    }
}
