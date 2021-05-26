package com.example.furnitureFactory.model.product;

import com.example.furnitureFactory.model.enumClasses.Color;
import com.example.furnitureFactory.model.enumClasses.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
@DiscriminatorValue("desk")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Desk extends Product {

    public Desk(Color color, @Min(value = 0) int materialsCount) {
        super(color, materialsCount);
        setProductType(ProductType.DESK);
    }

    public Desk() {
        setProductType(ProductType.DESK);
    }


}
