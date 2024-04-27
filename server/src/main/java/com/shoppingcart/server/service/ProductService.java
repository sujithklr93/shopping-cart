package com.shoppingcart.server.service;

import com.shoppingcart.server.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getAllProduct();
}
