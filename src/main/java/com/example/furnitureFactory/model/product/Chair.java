package com.example.furnitureFactory.model.product;

import com.example.furnitureFactory.model.enumClasses.Color;
import com.example.furnitureFactory.model.enumClasses.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Min;


@Entity
@DiscriminatorValue("chair")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Chair extends Product {

    public Chair(Color color, @Min(value = 0) int materialsCount) {
        super(color, materialsCount);
        setProductType(ProductType.CHAIR);
    }

    public Chair() {
        setProductType(ProductType.CHAIR);
    }
}