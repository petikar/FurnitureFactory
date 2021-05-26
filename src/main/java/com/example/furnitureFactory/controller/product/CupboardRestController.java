package com.example.furnitureFactory.controller.product;

import com.example.furnitureFactory.model.product.Cupboard;
import com.example.furnitureFactory.service.product.CupboardServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("cupboards")
public class CupboardRestController extends AbstractProductRestController<Cupboard, CupboardServiceImpl> {
    public CupboardRestController(CupboardServiceImpl service) {
        super(service);
    }
}
