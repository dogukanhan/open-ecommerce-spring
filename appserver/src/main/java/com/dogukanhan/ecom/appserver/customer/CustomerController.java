package com.dogukanhan.ecom.appserver.customer;


import com.dogukanhan.ecom.appserver.entity.Bucket;
import com.dogukanhan.ecom.appserver.entity.Category;
import com.dogukanhan.ecom.appserver.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/")
@Controller
public class CustomerController {

    private final CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryService.findAllByParentOrderByName(null);
    }



    @GetMapping()
    String index() {
        return "customer/index";
    }
}
