package com.iggyzxc.spendwise;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Spend Wise REST API Documentation",
                description = "Welcome to the Spend Wise REST API Documentation. This API allows you to manage expenses and track your spending efficiently. You can perform operations such as creating, retrieving, updating, and deleting expenses, as well as managing expense categories.",
                version = "v1.0",
                contact = @Contact(
                    name = "Ignacio Macam Jr.",
                    email = "ignaciomacam@gmail.com",
                    url = "https://github.com/iggyzxc"
                ),
                license = @License(
                    name = "MIT License",
                    url = "https://opensource.org/licenses/MIT"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Additional documentation",
                url = "https://example.com/additional-documentation"
        )
)
@SpringBootApplication
public class SpendWiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpendWiseApplication.class, args);
    }

}
