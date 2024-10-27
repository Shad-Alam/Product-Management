package com.shad.ProductManagement.Controller;

import com.shad.ProductManagement.Model.Product;
import com.shad.ProductManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    // create a new product
    @PostMapping(value = "POST/products")
    public Product createNewProduct(@RequestBody Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(0)) < 0 || product.getStockQuantity() < 0) {
            return null;
        }
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

    // update the product information by its id;
    @PutMapping(value = "PUT/products/{id}")
    public Product updateProductById(@PathVariable(value = "id") Long id, @RequestBody Product product){
        Product findProduct = productService.retrieveProductById(id);
        if (product.getPrice().compareTo(BigDecimal.valueOf(0)) < 0 || product.getStockQuantity() < 0) {
            return null;
        }
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
        Product findProduct = productService.retrieveProductById(id);

        if(product.getStockQuantity()<0){
            return null;
        }
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
        productService.deleteProductById(id);
    }

    // search by product category
    @GetMapping(value = "CATEGORY/products/{category}")
    public List<Product> searchByProductCategory(@PathVariable(value = "category") String category){
        return productService.searchByProductCategory(category);
    }
}
