package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface Repository extends PagingAndSortingRepository<Product, Long> {
}
