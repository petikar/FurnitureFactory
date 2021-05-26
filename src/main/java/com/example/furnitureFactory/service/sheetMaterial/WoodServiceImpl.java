package com.example.furnitureFactory.service.sheetMaterial;

import com.example.furnitureFactory.model.material.Wood;
import com.example.furnitureFactory.repository.sheetMaterial.WoodBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class WoodServiceImpl extends SheetMaterialServiceImpl<Wood, WoodBaseRepository> {
    public WoodServiceImpl(WoodBaseRepository repository) {
        super(repository);
    }
}
