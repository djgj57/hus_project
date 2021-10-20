package io.userservice;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.userservice.entity.Role;
import io.userservice.entity.User;
import io.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {

            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John", "Travolta", "john@gmail.com", "1234",
                    new ArrayList<>()));
            userService.saveUser(new User(null, "Will", "Smith", "will@gmail.com", "1234",
                    new ArrayList<>()));
            userService.saveUser(new User(null, "Jim", "Carry", "jim@gmail.com", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Arnold", "Schwarzenegger", "arnold@gmail.com",
                    "1234",
                    new ArrayList<>()));

            userService.addRoleToUser("john@gmail.com", "ROLE_USER");
            userService.addRoleToUser("john@gmail.com", "ROLE_MANAGER");
            userService.addRoleToUser("will@gmail.com", "ROLE_MANAGER");
            userService.addRoleToUser("jim@gmail.com", "ROLE_ADMIN");
            userService.addRoleToUser("arnold@gmail.com", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("arnold@gmail.com", "ROLE_ADMIN");
            userService.addRoleToUser("arnold@gmail.com", "ROLE_USER");

        };

    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components().addSecuritySchemes("bearer-key",
                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }


}
