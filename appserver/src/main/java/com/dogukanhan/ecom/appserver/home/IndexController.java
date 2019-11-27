package com.dogukanhan.ecom.appserver.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/home")
    @ResponseBody
    public String homePage(){
        return "This is a web project";
    }

}

