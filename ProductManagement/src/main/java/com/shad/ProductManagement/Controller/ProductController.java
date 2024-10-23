package com.shad.ProductManagement.Controller;

import com.shad.ProductManagement.Model.Product;
import com.shad.ProductManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    // create a new product
    @PostMapping(value = "POST/products")
    public Product createNewProduct(@RequestBody Product product){
        return productService.createNewProduct(product);
    }

    // retrieve all products
    @GetMapping(value = "GET/products")
    public List<Product> retrieveAllProducts(){
        return productService.retrieveAllProducts();
    }

    // retrieve a single product by id
    @GetMapping(value = "GET/products/{id}")
    public Product retrieveProductById(@PathVariable(value = "id") Long id){
        return productService.retrieveProductById(id);
    }
}
