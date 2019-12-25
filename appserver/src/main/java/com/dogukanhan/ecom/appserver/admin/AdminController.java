package com.dogukanhan.ecom.appserver.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
class AdminController {

    @RequestMapping("/login.html")
    public String login() {
        return "admin/login";
    }


    @RequestMapping("/logout")
    public String lagout(HttpServletRequest request)       {
        request.getSession().invalidate();
        return "redirect:/";
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @GetMapping()
    String index() {
        return "admin/index";
    }

}
