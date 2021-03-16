package com.example.springBoot.controller.product;

import com.example.springBoot.model.product.Cupboard;
import com.example.springBoot.service.product.CupboardServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("cupboards")
public class CupboardRestController extends AbstractProductRestController<Cupboard, CupboardServiceImpl> {
    public CupboardRestController(CupboardServiceImpl service) {
        super(service);
    }
}
