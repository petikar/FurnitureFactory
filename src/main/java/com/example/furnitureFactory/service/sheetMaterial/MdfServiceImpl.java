package com.example.furnitureFactory.service.sheetMaterial;

import com.example.furnitureFactory.model.material.Mdf;
import com.example.furnitureFactory.repository.sheetMaterial.MdfBaseRepository;

import org.springframework.stereotype.Service;


@Service
public class MdfServiceImpl extends SheetMaterialServiceImpl<Mdf, MdfBaseRepository> {

    public MdfServiceImpl(MdfBaseRepository repository) {
        super(repository);
    }
}
