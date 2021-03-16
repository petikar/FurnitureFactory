package com.example.v1.service;


import com.example.v1.model.Material;
import com.example.v1.repository.MaterialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public void save(Material newMaterial) {
        Material material = findByMaterial(newMaterial);
        if (material!=null) {
            int id = material.getId();
            int countMaterials = material.getMaterialsCount();
            newMaterial.setId(id);
            newMaterial.setMaterialsCount(newMaterial.getMaterialsCount()+countMaterials);
        }
        materialRepository.save(newMaterial);
    }

    public void update(Material newMaterial){

        materialRepository.save(newMaterial);
    }

    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public Material findById(int id) {
        return materialRepository.getOne(id);
    }

    public Material findByMaterial (Material material){
        Material materialFromDB = materialRepository.findByMaterial(material);
        return materialFromDB;
    }

    public void deleteById(int id) {
        materialRepository.deleteById(id);
    }
}
