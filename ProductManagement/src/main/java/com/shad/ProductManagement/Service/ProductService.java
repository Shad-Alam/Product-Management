package com.shad.ProductManagement.Service;

import com.shad.ProductManagement.Model.Product;
import com.shad.ProductManagement.ServiceRepository.ProductServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductServiceRepo productServiceRepo;
    public List<Product> retrieveAllProducts() {
        return productServiceRepo.findAll();
    }

    public Product createNewProduct(Product product) {
        return productServiceRepo.save(product);
    }

    public Product retrieveProductById(Long id) {
        return productServiceRepo.findById(id).get();
    }
}
