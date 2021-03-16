package com.example.springBoot.controller.product;

import com.example.springBoot.model.product.Desk;
import com.example.springBoot.service.product.DeskServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("desks")
public class DeskRestController extends AbstractProductRestController<Desk, DeskServiceImpl> {
    public DeskRestController(DeskServiceImpl service) {
        super(service);
    }
}
