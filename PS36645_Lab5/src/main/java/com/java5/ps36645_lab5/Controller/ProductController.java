package com.java5.ps36645_lab5.Controller;

import com.java5.ps36645_lab5.Dao.CategoryDAO;
import com.java5.ps36645_lab5.Dao.ProductDAO;
import com.java5.ps36645_lab5.Entity.Category;
import com.java5.ps36645_lab5.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductDAO pDao;

    @Autowired
    CategoryDAO cDao;

    private int FIRST_PAGE_NUMBER = 0;
    private int NUMBER_OF_ITEM_PER_PAGE = 5;


    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return cDao.findAll();
    }

    @RequestMapping("/index")
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("field") Optional<String> field) {
        List<Product> products = pDao.findAll();
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("products", products);

        int currentPage = page.orElse(FIRST_PAGE_NUMBER);
        String sortField = field.orElse("id");
        if (sortField.isEmpty()) {
            sortField = "id";
        }
        Sort sort = Sort.by(Sort.Direction.ASC, sortField);
        Pageable pageable;

        if (currentPage < FIRST_PAGE_NUMBER) {
            pageable = PageRequest.of(pDao.findAll(PageRequest.of(0, NUMBER_OF_ITEM_PER_PAGE)).getTotalPages() - 1, NUMBER_OF_ITEM_PER_PAGE, sort);
        } else if (currentPage >= pDao.findAll(PageRequest.of(0, NUMBER_OF_ITEM_PER_PAGE)).getTotalPages()) {
            pageable = PageRequest.of(FIRST_PAGE_NUMBER, NUMBER_OF_ITEM_PER_PAGE, sort);
        } else {
            pageable = PageRequest.of(currentPage, NUMBER_OF_ITEM_PER_PAGE, sort);
        }
        Page<Product> pages = pDao.findAll(pageable);


        model.addAttribute("page", pages);
        return "product/index";
    }

    @RequestMapping("/create")
    public String create(Product product) {
        product.setAvailable(true);
        product.setCreateDate(new Date());
        pDao.save(product);
        return "redirect:/product/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model,
                       @PathVariable("id") Integer id) {
        Product product = pDao.findById(id).get();
        model.addAttribute("product", product);
        return "product/index";
    }

    @RequestMapping("/update")
    public String update(Product product) {
        product.setCreateDate(new Date());
        pDao.save(product);
        return "redirect:/product/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        pDao.deleteById(id);
        return "redirect:/product/index";
    }
}
