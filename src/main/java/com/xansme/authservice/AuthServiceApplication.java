package com.xansme.authservice;

import com.xansme.authservice.domain.Role;
import com.xansme.authservice.domain.Users;
import com.xansme.authservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_CUSTOMER"));
            userService.saveRole(new Role(null, "ROLE_MERCHANT_OWNER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
            userService.saveUser(new Users(null, "ADMIN", "admin", "qwerty123", new ArrayList<>()));
            userService.addRoleToUser("admin", "ROLE_SUPER_ADMIN");
        };
    }
}
