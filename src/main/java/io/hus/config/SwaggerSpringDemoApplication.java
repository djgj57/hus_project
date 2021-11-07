package io.hus.config;

import com.auth0.jwt.JWT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Category", version = "2.0", description = "Category " +
        "service"))
@SecurityScheme(name = "javainuseapi", scheme = "bearer", type = SecuritySchemeType.HTTP, in =
        SecuritySchemeIn.HEADER, bearerFormat = "JWT")
public class SwaggerSpringDemoApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(SwaggerSpringDemoApplication.class, args);
//    }

}