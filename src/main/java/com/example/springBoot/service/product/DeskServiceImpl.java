package com.example.springBoot.service.product;

import com.example.springBoot.model.product.Desk;
import com.example.springBoot.repository.product.DeskBaseRepository;
import com.example.springBoot.service.sheetMaterial.CommonSheetMaterialServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DeskServiceImpl extends ProductServiceImpl<Desk, DeskBaseRepository> {

    public DeskServiceImpl(DeskBaseRepository repository, CommonSheetMaterialServiceImpl service) {
        super(repository, service);
    }
}