package com.berant.berta.controller;

import com.berant.berta.data.Category;
import com.berant.berta.data.dao.CategoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/*
@Controller
public class SampleController {

    private CategoryDao productCategoryDao;

    @Resource(name=ategoryDao")
    public void setProductCategoryDao(CategoryDao productCategoryDao) {
        this.productCategoryDao = productCategoryDao;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> listProductCategory() {
        return productCategoryDao.findAllRoot();
    }
}
*/