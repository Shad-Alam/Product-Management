package com.shad.ProductManagement.Service;

import com.shad.ProductManagement.Model.Product;
import com.shad.ProductManagement.ServiceRepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    public Product createNewProduct(Product product) {
        return productRepository.save(product);
    }

    public Product retrieveProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProductById(Product findProduct) {
        return productRepository.save(findProduct);
    }
}
