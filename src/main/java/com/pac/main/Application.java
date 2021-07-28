package com.pac.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.pac")
public class Application {

    public static void main(String[] args) {
      SpringApplication.run(Application.class);
    }
}