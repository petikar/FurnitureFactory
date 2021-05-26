package com.example.furnitureFactory.service.sheetMaterial;

import com.example.furnitureFactory.model.material.Chipboard;
import com.example.furnitureFactory.repository.sheetMaterial.ChipboardBaseRepository;

import org.springframework.stereotype.Service;

@Service
public class ChipboardServiceImpl extends SheetMaterialServiceImpl<Chipboard, ChipboardBaseRepository> {
    public ChipboardServiceImpl(ChipboardBaseRepository repository) {
        super(repository);
    }
}
