package com.example.springBoot.service.product;

import com.example.springBoot.model.enumClasses.Color;
import com.example.springBoot.model.enumClasses.ProductType;
import com.example.springBoot.model.product.Product;

import java.util.List;

public interface ProductService <T extends Product> {

    void save(T newProduct);

    boolean create (ProductType type, Color color, int productCount);

    void update(T newProduct);

    List<T> findAll();

    T findById(int id);

    T findByProduct (T product);

    void deleteById(int id);
}
