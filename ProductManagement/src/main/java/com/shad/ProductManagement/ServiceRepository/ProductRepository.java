package com.shad.ProductManagement.ServiceRepository;

import com.shad.ProductManagement.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("SELECT ssd_pro_name FROM SSD_Product p WHERE p.ssd_pro_name = :name")
//    boolean existsByName(@Param("name") String name);
}
