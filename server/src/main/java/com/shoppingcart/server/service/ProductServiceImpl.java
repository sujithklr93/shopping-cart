package com.shoppingcart.server.service;

import com.shoppingcart.server.entity.ProductEntity;
import com.shoppingcart.server.model.Product;
import com.shoppingcart.server.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        List<ProductEntity> productEntity = productRepository.findAll();
        List<Product> products= productEntity.stream().map(product-> new Product(
            product.getId(),
            product.getName(),
            product.getPrice()
        )).collect(Collectors.toList());
        return products;
    }
}
