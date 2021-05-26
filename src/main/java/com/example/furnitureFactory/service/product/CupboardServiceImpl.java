package com.example.furnitureFactory.service.product;

import com.example.furnitureFactory.model.product.Cupboard;
import com.example.furnitureFactory.repository.product.CupboardBaseRepository;
import com.example.furnitureFactory.service.sheetMaterial.CommonSheetMaterialServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CupboardServiceImpl extends ProductServiceImpl<Cupboard, CupboardBaseRepository> {
    public CupboardServiceImpl(CupboardBaseRepository repository, CommonSheetMaterialServiceImpl service) {
        super(repository, service);
    }
}
