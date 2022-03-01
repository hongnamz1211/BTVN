package com.codegym.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long c_id;
    private String c_name;

    @OneToMany(mappedBy = "category", targetEntity = Product.class)
    private List<Product> products;

    public Category() {
    }

    public Category(long c_id, String c_name, List<Product> products) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.products = products;
    }

    public long getC_id() {
        return c_id;
    }

    public void setC_id(long c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
