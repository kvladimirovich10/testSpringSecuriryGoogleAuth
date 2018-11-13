package com.programmer.gate;

import com.sun.security.auth.UserPrincipal;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/user")
    public Principal user(Principal principal) {
        System.out.println(principal.getClass().getName());
        if (principal instanceof OAuth2Authentication)
            System.out.println(((OAuth2Authentication) principal).getUserAuthentication().getDetails().toString());
        return principal;
    }
}