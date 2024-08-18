package com.shoppingcart.server.controller;

import com.shoppingcart.server.entity.ProductEntity;
import com.shoppingcart.server.model.Product;
import com.shoppingcart.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/product/{id}")
    public Optional<ProductEntity> getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
}
