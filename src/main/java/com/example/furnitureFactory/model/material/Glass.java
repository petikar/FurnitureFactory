package com.example.furnitureFactory.model.material;

import com.example.furnitureFactory.model.enumClasses.Color;
import com.example.furnitureFactory.model.enumClasses.MaterialType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("glass")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Glass extends SheetMaterial {

    public Glass(Color color, int materialsCount) {
        super(color, materialsCount);
        setMaterialType(MaterialType.GLASS);
    }
    public Glass(){
        setMaterialType(MaterialType.GLASS);
    };


}