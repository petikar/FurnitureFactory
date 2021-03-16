package com.example.springBoot.controller.product;

import com.example.springBoot.model.product.Product;
import com.example.springBoot.service.product.CommonProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class CommonProductRestController extends AbstractProductRestController <Product, CommonProductServiceImpl> {
    public CommonProductRestController(CommonProductServiceImpl service) {
        super(service);
    }
}
