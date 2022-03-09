package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id);
        }
        return null;
    }

    @Override
    public Product save(Product product) {
       return productRepository.save(product);
    }

    @Override
    public void remove(long id) {
        productRepository.deleteById(id);
    }


    @Override
    public Iterable<Product> findAllProductByCategory(Category category) {
        return productRepository.findProductsByCategory(category);
    }

    @Override
    public Page<Product> findProductByNameContaining(String name, Pageable pageable) {
        return productRepository.findProductByNameContaining(name, pageable);
    }


}
