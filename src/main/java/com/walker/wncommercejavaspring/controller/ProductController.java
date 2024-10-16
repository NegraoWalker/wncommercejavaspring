package com.walker.wncommercejavaspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products") //Rota /products
public class ProductController {




    @GetMapping
    public String test() {
        return "Hello World!";
    }
}
