package com.example.furnitureFactory.controller.product;

import com.example.furnitureFactory.model.product.Desk;
import com.example.furnitureFactory.service.product.DeskServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("desks")
public class DeskRestController extends AbstractProductRestController<Desk, DeskServiceImpl> {
    public DeskRestController(DeskServiceImpl service) {
        super(service);
    }
}
