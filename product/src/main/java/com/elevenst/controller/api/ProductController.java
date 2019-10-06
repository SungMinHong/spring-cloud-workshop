package com.elevenst.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by smhong on 2019-10-06.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable String productId) {
        return "[product id = " + productId + " at " + System.currentTimeMillis() + "]";
    }
}

