package com.shad.ProductManagement.ServiceRepository;

import com.shad.ProductManagement.Model.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductServiceRepo extends JpaRepository<Product, Id> {
}
