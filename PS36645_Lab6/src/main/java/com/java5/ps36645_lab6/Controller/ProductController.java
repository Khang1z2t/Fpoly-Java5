package com.java5.ps36645_lab6.Controller;

import com.java5.ps36645_lab6.Dao.OrderDAO;
import com.java5.ps36645_lab6.Dao.ProductDAO;
import com.java5.ps36645_lab6.Entity.Order;
import com.java5.ps36645_lab6.Entity.Product;
import com.java5.ps36645_lab6.Entity.Report;
import com.java5.ps36645_lab6.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductDAO pdao;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    SessionService sessionService;

    private int FIRST_PAGE_NUMBER = 0;
    private int NUMBER_OF_ITEM_PER_PAGE = 5;

    @RequestMapping("/search")
    public String search(@RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max,
                         @RequestParam("name") Optional<String> name,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("field") Optional<String> field,
                         Model model) {

        name.ifPresent(n -> sessionService.set("name", n));
        field.ifPresent(f -> sessionService.set("field", f));

        String nameParam = name.orElse(sessionService.get("name", ""));
//        if (nameParam == null) {
//            nameParam = "";
//        }

        String fieldParam = field.orElse(sessionService.get("field", "id"));


        int currentPage = page.orElse(FIRST_PAGE_NUMBER);
        if (fieldParam == null || fieldParam.isEmpty()) {
            fieldParam = "id";
        }

        Sort sort = Sort.by(Sort.Direction.ASC, fieldParam);
        Pageable pageable;
        if (currentPage < FIRST_PAGE_NUMBER) {
            pageable = PageRequest.of(pdao.findAll(PageRequest.of(0, NUMBER_OF_ITEM_PER_PAGE)).getTotalPages() - 1, NUMBER_OF_ITEM_PER_PAGE, sort);
        } else if (currentPage >= pdao.findAll(PageRequest.of(0, NUMBER_OF_ITEM_PER_PAGE)).getTotalPages()) {
            pageable = PageRequest.of(FIRST_PAGE_NUMBER, NUMBER_OF_ITEM_PER_PAGE, sort);
        } else {
            pageable = PageRequest.of(currentPage, NUMBER_OF_ITEM_PER_PAGE, sort);
        }
        Page<Product> items = pdao.findAll(pageable);
        if (min.isPresent() && max.isPresent()) {
            items = pdao.findByPriceBetween(min.get(), max.get(), pageable);
        }

        if (!nameParam.isEmpty()) {
            items = pdao.findByKeywords(nameParam, pageable);
        }
        model.addAttribute("pages", items);
        return "product/search";
    }

    //    @ResponseBody
    @RequestMapping("/report")
    public String productReport(Model model) {
        List<Report> reports = pdao.getInventoryByCategory();
        model.addAttribute("reports", reports);
        return "product/report";
    }

    @ResponseBody
    @RequestMapping("/reportByPrice")
    public List<Object[]> getTotalAmountByProductType() {
        return pdao.findTotalAmountAndQuantityByProductType();
    }

    @ResponseBody
    @RequestMapping("/reportHighestPrice")
    public Object getHighestPriceOrder() {
        return orderDAO.findOrderWithHighestValue();
    }

    @ResponseBody
    @RequestMapping("/reportLowestPrice")
    public Object getLowestPriceOrder() {
        return orderDAO.findOrderWithLowestValue();
    }
}
