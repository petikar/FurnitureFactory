package com.example.furnitureFactory.repository.product;

import com.example.furnitureFactory.model.enumClasses.Color;
import com.example.furnitureFactory.model.enumClasses.ProductType;
import com.example.furnitureFactory.model.product.Product;

import java.util.List;

public interface ProductRepo<T extends Product> {

    default T findByProduct(T product) {
        ProductType type = product.getProductType();
        Color color = product.getColor();

        return findByProductTypeAndColor(type, color);
    }

    T findByProductTypeAndColor(ProductType type, Color color);

    List<T> findAllByColor(Color color);
}
