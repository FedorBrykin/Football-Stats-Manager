package com.footballmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Говорит Spring, что этот класс обрабатывает HTTP-запросы
public class HelloController {

    @GetMapping("/hello") // Говорит, что метод отвечает на GET-запросы по адресу "/hello"
    public String sayHello() {
        return "Hello, Football World! My application is working!";
    }
}