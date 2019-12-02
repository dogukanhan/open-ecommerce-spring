package com.dogukanhan.ecom.appserver.customer.auth;

import com.dogukanhan.ecom.appserver.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customer/register/")
@Controller
@RequiredArgsConstructor
public class CustomerRegisterController {

    private final CustomerService customerService;

    @PostMapping("/customer/register/")
    public String register(CustomerCreateDto dto){
        customerService.create(dto);
        return "redirect:/";
    }

}

