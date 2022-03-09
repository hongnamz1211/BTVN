package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.ICategoryService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;

    @Value("${view}")
    private String view;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    @ModelAttribute("/categories")
    public Iterable<Category> categories() {
        return categoryService.allCategory();
    }

    @GetMapping
//    public ModelAndView showProducts(@PageableDefault(value = 5) Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("list");
//        Page<Product> products = productService.findAll(pageable);
//        if (products.isEmpty()) {
//            modelAndView.addObject("message", "No products !!!");
//        }
//        modelAndView.addObject("file", view);
//        modelAndView.addObject("products", products);
//        return modelAndView;
//    }
    public ModelAndView listProduct(@ModelAttribute("search") Optional<String> search, @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Product> products;
        if (search.isPresent()) {
            products = productService.findProductByNameContaining(search.get(), pageable);
        } else {
            products = productService.findAll(pageable);
        }
        if (products.isEmpty()) {
            modelAndView.addObject("message", "No product");
        }
        modelAndView.addObject("products", products);
        modelAndView.addObject("file", view);
        return modelAndView;
    }

    @ModelAttribute(name = "categories")
    public Iterable<Category> findAll() {
        return categoryService.allCategory();
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        Iterable<Category> categories = categoryService.allCategory();
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView detailProduct(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Optional<Product> product = productService.findById(id);
        modelAndView.addObject("product", product);
        modelAndView.addObject("file", view);
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView createProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("create");
        MultipartFile multipartFile = product.getFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(product.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImage(fileName);
        Product productCreate = productService.save(product);
        if (productCreate != null) {
            Iterable<Category> categories = categoryService.allCategory();
            modelAndView.addObject("categories", categories);
            modelAndView.addObject("message", "Create successfully");
        }
        return modelAndView;
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Optional<Product> product = productService.findById(id);
        Iterable<Category> categories = categoryService.allCategory();
        modelAndView.addObject("product", product);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("file", view);
        return modelAndView;
    }

    @PostMapping("/edit-product")
    public ModelAndView editProduct(@PathVariable long id, @ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("edit");
        product.setId(id);
        if (product.getFile().getSize() != 0) {
            MultipartFile multipartFile = product.getFile();
            String fileName = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(product.getFile().getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            product.setImage(fileName);
        } else {
            product.setImage(productService.findById(id).get().getImage());
        }
        Product productEdit = productService.save(product);
        if (productEdit != null) {
            Iterable<Category> categories = categoryService.allCategory();
            modelAndView.addObject("categories", categories);
            modelAndView.addObject("file", view);
            modelAndView.addObject("message", "Update Product Successfully !!!");
        }
        return modelAndView;
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        productService.remove(id);
        return modelAndView;
    }

    
}
