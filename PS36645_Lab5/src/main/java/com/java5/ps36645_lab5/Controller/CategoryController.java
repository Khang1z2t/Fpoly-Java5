package com.java5.ps36645_lab5.Controller;

import com.java5.ps36645_lab5.Dao.CategoryDAO;
import com.java5.ps36645_lab5.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryDAO cDao;

    private int FIRST_PAGE_NUMBER = 0;
    private int NUMBER_OF_ITEM_PER_PAGE = 5;


    @RequestMapping("/index")
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("field") Optional<String> field) {
        List<Category> categories = cDao.findAll();
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("categories", categories);

        int currentPage = page.orElse(FIRST_PAGE_NUMBER);
        String sortField = field.orElse("id");
        if (sortField.isEmpty()) {
            sortField = "id";
        }
        Sort sort = Sort.by(Sort.Direction.ASC, sortField);
        Pageable pageable;

        if (currentPage < FIRST_PAGE_NUMBER) {
            pageable = PageRequest.of(cDao.findAll(PageRequest.of(0, NUMBER_OF_ITEM_PER_PAGE)).getTotalPages() - 1, NUMBER_OF_ITEM_PER_PAGE, sort);
        } else if (currentPage >= cDao.findAll(PageRequest.of(0, NUMBER_OF_ITEM_PER_PAGE)).getTotalPages()) {
            pageable = PageRequest.of(FIRST_PAGE_NUMBER, NUMBER_OF_ITEM_PER_PAGE, sort);
        } else {
            pageable = PageRequest.of(currentPage, NUMBER_OF_ITEM_PER_PAGE, sort);
        }
        Page<Category> pages = cDao.findAll(pageable);


        model.addAttribute("page", pages);

        return "category/index";
    }

    @RequestMapping("/create")
    public String create(Category category) {
        cDao.save(category);
        return "redirect:/category/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        Category category = cDao.findById(id).get();
        model.addAttribute("category", category);
        List<Category> categories = cDao.findAll();
        model.addAttribute("categories", categories);
        return "category/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        cDao.deleteById(id);
        return "redirect:/category/index";
    }

    @RequestMapping("/update")
    public String update(Category category) {
        cDao.save(category);
        return "redirect:/category/index";
    }

//    @RequestMapping("/sort")
//    public String sort(Model model) {
//
//        model.addAttribute("pages", categories);
//        return "redirect:/category/index";
//    }

}
