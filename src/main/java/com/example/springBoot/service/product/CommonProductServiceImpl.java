package com.example.springBoot.service.product;

import com.example.springBoot.model.product.Product;
import com.example.springBoot.repository.product.ProductRepository;
import com.example.springBoot.service.sheetMaterial.CommonSheetMaterialServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CommonProductServiceImpl extends ProductServiceImpl<Product, ProductRepository> {
    public CommonProductServiceImpl(ProductRepository repository, CommonSheetMaterialServiceImpl service) {
        super(repository, service);
    }
}
