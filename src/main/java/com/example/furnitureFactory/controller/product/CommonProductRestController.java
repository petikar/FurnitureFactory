package com.example.furnitureFactory.controller.product;

import com.example.furnitureFactory.model.product.Product;
import com.example.furnitureFactory.service.product.CommonProductServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class CommonProductRestController extends AbstractProductRestController <Product, CommonProductServiceImpl> {
    public CommonProductRestController(CommonProductServiceImpl service) {
        super(service);
    }
}
