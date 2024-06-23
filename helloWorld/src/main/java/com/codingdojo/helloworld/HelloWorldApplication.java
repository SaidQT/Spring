package com.codingdojo.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 2. Importing dependencies

@SpringBootApplication
// 1. Annotation

public class HelloWorldApplication {
        public static void main(String[] args) {
                SpringApplication.run(HelloWorldApplication.class, args);
        }
       
}

