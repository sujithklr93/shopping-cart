package com.shoppingcart.server.service;

import com.shoppingcart.server.entity.ProductEntity;
import com.shoppingcart.server.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getAllProduct();

    Optional<ProductEntity> getProductById(Long id);
}
