package com.example.furnitureFactory.service.sheetMaterial;

import com.example.furnitureFactory.model.material.SheetMaterial;

import java.util.List;

public interface SheetMaterialService <T extends SheetMaterial> {

    void save(T newMaterial);

    void update(T newMaterial);

    List<T> findAll();

    T findById(int id);

    T findByMaterial (T material);

    void deleteById(int id);
}
