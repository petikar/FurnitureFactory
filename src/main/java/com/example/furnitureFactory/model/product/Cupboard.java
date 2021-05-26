package com.example.furnitureFactory.model.product;

import com.example.furnitureFactory.model.enumClasses.Color;
import com.example.furnitureFactory.model.enumClasses.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
@DiscriminatorValue("cupboard")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Cupboard extends Product {

    public Cupboard(Color color, @Min(value = 0) int materialsCount) {
        super(color, materialsCount);
        setProductType(ProductType.CUPBOARD);
    }

    public Cupboard() {
        setProductType(ProductType.CUPBOARD);
    }
}
