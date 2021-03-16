package com.example.springBoot.repository.product;

import com.example.springBoot.model.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ProductBaseRepository<Product> {
}
