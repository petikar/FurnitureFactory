package com.example.springBoot.model.material;


import com.example.springBoot.model.enumClasses.Color;
import com.example.springBoot.model.enumClasses.MaterialType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@DiscriminatorValue("mdf")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Mdf extends SheetMaterial {

    public Mdf(Color color, int materialsCount) {
        super(color, materialsCount);
        setMaterialType(MaterialType.MDF);
    }

    public Mdf(){
        setMaterialType(MaterialType.MDF);
    };


}
