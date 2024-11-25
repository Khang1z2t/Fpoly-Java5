package com.java5.ps36645_lab5.Controller;

import com.java5.ps36645_lab5.Dao.OrderDAO;
import com.java5.ps36645_lab5.Dao.OrderDetailDAO;
import com.java5.ps36645_lab5.Dao.ProductDAO;
import com.java5.ps36645_lab5.Entity.Order;
import com.java5.ps36645_lab5.Entity.OrderDetail;
import com.java5.ps36645_lab5.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    ProductDAO pDao;

    @Autowired
    OrderDAO oDao;

    @Autowired
    OrderDetailDAO odDao;

    @ResponseBody
    @RequestMapping("/p")
    public List<Product> index() {
        return pDao.findAll();
    }

    @ResponseBody
    @RequestMapping("/p/price")
    public List<Product> index(@RequestParam("min") double min, @RequestParam("max") double max) {
        return pDao.findByPriceBetween(min, max);
    }

    @ResponseBody
    @RequestMapping("/p/name")
    public List<Product> index(@RequestParam("name") String name) {
        return pDao.findAllByName(name);
    }

    @ResponseBody
    @RequestMapping("/p/pd")
    public List<Product> index(@RequestParam("id") int id) {
        return pDao.findAll();
    }

    @ResponseBody
    @RequestMapping("/p/maxprice")
    public List<OrderDetail> indexMaxPrice() {

        return odDao.findAll();
    }
}
