package com.example.springBoot.service.product;

import com.example.springBoot.model.product.Chair;
import com.example.springBoot.repository.product.ChairBaseRepository;
import com.example.springBoot.service.sheetMaterial.CommonSheetMaterialServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ChairServiceImpl extends ProductServiceImpl<Chair, ChairBaseRepository> {
    public ChairServiceImpl(ChairBaseRepository repository, CommonSheetMaterialServiceImpl service) {
        super(repository, service);
    }
}
