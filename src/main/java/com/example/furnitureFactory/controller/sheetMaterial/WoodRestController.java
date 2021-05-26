package com.example.furnitureFactory.controller.sheetMaterial;

import com.example.furnitureFactory.model.material.Wood;
import com.example.furnitureFactory.service.sheetMaterial.WoodServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("woods")
public class WoodRestController extends AbstractSheetMaterialRestController<Wood, WoodServiceImpl> {
    public WoodRestController(WoodServiceImpl service) {
        super(service);
    }
}
