package com.example.springBoot.controller.product;


import com.example.springBoot.model.product.Chair;
import com.example.springBoot.service.product.ChairServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chairs")
public class ChairRestController extends AbstractProductRestController<Chair, ChairServiceImpl> {
    public ChairRestController(ChairServiceImpl service) {
        super(service);
    }
}
