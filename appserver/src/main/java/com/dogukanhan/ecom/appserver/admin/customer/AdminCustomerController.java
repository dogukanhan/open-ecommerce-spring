package com.dogukanhan.ecom.appserver.admin.customer;

import com.dogukanhan.ecom.appserver.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/customer/")
@RequiredArgsConstructor
public class AdminCustomerController {

    private final CustomerService customerService;

    @GetMapping()
    String index(Model model) {

        var customers = customerService.findAll();

        model.addAttribute("customers", customers);

        return "admin/customer/index";
    }

}
