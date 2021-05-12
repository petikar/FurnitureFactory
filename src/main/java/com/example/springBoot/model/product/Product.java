package com.example.springBoot.model.product;

import com.example.springBoot.model.enumClasses.Color;
import com.example.springBoot.model.enumClasses.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

    @Enumerated(value = EnumType.STRING)
    private ProductType productType;

    @Enumerated(value = EnumType.STRING)
    private Color color;

    @Min(value = 0)
    private int productsCount;

    public Product(Color color, @Min(value = 0) int productsCount) {
        this.color = color;
        this.productsCount = productsCount;
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

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int materialsCount) {
        this.productsCount = materialsCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productType=" + productType +
                ", color=" + color +
                ", productsCount=" + productsCount +
                '}';
    }
}
