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
    public Product createNewProduct(@RequestBody Product product) {
        // if product name is already exits, error
        return productService.createNewProduct(product);
    }

    // retrieve all products
    @GetMapping(value = "GET/products")
    public List<Product> retrieveAllProducts(){
        // if
        return productService.retrieveAllProducts();
    }

    // retrieve a single product by id
    @GetMapping(value = "GET/products/{id}")
    public Product retrieveProductById(@PathVariable(value = "id") Long id){
        // if id not found, then give error
        return productService.retrieveProductById(id);
    }

    // update the product information by its id;
    @PutMapping(value = "PUT/products/{id}")
    public Product updateProductById(@PathVariable(value = "id") Long id, @RequestBody Product product){
        // if id not found, give error
        Product findProduct = productService.retrieveProductById(id);
        findProduct.setId(id);
        findProduct.setName(product.getName());
        findProduct.setDescription(product.getDescription());
        findProduct.setPrice(product.getPrice());
        findProduct.setStockQuantity(product.getStockQuantity());
        findProduct.setCategory(product.getCategory());
        findProduct.setCreatedAt(findProduct.getCreatedAt());
        findProduct.setUpdatedAt(product.getUpdatedAt());
        return productService.updateProductById(findProduct);
    }

    // update product stock quantity of by its id;
    @PatchMapping(value = "PATCH/products/{id}/update-stock")
    public Product updateProductStockQuantityById(@PathVariable(value = "id") Long id, @RequestBody Product product){

        // if id not found then, give error
        Product findProduct = productService.retrieveProductById(id);

        findProduct.setId(findProduct.getId());
        findProduct.setName(findProduct.getName());
        findProduct.setDescription(findProduct.getDescription());
        findProduct.setPrice(findProduct.getPrice());
        findProduct.setStockQuantity(product.getStockQuantity());
        findProduct.setCategory(findProduct.getCategory());
        findProduct.setCreatedAt(findProduct.getCreatedAt());
        findProduct.setUpdatedAt(product.getUpdatedAt());

        return productService.updateProductById(findProduct);
    }

    // delete a product by id
    @DeleteMapping(value = "DELETE/products/{id}")
    public void deleteProductById(@PathVariable(value = "id") Long id){
        // if id not found, then give error
        productService.deleteProductById(id);
    }
}
