package com.example.furnitureFactory.service.product;

import com.example.furnitureFactory.model.product.Desk;
import com.example.furnitureFactory.repository.product.DeskBaseRepository;
import com.example.furnitureFactory.service.sheetMaterial.CommonSheetMaterialServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DeskServiceImpl extends ProductServiceImpl<Desk, DeskBaseRepository> {

    public DeskServiceImpl(DeskBaseRepository repository, CommonSheetMaterialServiceImpl service) {
        super(repository, service);
    }
}