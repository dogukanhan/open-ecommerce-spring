package com.dogukanhan.ecom.appserver.customer;

import com.dogukanhan.ecom.appserver.entity.Bucket;
import com.dogukanhan.ecom.appserver.repository.MProductRepository;
import com.dogukanhan.ecom.appserver.service.MProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/product/")
@Controller
@RequiredArgsConstructor
public class CustomerProductController extends AbstractCustomerController {

    private final MProductService mProductService;

    @GetMapping("{id}")
    String product(Model model,
                   @PathVariable("id") Long id) {

        var mProduct = mProductService.findOneById(id);
        model.addAttribute("mProduct", mProduct);

        return "customer/product";
    }

    @PostMapping("{id}/add-to-cart/")
    String addToCart(Model model,
                   @PathVariable("id") Long id,
                   @ModelAttribute("bucket") Bucket bucket) {

        var mProduct = mProductService.findOneById(id);
        model.addAttribute("mProduct", mProduct);

        return "customer/product";
    }
}

