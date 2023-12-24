package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Category;
import com.model.Product;
import com.repository.ProductRepository;

public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct()
    {
        return productRepository.findAll();
    }
}
