package com.learn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final List<Product> products = new ArrayList<>();
    private Logger logger = Logger.getLogger(ProductController.class.getName());

    @PostMapping("/add")
    public String addProduct(@RequestParam("name") String name){
        logger.info("Added product "+ name);
        products.add(new Product(name));

        return "main.html";

    }
}
