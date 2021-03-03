package com.example.springBoot.repository.v1;


import com.example.springBoot.model.v1.Material;
import com.example.springBoot.model.enumClasses.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

/*    //this method returns null if element not found
    default Material findByMaterial(Material material) {
        Material material1 = findAll().stream()
                .filter(m -> m.equals(material))
                .findFirst().orElse(null);
        return material1;
    }*/


    default Material findByMaterial(Material material) {
        MaterialType type = material.getMaterialType();
        Color color = material.getColor();

        return findByMaterialTypeAndColor(type, color);
    }

    Material findByMaterialTypeAndColor(MaterialType type, Color color);

    List<Material> findAllByColor(Color color);



/*    Material findByMaterialTypeAndColor(MaterialType type, Color color);

    Material findAllByMaterialType (MaterialType type);*/

}