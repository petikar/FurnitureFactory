package com.example.furnitureFactory.service.sheetMaterial;

import com.example.furnitureFactory.model.material.SheetMaterial;
import com.example.furnitureFactory.repository.sheetMaterial.SheetMaterialBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SheetMaterialServiceImpl<T extends SheetMaterial, R extends SheetMaterialBaseRepository<T>> implements SheetMaterialService<T> {


    private final R repository;

    @Autowired
    public SheetMaterialServiceImpl(R repository) {
        this.repository = repository;
    }


    @Override
    public void save(T newMaterial) {
        T material = findByMaterial(newMaterial);
        if (material != null) {
            int id = material.getId();
            int countMaterials = material.getMaterialsCount();
            newMaterial.setId(id);
            newMaterial.setMaterialsCount(newMaterial.getMaterialsCount() + countMaterials);
        }
        repository.save(newMaterial);
    }

    @Override
    public void update(T newMaterial) {
        repository.save(newMaterial);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(int id) {
        return repository.getOne(id);
    }

    @Override
    public T findByMaterial(T material) {
        return repository.findByMaterial(material);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
