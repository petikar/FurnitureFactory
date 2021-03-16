package com.example.v1.model;


import com.example.springBoot.model.enumClasses.MaterialType;
import com.example.springBoot.model.enumClasses.Color;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private MaterialType materialType;

    private Color color;

    @Min(value = 0)
    private int materialsCount;

    public Material(Color color, @Min(value = 0) int materialsCount) {
        this.color = color;
        this.materialsCount = materialsCount;
    }

    public Material() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = MaterialType.valueOf(materialType);
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = Color.valueOf(color);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMaterialsCount() {
        return materialsCount;
    }

    public void setMaterialsCount(int count) {
        this.materialsCount = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Material material = (Material) o;

        if (id == material.id) {
            return true;
        } else if (materialType==material.materialType && color==material.color) {
            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, materialType, color);
    }
}
