package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    Product findByName(String name);

    Product save(Product product);

    Product remove(int id);

    Page<Product> findAll(Pageable pageable);
}
