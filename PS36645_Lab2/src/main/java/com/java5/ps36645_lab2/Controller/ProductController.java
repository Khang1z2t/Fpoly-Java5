package com.java5.ps36645_lab2.Controller;

import com.java5.ps36645_lab2.Model.Product;
import com.java5.ps36645_lab2.Service.ProductService;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private final ServletContext servletContext;

    public ProductController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @ModelAttribute("countries")
    public List<Product.countries> countries() {
        return Arrays.stream(Product.countries.values()).toList();
    }

    @RequestMapping("/product")
    public String product(Model model) {
//        model.addAttribute("product", new Product("123", 10.0, "USA", ""));
        model.addAttribute("product", new Product());
        model.addAttribute("products", fillAll());
        return "product";
    }

    @RequestMapping("/product/save")
    public String save(Model model,
                       @Valid @ModelAttribute("product") Product product,
                       BindingResult result,
                       @RequestParam("image") MultipartFile image) {
//        if (result.hasErrors()) {
//            model.addAttribute("products", fillAll());
//            System.out.println("Error");
//            return "product";
//        }
        if (!image.isEmpty()) {
            String fileName = image.getOriginalFilename();
            String uploadDir = servletContext.getRealPath("/images/");
            Path uploadPath = Paths.get(uploadDir);
            try {
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                product.setImage(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            product.setImage("");
        }
        addProduct(product);
        model.addAttribute("products", fillAll());
        return "redirect:/product";
    }

    @RequestMapping("/product/delete/{name}")
    public String delete(Model model, @PathVariable("name") String name) {
        listProducts.removeIf(product -> product.getName().equals(name));
        model.addAttribute("products", fillAll());
        return "redirect:/product";
    }

    List<Product> listProducts = new ArrayList<>();


    public void addProduct(Product product) {
        listProducts.add(product);
    }

    public List<Product> fillAll() {
        return listProducts;
    }
}
