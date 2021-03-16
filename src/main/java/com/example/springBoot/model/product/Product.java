package com.example.springBoot.model.product;

import com.example.springBoot.model.enumClasses.Color;
import com.example.springBoot.model.enumClasses.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Inheritance
@JsonIgnoreProperties({"hibernateLazyInitializer"})

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "productType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Desk.class, name = "DESK"),

        @JsonSubTypes.Type(value = Cupboard.class, name = "CUPBOARD"),

        @JsonSubTypes.Type(value = Chair.class, name = "CHAIR")}
)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private ProductType productType;

    @NotEmpty
    private Color color;

    @Min(value = 0)
    private int productCount;

    public Product(Color color, @Min(value = 0) int productCount) {
        this.color = color;
        this.productCount = productCount;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int materialsCount) {
        this.productCount = materialsCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productType=" + productType +
                ", color=" + color +
                ", productCount=" + productCount +
                '}';
    }
}
