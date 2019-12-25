package com.dogukanhan.ecom.appserver.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@RequestMapping("/admin/logs")
@Controller
public class LogsController {

    private static final String LOGS_ABSOLUTE_PATH = "/mnt/sda5/Projects/Self/E-Commerce/appserver/spring-boot-app.log";

    @GetMapping
    public String logs(Model model) throws IOException {
        model.addAttribute("logs", Files.lines(Path.of(LOGS_ABSOLUTE_PATH)).collect(Collectors.toList()));
        return "/admin/logs";
    }
}
