package com.example.furnitureFactory.model.material;

import com.example.furnitureFactory.model.enumClasses.Color;
import com.example.furnitureFactory.model.enumClasses.MaterialType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("wood")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Wood extends SheetMaterial {

    public Wood(Color color, int materialsCount) {
        super(color, materialsCount);
        setMaterialType(MaterialType.WOOD);
    }
    public Wood(){
        setMaterialType(MaterialType.WOOD);
    };


}
