package com.example.furnitureFactory.service.product;

import com.example.furnitureFactory.model.product.Chair;
import com.example.furnitureFactory.repository.product.ChairBaseRepository;
import com.example.furnitureFactory.service.sheetMaterial.CommonSheetMaterialServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ChairServiceImpl extends ProductServiceImpl<Chair, ChairBaseRepository> {
    public ChairServiceImpl(ChairBaseRepository repository, CommonSheetMaterialServiceImpl service) {
        super(repository, service);
    }
}
