package com.example.furnitureFactory.service.sheetMaterial;

import com.example.furnitureFactory.model.material.Glass;
import com.example.furnitureFactory.repository.sheetMaterial.GlassBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class GlassServiceImpl extends SheetMaterialServiceImpl<Glass, GlassBaseRepository> {

    public GlassServiceImpl(GlassBaseRepository repository) {
        super(repository);
    }
}
