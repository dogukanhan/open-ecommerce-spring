package com.dogukanhan.ecom.appserver.customer;

import com.dogukanhan.ecom.appserver.repository.MProductRepository;
import com.dogukanhan.ecom.appserver.service.MProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product/")
@Controller
@RequiredArgsConstructor
public class CustomerProductController {

    private final MProductService mProductService;

    @GetMapping("{id}")
    String product(Model model,
                   @PathVariable("id") Long id) {

        var mProduct = mProductService.findOneById(id);
        model.addAttribute("mProduct", mProduct);

        return "customer/product";
    }

}

