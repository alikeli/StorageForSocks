package com.project.storageforsocks;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class StorageForSocksApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageForSocksApplication.class, args);
    }

}
