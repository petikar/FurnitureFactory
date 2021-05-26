package com.example.furnitureFactory.controller.product;


import com.example.furnitureFactory.model.product.Chair;
import com.example.furnitureFactory.service.product.ChairServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chairs")
public class ChairRestController extends AbstractProductRestController<Chair, ChairServiceImpl> {
    public ChairRestController(ChairServiceImpl service) {
        super(service);
    }
}
