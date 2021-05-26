package com.example.furnitureFactory.service.product;

import com.example.furnitureFactory.model.enumClasses.Color;
import com.example.furnitureFactory.model.enumClasses.ProductType;
import com.example.furnitureFactory.model.product.Product;

import java.util.List;

public interface ProductService <T extends Product> {

    void save(T newProduct);

    void save(ProductType type, Color color, int productCount);

    boolean create (ProductType type, Color color, int productCount);

    void update(T newProduct);

    List<T> findAll();

    T findById(int id);

    T findByProduct (T product);

    void deleteById(int id);
}
