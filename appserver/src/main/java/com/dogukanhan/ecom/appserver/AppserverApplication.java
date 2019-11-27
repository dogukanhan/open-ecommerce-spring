package com.dogukanhan.ecom.appserver;

import com.dogukanhan.ecom.appserver.exception.ResourceNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class AppserverApplication {


    public static void main(String[] args) {
        SpringApplication.run(AppserverApplication.class, args);
    }

}
