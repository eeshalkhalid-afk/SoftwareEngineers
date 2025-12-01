package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    //rest controller tells spring that this class will handle http requests
    //and will return data directly in the response
    //this class is a web controller, methods inside return data not html pages
    //


	static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    //this is used to handle http get requests, like when someone opens a url
    //in their browser
    @GetMapping
    //this is a rest endpoint
    public String helloWorld() {
        return "Hello World Spring Boot!";
    }
}
