package com.example.springBoot.service.product;

import com.example.springBoot.model.product.Cupboard;
import com.example.springBoot.repository.product.CupboardBaseRepository;
import com.example.springBoot.service.sheetMaterial.CommonSheetMaterialServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CupboardServiceImpl extends ProductServiceImpl<Cupboard, CupboardBaseRepository> {
    public CupboardServiceImpl(CupboardBaseRepository repository, CommonSheetMaterialServiceImpl service) {
        super(repository, service);
    }
}
