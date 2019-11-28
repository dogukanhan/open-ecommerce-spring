package com.dogukanhan.ecom.appserver.customer;

import com.dogukanhan.ecom.appserver.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/category/")
@Controller
@RequiredArgsConstructor
public class CustomerCategoryController {

    private final ProductService productService;

    @GetMapping(value = {"{id}/", "{id}/{page}/"})
    public String index(@PathVariable("id") Long id,
                        @PathVariable(value = "page", required = false) Integer page,
                        Model model) {

        if (page == null)
            page = 0;

        var products = productService.findAllByCategoryOrderById(id, page);
        model.addAttribute("products", products);

        return "customer/category";
    }

}
