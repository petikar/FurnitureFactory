package com.example.furnitureFactory.controller.sheetMaterial;

import com.example.furnitureFactory.model.material.Mdf;
import com.example.furnitureFactory.service.sheetMaterial.MdfServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mdf")
public class MdfRestRestController extends AbstractSheetMaterialRestController<Mdf, MdfServiceImpl> {

    public MdfRestRestController(MdfServiceImpl service) {
        super(service);
    }
}
