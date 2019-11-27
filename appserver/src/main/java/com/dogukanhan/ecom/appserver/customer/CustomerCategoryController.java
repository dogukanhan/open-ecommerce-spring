package com.dogukanhan.ecom.appserver.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/category/")
@Controller
public class CustomerCategoryController {

    @GetMapping("{id}")
    public String index(@PathVariable("id") Long id) {
        return "customer/category";
    }

}
