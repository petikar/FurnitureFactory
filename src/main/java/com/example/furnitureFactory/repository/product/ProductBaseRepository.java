package com.example.furnitureFactory.repository.product;

import com.example.furnitureFactory.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProductBaseRepository<T extends Product> extends JpaRepository <T, Integer>, ProductRepo<T> {

}
