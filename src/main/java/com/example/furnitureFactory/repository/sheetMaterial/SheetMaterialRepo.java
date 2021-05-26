package com.example.furnitureFactory.repository.sheetMaterial;

import com.example.furnitureFactory.model.material.SheetMaterial;
import com.example.furnitureFactory.model.enumClasses.Color;
import com.example.furnitureFactory.model.enumClasses.MaterialType;

import java.util.List;

public interface SheetMaterialRepo <T extends SheetMaterial> {

    default T findByMaterial(T material) {
        MaterialType type = material.getMaterialType();
        Color color = material.getColor();

        return findByMaterialTypeAndColor(type, color);
    }

    T findByMaterialTypeAndColor(MaterialType type, Color color);

    List<T> findAllByColor(Color color);
}
