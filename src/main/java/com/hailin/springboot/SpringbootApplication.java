package com.hailin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
          //start
        SpringApplication.run(SpringbootApplication.class, args);

    }

}
