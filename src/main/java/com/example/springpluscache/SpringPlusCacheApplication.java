package com.example.springpluscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringPlusCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPlusCacheApplication.class, args);
    }

}
