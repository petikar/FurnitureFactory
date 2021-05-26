package com.example.furnitureFactory.model.product;

import com.example.furnitureFactory.model.enumClasses.Color;
import com.example.furnitureFactory.model.enumClasses.ProductType;
import com.example.furnitureFactory.model.material.*;

import java.util.ArrayList;
import java.util.List;

public class ProductSchema {

    public static List<SheetMaterial> setProductSchema(ProductType type, Color color, int productCount) {
        List<SheetMaterial> productSchema = new ArrayList<>();
        switch (type) {
            case DESK:
                productSchema.add(new Mdf(color, productCount));
                productSchema.add(new Wood(color, 4 * productCount));
                return productSchema;
            case CHAIR:
                productSchema.add(new Chipboard(color, productCount));
                productSchema.add(new Wood(color, 4 * productCount));
                return productSchema;
            case CUPBOARD:
                productSchema.add(new Chipboard(color, 6 * productCount));
                productSchema.add(new Wood(color, 2 * productCount));
                productSchema.add(new Glass(color, 2 * productCount));
                productSchema.add(new Mdf(color, productCount));
                return productSchema;
            default:
                return null;
        }
    }
}
