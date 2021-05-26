package com.example.furnitureFactory.repository.product;

import com.example.furnitureFactory.model.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ProductBaseRepository<Product> {
}
