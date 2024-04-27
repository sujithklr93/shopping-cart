package com.shoppingcart.server.controller;

import com.shoppingcart.server.model.Product;
import com.shoppingcart.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return  productService.saveProduct(product);
    }

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
}
