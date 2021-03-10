package com.example.springBoot.model.material;

import com.example.springBoot.model.enumClasses.Color;
import com.example.springBoot.model.enumClasses.MaterialType;
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