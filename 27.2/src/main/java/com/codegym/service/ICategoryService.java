package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> allCategory();

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(long id);

    Category save(Category t);

    void remove(long id);
}
