package com.example.springBoot.model.material;

import com.example.springBoot.model.enumClasses.Color;
import com.example.springBoot.model.enumClasses.MaterialType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Inheritance
public abstract class SheetMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private MaterialType materialType;

    private Color color;

    @Min(value = 0)
    private int materialsCount;

    public SheetMaterial(Color color, @Min(value = 0) int materialsCount) {
        this.color = color;
        this.materialsCount = materialsCount;
    }

    public SheetMaterial() {
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

        SheetMaterial material = (SheetMaterial) o;

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

    @Override
    public String toString() {
        return "SheetMaterial{" +
                "id=" + id +
                ", materialType=" + materialType +
                ", color=" + color +
                ", materialsCount=" + materialsCount +
                '}';
    }
}