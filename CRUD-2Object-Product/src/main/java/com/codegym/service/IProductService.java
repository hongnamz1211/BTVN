package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllProductByCategory(Category category);

    Page<Product> findProductByNameContaining(String name, Pageable pageable);
}
