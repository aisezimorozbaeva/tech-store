package com.ais.techstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product_page")
public class ProductPageController {

    @GetMapping
    public String ProductPage(){
        return "product_page";
    }

}
