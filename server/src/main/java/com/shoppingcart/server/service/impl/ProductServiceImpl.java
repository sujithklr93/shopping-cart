package com.shoppingcart.server.service.impl;

import com.shoppingcart.server.entity.ProductEntity;
import com.shoppingcart.server.model.Product;
import com.shoppingcart.server.repository.ProductRepository;
import com.shoppingcart.server.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        productRepository.save(productEntity);
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

    @Override
    public Optional<ProductEntity> getProductById(Long id){
       return productRepository.findById(id);
    }
}
