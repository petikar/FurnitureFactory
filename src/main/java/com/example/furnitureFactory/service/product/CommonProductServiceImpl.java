package com.example.furnitureFactory.service.product;

import com.example.furnitureFactory.model.product.Product;
import com.example.furnitureFactory.repository.product.ProductRepository;
import com.example.furnitureFactory.service.sheetMaterial.CommonSheetMaterialServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CommonProductServiceImpl extends ProductServiceImpl<Product, ProductRepository> {
    public CommonProductServiceImpl(ProductRepository repository, CommonSheetMaterialServiceImpl service) {
        super(repository, service);
    }
}
