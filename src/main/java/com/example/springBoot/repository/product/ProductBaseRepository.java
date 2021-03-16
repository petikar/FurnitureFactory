package com.example.springBoot.repository.product;

import com.example.springBoot.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProductBaseRepository<T extends Product> extends JpaRepository <T, Integer>, ProductRepo<T> {

}
