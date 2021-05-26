package com.example.furnitureFactory.controller.sheetMaterial;

import com.example.furnitureFactory.model.material.Chipboard;
import com.example.furnitureFactory.service.sheetMaterial.ChipboardServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chipboards")
public class ChipboardRestController extends AbstractSheetMaterialRestController<Chipboard, ChipboardServiceImpl> {

    public ChipboardRestController(ChipboardServiceImpl service) {
        super(service);
    }
}
